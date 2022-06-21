import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//학생, 이름, 나이
//(이름과 나이가 같으면 동일 학생)

//홍길동 15
//둘리 22
//도우너 33

//위 학생들을 원소로 가지는 리스트를 생성하고
//(도우너 33)학생의 인덱스를 찾아보셈
class Student implements Comparable<Student> {
	private String name;
	private int age;
	private int score;
	public Student(String name, int age, int score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Student o) {
		return this.score - o.score;
	}
	
}
public class T0621 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 15, 90));
		list.add(new Student("둘리", 22, 80));
		list.add(new Student("도우너", 33, 33));
		
		System.out.println(list);
		System.out.println("도우너33의 인덱스: " + list.indexOf(new Student("도우너", 33, 0)));
		
		//점수순 정렬
		Collections.sort(list); //비교 기준을 세워줘야 정렬가능
		System.out.println(list);
		
		//또다른 정렬기준 세우고 싶다! 나이순
		Comparator<Student> a = new Comparator<Student>() {
			@Override
			public int compare(Student a, Student b) {
				return a.getAge() - b.getAge();
			}
		};
		
		Collections.sort(list, a); //list를 Comparator a 객체기준으로 정렬하겠다! 
		System.out.println(list);
	}

}
