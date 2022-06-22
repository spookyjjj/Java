import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main2 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		//<key의 타입, value의 타입>
		map.put("둘리", 100);
		map.put("홍길동", 90);
		map.put("도우너", 150);
		
		Map<Integer, String> map2 = new HashMap<>();
		map2.put(1, "둘리");
		map2.put(4, "홍길동");
		map2.put(3, "도우너");
		
		//싹다보기
		System.out.println(map.toString());
		
		//순환하면서 한 쌍 씩 보기 일단 Map도 index없음 -> ★key를 가지고있음 각각 값을 볼 수 있음
		Set<String> keySet = map.keySet(); //★keySet()이라는 메소드는 key들을 set로 반환함
		//★방법1. 포이치
		for (String s : keySet) { 
			System.out.println(s + "=" + map.get(s));
		}
		//★방법2. 이터레이터
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) { 
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key + "=" + value);
		}
		//★방법3. 엔트리
		//Entry라는 타입 : key와 value를 한덩어리로 묶은것! 보통은 페어인데,,java는 엔트리라 카네,,
		Set<Entry<String, Integer>> entrySet = map.entrySet(); //★entrySet()이라는 메소드는 Entry를 반환함
		for (Entry<String,Integer> e : entrySet) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}
		
	}

}
