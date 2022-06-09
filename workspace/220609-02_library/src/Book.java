import java.util.Scanner;

//도서관리 프로그램
//1. 가격순으로(오름차순, 내림차순 선택가능)
//2. 분야를 선택해서 해당 분야만 보기
//3. 상세보기
//4. 도서 정보 수정
//5. 도서 정보 추가
//책 데이터----
// 1. 작별인사 					    / 김영하 / 복복서가 / 장편소설 / 12,600원
// 2. 불편한 편의점 					/ 김호연 / 나무옆의자 / 장편소설 / 12,600원
// 3. 지금 알고 있는 걸 그때도 알았더라면 	/ 류시화 / 열림원 / 시집 / 8,100원
// 4. 코스모스						/ 칼 세이건 / 사이언스북스 / 과학 공학 / 16,650원
// 5. 여행의 이유					/ 김영하 / 문학동네 / 에세이 / 12,150원

class Book {
	private String title;
	private String author;
	private String publisher;
	private String genre;
	private int price;
	
	public Book() {}
	public Book(String title, String author, String publisher, String genre, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getGenre() {
		return genre;
	}
	public int getPrice() {
		return price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() { //Book을 출력문에 넣으면 이렇게 나옴
		return String.format("%-15s / %-5s / %-5s / %-5s / %,d원",title,author,publisher,genre,price);
//		return (title + " / " + author + " / " + publisher + " / " + genre + " / " + price + "원");
	}
	
	//책 한권을 추가하는 메소드
	public static Book makeBook() {
		Scanner scan = new Scanner(System.in);
		Book a = new Book();
		System.out.print("책제목?");
		a.setTitle(scan.nextLine());
		System.out.print("저자?");
		a.setAuthor(scan.nextLine());
		System.out.print("출판사?");
		a.setPublisher(scan.nextLine());
		System.out.print("장르?");
		a.setGenre(scan.nextLine());
		System.out.print("가격?");
		a.setPrice(scan.nextInt());
		return a;
	}
}
