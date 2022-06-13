import java.util.Arrays;
import java.util.Scanner;

public class Library {
	private Book[] books = new Book[5];
	
	public Book[] getBooks() {
		return books;
	}
	public void setBooks(Book[] books) {
		this.books = books;
	}
//	public Library(Book... books) { //Book이 여러개 오면 library[0]부터 차곡차곡 쌓임
//		this.books = books;
//	}
	public Library() { //기본적으로 도서관에 꽂혀있는 책들,,기본생성자
		//this(b1, b2, b3, b4, b5); //★애는 항상 첫줄에 있어야 한다!! 생성자는 검색은 this로!!
		Book b1 = new Book("작별인사","김영하","복복서가","장편소설",12600);
		Book b2 = new Book("불편한 편의점 ","김호연","나무옆의자","장편소설",12600);
		Book b3 = new Book("지금 알고 있는 걸 그때도 알았더라면","류시화","열림원","시집",8100);
		Book b4 = new Book("코스모스","칼 세이건","사이언스북스","공상과학",16650);
		Book b5 = new Book("여행의 이유","김영하","문학동네","에세이",12150);
		books[0] = b1;
		books[1] = b2;
		books[2] = b3;
		books[3] = b4;
		books[4] = b5;
	}
	
	//책장 한 칸 늘리고 거기에 새책 하나 넣는 메소드-----------------------------------
	public Book[] expand(Book b) { //넣을 새 책
		setBooks(Arrays.copyOf(books, books.length + 1)); //책장 확장
		books[books.length - 1] = b; //새 책 넣기
		return books;
	}
	
	//현재 보유중인 책들의 제목을 출력하는 메소드------------------------------------
	public void showInfoWithNum() {
		for (int i = 0; i < books.length; i++) {
			System.out.println((i + 1) + ". " + books[i]);
		}
	}
	public void showInfo() { //라이브리에 보관된 책들 출력하는거고
		for (int i = 0; i < books.length; i++) {
			System.out.println("◇ " + books[i]);
		}
	}
	
