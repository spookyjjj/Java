import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main2 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("banana");
		set.add("carrot");
		set.add("apple");
		set.add("banana"); 
		
		System.out.println(set.size());
		
		Iterator<String> iter = set.iterator(); //★인덱스도 없고, 넣고 뺀 순서도 없어서 출력하면 지맘대로 나옴
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println(set.contains("banana")); //-> just중복이 있냐 없냐만 파악하는데 주력하는 놈이다~~~
		System.out.println(set.contains("donut"));
	}

}
