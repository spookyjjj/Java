
public class Room {
	private Student s1;
	private Student s2;
	private Student s3;
	
	public Room(Student s1, Student s2, Student s3) {
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}

	public Room() { //기본생성자 만들어 두고, set으로 끼워넣기
	}
	
	public void setS1(Student s1) { //반 구성원 변경을 위해서 setter설정
		this.s1 = s1;
	}

	public void setS2(Student s2) {
		this.s2 = s2;
	}

	public void setS3(Student s3) {
		this.s3 = s3;
	}
	

	public Student getS1() { //반의 Student개개인을 데리고 오기 위해 생성
		return s1;
	}

	public Student getS2() {
		return s2;
	}

	public Student getS3() {
		return s3;
	}

	public void printAllStudent() { //순번을 주어주기 위해 번호를 추가함
		System.out.printf("1.%s, 2.%s, 3.%s\n", s1.getName(), s2.getName(), s3.getName()); 
	}
	public int roomAver() {
		return (s1.getAver() + s2.getAver() + s3.getAver()) / 3;
	}
	//동일평균이면 한명만 보여주는데, 보여줄 우선순위가 1 2 3 순서인 case
	public Student roomTop() { 
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
				System.out.printf("공동1등 : %s, %s, %s\n1등 평균: %d\n", s1.getName(), s2.getName(), s3.getName(), s1.getAver());
			} else if (compare2(s1, s3).equals(s1)) {
				System.out.printf("공동1등 : %s, %s\n1등 평균: %d\n", s1.getName(), s2.getName(), s1.getAver());
			} else {
				System.out.printf("1등 : %s\n1등 평균: %d\n", s3.getName(), s3.getAver());
			}
		} else if (compare2(s3, compare2(s1, s2)) == null) {
				System.out.printf("공동1등 : %s, %s\n1등 평균: %d\n", compare2(s1, s2).getName(), s3.getName(), s3.getAver());
		} else {
				System.out.printf("1등 : %s\n1등 평균: %d\n", compare2(s3, compare2(s1, s2)).getName(), compare2(s3, compare2(s1, s2)).getAver());
		}
	}
}
