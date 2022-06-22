import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main5 {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
		//추가된 순서를 그래도 기억하고 있는 linked hash set~!
		//★but index는 여전히 없다!! 없는게 set의 특징임
		set.add("banana");
		set.add("carrot");
		set.add("apple");
		set.add("apple");
		set.add("banana"); 
		
		for (String s : set) {
			System.out.println(s);
		}
		
		Set<String> set2 = new HashSet<>(Arrays.asList("apple","donut","egg","fanta"));
		
//		set.addAll(set2);
//		System.out.println(set);
		//set(linkedhashset)기준으로 했기 때문에 추가된 순서 기억됨
		
		set2.addAll(set);
		System.out.println(set2);
		//set2(hashset)기준으로 했기 때문에 추가된 순서 없음
	}

}
