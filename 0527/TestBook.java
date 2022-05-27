//1. 책 클래스 //필드 : 제목 저자 //메소드 : 제목과 저자를 콘솔에 출력
class Book {
	String title;
	String author;
	
	void printAll() { 
		System.out.println("책 제목: " + title);
		System.out.println("저자: " + author);
	}
	
	// void printAll(String title, String author){
		// System.out.println("책 제목: " + title);
		// System.out.println("저자: " + author);
	// }
}

public class TestBook {
	public static void main(String arg[]) {
		Book b = new Book();
		b.title = "그것이 알고싶다";
		b.author = "김상중";
		b.printAll(); 
		
		// Book b = new Book();
		// b.printAll("저것도 알고싶다", "김하중");
	}
}