import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		//짝꿍구조
		map.put("일", 1); //들어갈 때 부터 짝꿍(key, value)으로 들어감! add가 아닌 put을 쓴다~~
		map.put("이", 2); 
		map.put("삼", 3); 
		map.put("사", 4); 

		System.out.println(map.size());
		
		map.get("삼"); //key를 통해 값을 get할 수 있다~~~
		System.out.println(map.get("삼")); 
		
//		map.put("이", 2222); //기존의 키로 새로운 값을 설정하면 전에 있던 값을 덮어씌워버림;;
//		System.out.println(map.get("이"));
		
		//그래서 쓰는 방법!
		if (!map.containsKey("이")) { //새로운 key여야지만 그 키에 값 추가하겠다~ 
			map.put("이", 2222);
		}
		System.out.println(map.get("이"));
	}

}
