
public class Main {

	public static void main(String[] args) {
		Person p = new Person("사람이름", 22);
		Student s = new Student("학생이름", 17, 90);
		Author a = new Author("작가이름", 30, "반지의길");
		
//		System.out.println(p.getScore()); //person class에는 score가 없다
		System.out.println(s.getName());
		System.out.println(s.getScore());
		System.out.println(a.getName());
		System.out.println(a.getBookList());
		
	}

}
