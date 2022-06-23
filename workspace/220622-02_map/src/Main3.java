import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main3 {
	public static void main(String arg[]) {
		Map<String, Integer> map = new LinkedHashMap<>(); //넣은 순서대로
		map.put("hello", 1);
		map.put("world", 2);
		map.put("abc", 123);
		
		Map<String, Integer> treeMap = new TreeMap<>(); //★ 'key'기준으로 크기비교!
		treeMap.put("hello", 1);
		treeMap.put("world", 2);
		treeMap.put("abc", 123);
		
		System.out.println(map);
		System.out.println(treeMap);
	}
}
