import java.util.Scanner;

class Student {
	private String name;
	private int id;
	private String major;
	private int grade;
	private int point;
	
	
	public Student(String name, int id, String major, int grade, int point) {
		this.name = name;
		this.id = id;
		this.major = major;
		this.grade = grade;
		this.point = point;
	}


	public String toString() {
		return "이름: " + name + "\n학번: " + id + "\n학부: " + major + "\n학년: " + grade + "\n이수학점: " + point;
	}
}

class UnderGraduate extends Student {
	private String club;
	
	
	public UnderGraduate(String name, int id, String major, int grade, int point, String club) {
		super(name, id, major, grade, point);
		this.club = club;
	}


	@Override
	public String toString() {
		return "==학부생==\n" + super.toString() + "\n소속 동아리: " + club;
	}
}

class Graduate extends Student {
	private String assistant;
	private double scholarshipRatio;
	
	
	public Graduate(String name, int id, String major, int grade, int point, String assistant, double scholarshipRatio) {
		super(name, id, major, grade, point);
		this.assistant = assistant;
		this.scholarshipRatio = scholarshipRatio;
	}
	public Graduate(String name, int id, String major, int grade, int point) {
		super(name, id, major, grade, point);
	}
	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}
	public void setScholarshipRatio(double scholarshipRatio) {
		this.scholarshipRatio = scholarshipRatio;
	}
	
	@Override
	public String toString() {
		return "==대학원생==\n" + super.toString() + "\n조교유형: " + assistant + "\n장학금 비율: " + scholarshipRatio;
	}
		
	public boolean isOk(String s) {
		return s.equals("교육조교") || s.equals("연구조교");
	}
	public String inputAssistant() {
		Scanner scan = new Scanner(System.in);
		String s;
		do {
			System.out.println("조교 유형?");
			s = scan.next();
			if (!isOk(s)) {
				System.out.println("해당하는 조교 유형이 없습니다");
			}
		} while(!isOk(s));
		return s;
	}
	
	public boolean isOk(double d) {
		return d >= 0 && d <= 1;
	}
	public double inputscholarshipRatio() {
		Scanner scan = new Scanner(System.in);
		double d;
		do {
			System.out.println("장학금 비율?");
			d = scan.nextDouble();
			if (!isOk(d)) {
				System.out.println("장학금 비율은 1을 넘을 수 없습니다");
			}
		} while(!isOk(d));
		return d;
	}
	
}
public class P264_7 {

	public static void main(String[] args) {
		UnderGraduate s1 = new UnderGraduate("민정", 20180525, "이과대", 3, 20, "봉사동아리");
		Graduate s2 = new Graduate("석훈", 20152654, "인문대", 2, 18);
		s2.setAssistant(s2.inputAssistant());
		s2.setScholarshipRatio(s2.inputscholarshipRatio());
		System.out.println(s1);
		System.out.println(s2);

	}

}
