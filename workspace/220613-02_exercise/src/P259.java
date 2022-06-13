class Human {
	private String name;
	private int age;
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "이름: " + name + ", 나이: " + age;
	}
	
	public String getProfession() {
		return "현재 직업";
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}

class Student2 extends Human { 
	private String major;
	
	public Student2(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}
	
	@Override //이것도 결국에는 오버라이드라는것 파악하기!!
	public String toString() {
		return super.toString() + ", 전공: " + major;
	}
	
	@Override
	public String getProfession() {
		return "학생";
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}

public class P259 {
	public static void main(String[] args) {
		Human h1 = new Human("춘향", 18);
		Human h2 = new Human("몽룡", 21);
		Human h3 = new Human("사또", 50);
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
		System.out.println(h3.getProfession());
		
		Student2 s1 = new Student2("명진", 21, "컴퓨터");
		Student2 s2 = new Student2("미형", 22, "경영");
		Student2 s3 = new Student2("용준", 24, "경제");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s3.getProfession());
	}

}
