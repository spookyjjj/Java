import java.util.HashMap;
import java.util.Map;


class Student {
	int number;
	String name;
	
	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
public class MapTest {
	public static void main(String[] args) {
		Map<String, Student> st = new HashMap<String, Student>();
		st.put("20090001", new Student(20090001, "구준표"));
		st.put("20090002", new Student(20090002, "금잔디"));
		st.put("20090003", new Student(20090003, "윤지후"));
		
		//모든 항목을 출력한다
		System.out.println(st);
		
		//하나의 항목을 삭제한다 -> 키로 접근
		st.remove("20090002");
		//하나의 항목을 대치한다 -> 키로 접근
		st.put("20090003", new Student(20090003, "소이정"));
		//값을 참조한다 -> 키로 접근
		System.out.println(st.get("20090003"));
		//모든 항목을 방문한다 -> 키로 접근
		for (Map.Entry<String, Student> s : st.entrySet()) { //.entrySet() 키들의 집합을 반환
		//Map.Entry<>라고 하는 이유는 Map이라는 인터페이스 안의 Entry하는 인터페이스라서,, import를 Map만 해왔다면 이렇게 불러야하고
		//import를 java.util.Map.Entry;이렇게 까지 해놨다면 바로 Entry<>라고 불러도 됨
			String key = s.getKey();
			Student value = s.getValue();
			System.out.println("key=" + key + ", value=" + value);
			
		}
	}

}
