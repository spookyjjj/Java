
public class Author extends Person {
	private String bookList;
	
	public String getBookList() {
		return bookList;
	}
	
	public Author(String name, int age, String bookList) {
		//this.name = name; //this에는 더이상 name이란 필드가 없다
		//super.name = name; //super에 존재하는 필드는 private라 접근이 안된다
		super(name, age); //★얘도 생성자안에 생성자를 쓰고 있으니 첫문장이여야 한다~!!
		this.bookList = bookList;
	}
}
