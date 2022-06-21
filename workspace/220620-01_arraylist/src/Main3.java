import java.util.ArrayList;
import java.util.List; 

public class Main3 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(); //제네릭 붙일때 오른쪽꺼는 꺽쇠만 해도됨
		//upcasting! List는 interface(get()같은 애들 존재)이고, ArrayList는 List를 implements!
		//그래서 List에도 있는 메소드는 List로 형변환해도 사용가능하다~ 아래의 메소드들이 전부 그러함
		//보통은 interface로 업캐스팅 해서 쓴다! 로지텍마우스라고 안하고 마우스라고 부르듯이 덜 복잡하니깐!
		list.add(77); 
		System.out.println(list.get(0));
		
		for(int i = 1; i <= 4; i++) {
			list.add(i * 10);
		}
		System.out.println(list.toString());
		
		//값변경하기
		list.set(0, -77);
		System.out.println(list);
		
		//값찾기
		System.out.println(list.contains(77));
		System.out.println(list.indexOf(77));
		
		//값 제거
		list.remove(1); //1번째 인덱스 삭제
		System.out.println(list); //길이 하나 줄고, 들어 있는 애들은 한칸씩 땡겨옴
		
		//값 삽입
		list.add(0, 100); //0번째 인덱스에 100값을 넣어라~
		System.out.println(list); //길이 하나 늘고, 옆으로 한칸씩 옮겨감
		
		//초기화
		list.clear(); //반복문으로 remove써도 되지만 인덱스 줄어들고 난리라서 좀 번잡스럽다~
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list);
	}
}
