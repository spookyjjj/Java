class Book {
	private String title;
	private int pages;
	private String author;
	
	public Book(String title, int pages, String author) {
		this.title = title;
		this.pages = pages;
		this.author = author;
	}
	
	public String toString() {
		return "제목: " + title + "\n페이지 수: " + pages + "\n저자: " + author;
	}
}

class Magazine extends Book {
	private String date;

	public Magazine(String title, int pages, String author, String date) {
		super(title, pages, author);
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n발행일: " + date;
	}
}

public class P264_4 {

	public static void main(String[] args) {
		Magazine m = new Magazine("안녕", 120, "민음사", "22년 6월호");
		System.out.println(m.toString());
		
		
		//=========다형성==============
		Book b = new Magazine("잡지", 200, "생각", "22년 5월호");
		//Magazine로 인스턴스 생성 후, Book으로 형변환 할 수 있다!  ★상향형변환(Upcasting)
		//대신 book에 있는 필드와 메소드만 사용됨 (Magazine에서 확장된 필드와 메소드는 사용 안됨 ★but, override했다면 Magazine의것 실행)
//		System.out.println(b.getDate()); //Magazine의 getDate()메소드를 찾지 못함
		System.out.println(b.toString()); //하지만 override한 toString을 실행하면 Magazine의것이 실행됨
		Magazine m2 = (Magazine) b;
		//Book타입에서 Magazine타입으로도 형변환 가능! ★하향형변환(Downcasting): 단, 의식적 형변환이 필요하며 변환할 놈의 인스턴스생성이 애초에 Magazine이었어야함
		//이제 다시 Magazine에서 쓰던 필드와 메소드 사용 가능!
		
		//★하향형변환시 instanceof사용해 인스턴스가 애초에 뭐였는지 확인하는 과정 필요
		Book b2 = new Book("소설", 350, "황금가지");
//		Magazine m3 = (Magazine) b2; //컴파일은 되지만, 실행할때 오류가 발생! 책일 뿐, 소설일 수도 잡지일 수도 있는데 잡지로 형변환시키려하니..
		if (b2 instanceof Magazine) { //So 인스턴스가 매거진인 경우에만 하향형변환 하겠다는 조건문이 필요하게됨
			Magazine m4 = (Magazine) b2;
		}
	}

}