	//정보를 변경하는 메소드--------------------------------------------------
	public void changeInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 책의 번호는 무엇입니까?");
		showInfoWithNum();
		int bookNum = scan.nextInt();
		scan.nextLine(); //nextInt 다음에 공백 제거
		if (bookNum >= 1 && bookNum <= books.length) {
			System.out.println("수정할 부분은 어디입니까?");
			System.out.println("책제목  / 저자  / 출판사  / 분야  / 가격");
			String section = scan.next();
			scan.nextLine(); //scan.next() 다음에 공백 제거
			System.out.println("수정할 내용을 입력해 주세요");
			if (section.equals("책제목")) {
				books[bookNum - 1].setTitle(scan.nextLine());
				System.out.println("수정완료");
			} else if (section.equals("저자")) {
				books[bookNum - 1].setAuthor(scan.nextLine());
				System.out.println("수정완료");
			} else if (section.equals("출판사")) {
				books[bookNum - 1].setPublisher(scan.nextLine());
				System.out.println("수정완료");
			} else if (section.equals("분야")) {
				books[bookNum - 1].setGenre(scan.nextLine());
				System.out.println("수정완료");
			} else if (section.equals("가격")) {
				books[bookNum - 1].setPrice(scan.nextInt());
				scan.nextLine();// nextInt 다음의 공백 없애기
				System.out.println("수정완료");
			} else {
				System.out.println("잘못된 입력입니다"); //여기 손봐야한다~~~~~~
			}
		} else {
			System.out.println("없는 번호를 입력하셨습니다");
		}
	}
	
	//장르별 검색---------------------------------------------------
	public void searchGenre(String s) {
		int count = 0;
		for (Book b : books) {
			if (b.getGenre().equals(s)) {
				System.out.println(b);
				count++;
			} 
		}
		if (count == 0) {
			System.out.println("해당하는 분야의 책이 없습니다");
		}
	}
	
	//가격비교------------------------------------------------------
	//Book a Book b가져와서 두개의 가격만 뽑아낸다음 max인 Book만 리턴
	private Book max(Book a, Book b) {
		Book max;
		if (a.getPrice() >= b.getPrice()) {
			max = a;
		} else {
			max = b;
		}
		return max;
	}
	//max의 인덱스 알아내기
	private int findMaxIndex(Book[] books, Book max) {
		for (int i = 0;  i < books.length; i++) {
			if (max.getTitle().equals(books[i].getTitle())) { //같은 가격찾으면 같은가격의 다른책때매 오류나나깐 걍 이름으로 훑음
				return i;
			}
		}
		return -1;
	}
	
	//가격 배열 min<- 0 1 2 3 4 .. ->max
	//books의 길이만큼의 똑같은 배열을 새로 만들어서
	//5개 비교해서 인덱스 4번 위치의 책과 max책을 바꿔넣기~~max의 인덱스를 알아내야겠다..
	//그담에 4번인덱스 빼고 나머지 4개 비교해서 max과 인데스 3번을 바꿔 넣고 .. 반복..
	private Book[] reOrgByPrice(Book[] books) {
		Book[] re = Arrays.copyOf(books, books.length); //re라는 카피본 생성
//		Book max = re[0];
//		for (int i = 0; i < re.length; i++) { 
//			max = max(max, re[i]);
//		}
//		Book tem = re[re.length - 1]; //마지막 자리 값 담아두기
//		re[re.length - 1] = max; //마지막 자리에 max정보 연결
//		int index = findMaxIndex(re, max);
//		re[index] = tem; //max 가져간 빈자리에 마지막 자리 값 넣기
//		
//		max = re[0];
//		for (int i = 0; i < re.length - 2; i++) { 
//			max = max(max, re[i + 1]);
//		}
//		tem = re[re.length - 2]; //마지막 자리 값 담아두기 -1
//		re[re.length - 2] = max; //마지막 자리에 max정보 연결
//		index = findMaxIndex(re, max);
//		re[index] = tem; //max 가져간 빈자리에 마지막 자리 값 넣기
//		
//		max = re[0];
//		for (int i = 0; i < re.length - 3; i++) { 
//			max = max(max, re[i + 1]);
//		}
//		tem = re[re.length - 3]; //마지막 자리 값 담아두기 -2
//		re[re.length - 3] = max; //마지막 자리에 max정보 연결
//		index = findMaxIndex(re, max);
//		re[index] = tem; //max 가져간 빈자리에 마지막 자리 값 넣기
//		
//		return re;

		//언제까지? 빼는 수가 books.length될때 까지
		Book max;
		Book tem;
		int index;
		for (int j = 1; j <= re.length; j++) {
			max = re[0];
			for (int i = 1; i <= re.length - j; i++) { 
				max = max(max, re[i]);
			}
			tem = re[re.length - j]; //마지막 자리 값 tem에 담아두기
			index = findMaxIndex(re, max); //배열 바뀌기 전에 max의 인덱스 외워두고
			re[re.length - j] = max; //끝자리로 큰 수 넣어서 배열 바꿈
			re[index] = tem; //max 가져간 빈자리에 마지막 자리 값 넣기
		}		
		return re;
	}
	
	//위에꺼 43210출력하면 내림차순
	public void printPriceDown() {
		Book[] re = reOrgByPrice(books);
		for (int i = re.length - 1; i >= 0; i--) {
			System.out.println(re[i]);
		}
	}
	//위에꺼 01234출력하면 오름차순
	public void printPriceUp() {
		Book[] re = reOrgByPrice(books);
		for (int i = 0; i < re.length; i++) {
			System.out.println(re[i]);
		}
	}
	//-----------학우가 쓴 방법 : 버블sort(★정렬 알고리즘)-------------
//	public Book[] getDownSeq() {
//		Book temp = new Book();
//		for (int i = 0; i < books.length - 1; i++) {
//			for (int j = i + 1; j < books.length; j++) {
//				if (books[i].getPrice() < books[j].getPrice()) {
//					temp = books[i];
//					books[i] = books[j];
//					books[j] = temp;
//				} else if (books[i].getPrice() == books[j].getPrice()) {
//					if (books[i].getTitle().length() < books[j].getTitle().length()) {
//						temp = books[i];
//						books[i] = books[j];
//						books[j] = temp;
//					}
//				}
//			}
//		}
//		return books;
//	}
}
