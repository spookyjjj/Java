import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFreq {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		
		String[] sample = { "to", "be", "or", "not", "to", "be", "is", "a", "problem" };
		
		for (String a: sample) {
			Integer freq = m.get(a); //키값에 할당된 단어가 없으면 null이 나옴
			m.put(a, (freq == null) ?  1: freq + 1); //처음나왔으면 1 중복이면 하나씩 늘려감
		}
		
		System.out.println(m.size() + " 단어가 있습니다");
		System.out.println(m.containsKey("to"));
		System.out.println(m.isEmpty());
		System.out.println(m);
		
		//또다른 응용~!
		//아래 문잘에서 알파벳 종류와 등장한 횟수와
		String line = "Hello. I'm a java developer";
		Map<Character, Integer> m2 = new HashMap<>();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (m2.containsKey(c)) {
				m2.put(c, m2.get(c) + 1);
			} else {
				m2.put(c, 1);
			}
			
		}
	}
}
