import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book> {
	private String title;
	private int price;
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() { //이거임!! 해시코드 오버라이드~!
		return Objects.hash(price, title); 
		//Objects.hash(Object1, Object2) 메소드를 이용하면 쉬움!!
		//	-> Object1,Object2의 입력값이 같으면 같은 코드를 만들어내는 메소드임~~
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return price == other.price && Objects.equals(title, other.title);
	}
	@Override
	public int compareTo(Book b) {
		return title.compareTo(b.title);
	}
}
public class Main7 {

	public static void main(String[] args) {
		Book b1 = new Book("책1", 5000);
		Book b2 = new Book("책1", 5000);
		Book b3 = new Book("책2", 7000);
		
		System.out.println(b1.equals(b2)); //우리가 설정한 equals를 기준으로 같음체크
		System.out.println(b1.equals(b3));
		
		Set<Book> set = new HashSet<>(); //우리가 설정한 equals를 기준으로 바로 중복 제외 가능? NOoo...
		//★hash(숫자값)를 기준으로 먼저 보고 같으면 더 정확하게 보려고 equals찾아감 -> 그래서 hashset인거임  
		//1차로 hash값이 다 다르면 중복 아니니깐 다 집어넣게되고
		//1차로 hash값이 다 같으면 중복인가? 싶어서 equals보러감!
		//★일반적으로 hashcode는 객체생성될때마다 다른값으로 주어짐 title price같을때 같은 해쉬값을 가지도록 Override해줘야함!
		set.add(b1);
		set.add(b2);
		set.add(b3);
		
		System.out.println(set.size());
		System.out.println(set);
		
		
		
		
		Set<Book> set2 = new TreeSet<>();
		//implements Comparable<Book> 하기전,
//		set2.add(b1); //(X) 대소비교가 안되니 애초에 담을수조차 없다!
//		set2.add(b2);
//		set2.add(b3);
		//implements Comparable<Book> 한 후, -> title을 기준으로
		set2.add(b1);
		set2.add(b2);
		set2.add(b3);
		
		System.out.println(set2.size());
		System.out.println(set2);
		
		
		
		
		//이번엔 가격순으로의 트리셋을 가지고 싶다
		Comparator<Book> p = new Comparator<Book>() {
			@Override
			public int compare(Book a, Book b) {
				return a.getPrice() - b.getPrice();
			}
		};
		//이거 쓰라고 treeset에 알려줘야하는데, 이건 생성자에다가 하는거임
		//TreeSet의 생성자에는 1.TreeSet():기본생성자  2.TreeSet(collection객체넣기):이미 있는 자료넣기  3.TreeSet(Comparator객체넣기):기준설정
		Set<Book> set3 = new TreeSet<>(p);
		//set3.addAll(collection객체넣기); //생성자를 3번으로 써버렸으면 이미 있는 자료넣기는 이 메소드 써서 하면됨ㅎㅎ
		set3.add(b1);
		set3.add(b2);
		set3.add(b3);
		
		System.out.println(set3.size());
		System.out.println(set3);
	}

}
