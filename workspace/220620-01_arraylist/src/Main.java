import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(); //길이값을 정해주지 않고, !객체!추가만 해주면 됨
		list.add("문자열객체");
		list.add(new Object());
		list.add(Integer.valueOf(100)); //객체만 다룰 수 있어서 Interger
		list.add(Double.valueOf(55.55)); 
		list.add(500); //이것도 int를 넣은게 아니라 Integer로 auto boxing해서 넣은거임
		list.add(123.123);
		
		int size = list.size(); //크기알기
		System.out.println(size);
		
		System.out.println(list.get(0)); //인덱스 번호로 불러오기
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
