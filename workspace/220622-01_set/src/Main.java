import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		//Set은 중복된값은 안받는다구 -> boolean으로 알려줌
		
		boolean b1 = set.add("qwer");
		boolean b2 = set.add(Integer.valueOf(10));
		boolean b3 = set.add("qwer"); //얘는 중복이라서 추가 안됨
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3); //false
		
		System.out.println(set.size()); //2
		System.out.println(set.toString());
		
//		System.out.println(set.get(0)); //★List와는 달리 인덱스가 없기 때문에 get메소드도 없다!!!!!
		
//		for (int i = 0; i < set.size(); i++) { //따라서 이것도 안됨~!
//			set.get(i);
//		}
		
		for (Object o : set) { //★전체원소보기 해결책 1번 
			System.out.println(o);
		}
		
		Iterator<Object> iter = set.iterator(); //★전체원소보기 해결책 2번 
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
