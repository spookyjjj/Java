//학급(반)
//학생1 핟생2 학생3
//1. 3명 학생이름 콘솔 출력 가능
//2. 학급의 평균 알 수 있음
//3. 평균이 가장 놓은 학생(참조)를 알려 줄 수 있음. 동일 점수일 경우 1,2,3순
public class Room {
	private Student s1;
	private Student s2;
	private Student s3;
	
	public Room(Student s1, Student s2, Student s3) {
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	public void printAllStudent() {
		System.out.printf("%s %s %s\n", s1.getName(), s2.getName(), s3.getName());
	}
	public int roomAver() {
		return (s1.getAver() + s2.getAver() + s3.getAver()) / 3;
	}
	public Student roomTop() { //동일평균이면 한명만 보여주는데, 보여줄 우선순위가 1 2 3 순서인 case
		Student top;
		if ((s1.getAver() >= s2.getAver()) && (s1.getAver() >= s3.getAver())) {
			top = s1;
		} else if (s2.getAver() >= s3.getAver()) {
			top = s2;
		} else {
			top = s3;
		}
		return top;
	}
	// 동일 평균이면 그애들 다 보여주는데 출력순서가 1 2 3
	// 최대값 애 한명 구하고, 걔 평균이랑 동일이면 문자열에 추가하는 방법으로..
	public Student compare(Student a, Student b) {
		if (a.getAver() >= b.getAver()) {
			return a;
		} else {
			return b;
		}
	}
	public void top() {
		String print = "1등 : ";
		int t = compare(s3, compare(s1, s2)).getAver();
		if (t == s1.getAver()) {
			print = print + s1.getName() + " ";
		} 
		if (t == s2.getAver()) {
			print = print + s2.getName() + " ";
		} 
		if (t == s3.getAver()) {
			print = print + s3.getName() + " ";
		} 
		System.out.println(print);
	}
	//동일 평균이면 그애들 다 보여주는데 출력순서가 1 2 3
	public Student compare2(Student a, Student b) {
		if (a.getAver() == b.getAver()) {
			return null;
		} else if (a.getAver() > b.getAver()) {
			return a;
		} else {
			return b;
		}
	}
	public void top2() { //Student를 리턴 타입으로 해서 변수 2개, 3개를 리턴 받는건 불가능?? 응 불가능
		if(compare2(s1, s2) == null) {
			if(compare2(s1, s3) == null) {
				System.out.printf("공동1등 : %s, %s, %s\n", s1.getName(), s2.getName(), s3.getName());
			} else if (compare2(s1, s3).equals(s1)) {
				System.out.printf("공동1등 : %s, %s\n", s1.getName(), s2.getName());
			} else {
				System.out.println(s3.getName());
			}
		} else if (compare2(s3, compare2(s1, s2)) == null) {
				System.out.printf("공동1등 : %s, %s\n", compare2(s1, s2).getName(), s3.getName());
		} else {
				System.out.println(compare2(s3, compare2(s1, s2)).getName());
		}
	}
	
//	public void roomMaxName() {
//		if (s1.getAver() == s2.getAver() && s1.getAver() == s3.getAver()) {
//			System.out.printf("공동1등 : %s, %s, %s", s1.getName(), s2.getName(), s3.getName());
//		} else if (s1.getAver() == s2.getAver()) {
//			if (s1.getAver() > s3.getAver()) {
//				System.out.printf("공동1등 : %s, %s", s1.getName(), s2.getName());
//			} else {
//				System.out.println(s3.getName());
//			}
//		} else if (s1.getAver() == s3.getAver()) {
//			if (s1.getAver() > s2.getAver()) {
//				System.out.printf("공동1등 : %s, %s", s1.getName(), s3.getName());
//			} else {
//				System.out.println(s2.getName());
//			}
//		} else if (s2.getAver() == s3.getAver()) {
//			if (s1.getAver() > s2.getAver()) {
//				System.out.println(s1.getName());
//			} else {
//				System.out.printf("공동1등 : %s, %s", s2.getName(), s3.getName());
//			}
//		} else if (s1.getAver() > s2.getAver() && s1.getAver() > s3.getAver()) {
//			System.out.println(s1.getName());
//		} else if (s2.getAver() > s1.getAver() && s2.getAver() > s3.getAver()) {
//			System.out.println(s2.getName());
//		} else if (s3.getAver() > s1.getAver() && s3.getAver() > s2.getAver()) {
//			System.out.println(s3.getName());
//		}
//	}
}
