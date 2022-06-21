import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main6 {

	public static void main(String[] args) {
		//배열대신 리스트를 쓰면 훠어어어얼씬 기능이 많다!!!
		
		List<Integer> list = new ArrayList<>(Arrays.asList(7, 3, 2, 8, 9, 1));
		
//		Arrays.sort(list); //이거는 List클래스가 아닌 Array일때나 가능!
		
		//Collections는 Collection에서 작동하는 정적 메소드들 이 담겨있다~  
		//Collection은 ArrayList를 포함하는 객체
		Collections.sort(list);
		System.out.println(list);

		int index = Collections.binarySearch(list, 8); //★이진검색!! -> 정렬이 선행되어야지 사용가능~!
		System.out.println("8의 인덱스: " + index);
		
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		
		Collections.fill(list, 33); //길이 유지하면서 값을 다 33으로 바꿈
		System.out.println(list);
		
		Collections.replaceAll(list, 33, 77); //33을 찾아서(값동일) 77로 바꿈
		System.out.println(list);
		
		List<Integer> target = new ArrayList<>(Arrays.asList(90, 80, 70));
		Collections.copy(list, target); //list에 target을 복사! -> target보다 list가 길면 가능
		System.out.println(list); 
//		Collections.copy(target, list); //target에 list을 복사! -> list보다 target이 짧아서 실행오류
	}

}
