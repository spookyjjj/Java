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
	
	@Override
	public String toString() {
		return super.toString() + "\n발행일: " + date;
	}
}

public class P264_4 {

	public static void main(String[] args) {
		Magazine m = new Magazine("안녕", 120, "민음사", "22년 6월호");
		System.out.println(m.toString());
	}

}
