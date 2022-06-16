import java.util.Arrays;

class Student implements Comparable {
	private String name;
	private double gpa;
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	public String getName() {
		return name;
	}
	public double getGpa() {
		return gpa;
	}
	public int compareTo(Object o) {
		Student other = (Student) o;
		if (gpa < other.gpa) return -1;
		else if (gpa > other.gpa) return 1;
		else return 0;
	}
//★String클래스에서 compareTo를 오버라이드 해놓은게 사용됨! 사전적으로 빠른게 본인이면 양수, 느리면 음수, 같으면 0//	}
//	public int compareTo(Object o) { 
//		Student other = (Student) o;
//		return name.compareTo(other.name);
	
}
public class StudentTest {
	public static void main(String[] args) {
		Student[] students = new Student[3];
		students[0] = new Student("홍길동", 3.39);
		students[1] = new Student("임꺽정", 4.21);
		students[2] = new Student("황진이", 2.19);
		Arrays.sort(students);
		for(Student s : students) System.out.println("이름: " + s.getName() + " 평점: " + s.getGpa());
	}

}
