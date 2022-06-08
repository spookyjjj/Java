import java.util.Scanner;
public class Manage {
	/* 
	******선생님 풀이******
	private Room r; //★Manage에서 쓸 Room을 아예 필드값으로 가져옴! 이름은 r
	public Student inputStudent() { //★리턴으로 Student를 받는다는것!!
		Scanner scan = new Scanner(System.in);
		System.out.println("학생의 정보, 이름, 국영수 순으로 입력해 주세요");
		String name = scan.nextLine();
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		
		return new Student(name, kor, eng, math);
	}
	public void start() {
		Student s1 = inputStudent();
		Student s2 = inputStudent();
		Student s3 = inputStudent();
		
		r = new Room(s1, s2, s3);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴");
		System.out.println("1.학생이름보기 2.총 평균 보기 3.1등보기");
		int num = scan.nextInt();
		
		if (num == 1) {
			r.printAllStudent();
		} else if (num == 2) {
			System.out.println("총 평균" + r.roomAver());
		} else if (num == 3) {
			Student top = r.roomTop();
			System.out.println(r.roomTop().getName(), r.roomTop().getAver());
		}
	}
}
*/
	Scanner s = new Scanner(System.in);
	Room r = new Room();
	public void manage() {
		System.out.println("---반을 구성합니다---\n학생 정보를 입력해주세요.");
		Student s1 = new Student(studentNameInput(),studentKorInput(),studentEngInput(),studentMathInput());
		System.out.println("학생 등록이 완료되었습니다. (1명)");
		r.setS1(s1);
		Student s2 = new Student(studentNameInput(),studentKorInput(),studentEngInput(),studentMathInput());
		System.out.println("학생 등록이 완료되었습니다. (2명)");
		r.setS2(s2);
		Student s3 = new Student(studentNameInput(),studentKorInput(),studentEngInput(),studentMathInput());
		System.out.println("학생 등록이 완료되었습니다. (3명)");
		r.setS3(s3);
		
		while (true) {
			int m = menu();
			if (m == 1) {
				while (true) {
					r.printAllStudent();
					int num = selectDetail();
					if (num == 0) {
						break;
					} else if (num == 1) {
						s1.showDetail();
					} else if (num == 2) {
						s2.showDetail();
					} else if (num == 3) {
						s3.showDetail();
					}
				}
			}
			if (m == 2) {	
				r.printAllStudent();
				changeStudent(selectChange());
			} 
			if (m == 3) {
					System.out.printf("반 평균은 %d점 입니다\n", r.roomAver());
			}
			if (m == 4) {
				r.top2();
			}
			if (m == 5) {
				break;
			}
		}	
	}
	private int menu() {
		System.out.println("---원하는 행동을 입력하십시오---\n1.반 구성원 보기\n2.반 구성원 변경\n3.반 평균\n4.반 1등\n5.종료");
		return s.nextInt();
	}
	private String studentNameInput() { //이렇게 하지 않고 String받는 메소드 하나
		System.out.print("학생의 이름은 무엇입니까? ");
		return s.next();
	}
	private int studentKorInput() { //Int 받는 메소드 하나 만들어서 범용성 있게 쓰는것도 좋음~ 대신 안내글은 없겠지만...
		System.out.print("그 학생의 국어 점수는 몇 점 입니까? ");
		return s.nextInt();
	}
	private int studentEngInput() {
		System.out.print("그 학생의 영어 점수는 몇 점 입니까? ");
		return s.nextInt();
	}
	private int studentMathInput() {
		System.out.print("그 학생의 수학 점수는 몇 점 입니까? ");
		return s.nextInt();
	}
	private int selectDetail() {
		System.out.println("세부정보를 알고자 하는 학생을 선택하십시오. 이전메뉴로 돌아가기는 0");
		return s.nextInt();
	}
	private int selectChange() {
		System.out.println("빼고자 하는 학생을 선택하십시오.");
		return s.nextInt();
	}
	private void changeStudent(int a) {
		if (a == 1) {
			System.out.println("새로운 학생의 정보를 입력합니다");
			r.getS1().setName(studentNameInput());
			r.getS1().setKor(studentKorInput());
			r.getS1().setEng(studentEngInput());
			r.getS1().setMath(studentMathInput());					
		} else if (a == 2) {
			System.out.println("새로운 학생의 정보를 입력합니다");
			r.getS2().setName(studentNameInput());
			r.getS2().setKor(studentKorInput());
			r.getS2().setEng(studentEngInput());
			r.getS2().setMath(studentMathInput());		
		} else if (a == 3) {
			System.out.println("새로운 학생의 정보를 입력합니다");
			r.getS3().setName(studentNameInput());
			r.getS3().setKor(studentKorInput());
			r.getS3().setEng(studentEngInput());
			r.getS3().setMath(studentMathInput());		
		} else {
			System.out.println("학생 번호를 확인 후 다시 시도해 주세요");
		}
	}
}
//학생을 이름 으로 찾아 정보출력하기 (.equals()이용)
//학생의 특정 정보만을 수정하는 메소드
//학생정보를 여러개 저장해 놓고 골라서 반에 담기