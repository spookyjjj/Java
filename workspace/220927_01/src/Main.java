import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> list;
		MyHolder<String>h1 = new MyHolder<String>("스트링값 가지는 객체");
		MyHolder<Integer>h2 = new MyHolder<Integer>(199);
		
		MyPair<String, Integer> p1 = new MyPair<String, Integer>("키값", 456);
		MyPair<String, String> p2 = new MyPair<String, String>("키값", "벨류값");
		MyPair<String, MyPair<String, String>> p3; //이런것도 가능~
		
		//MyHolder h3 = new MyHolder(); //빈 생성자 만들면 제네릭 없이도 사용가능
		//h3.setObject(object); //그때는 object로 타입이 정해진다
	}
}
