import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main5 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList(Arrays.asList(10, 20, 30, 30, 40, 50)); //Arrays 생성자역할 add()안하고 바로 만들기
		System.out.println(list);
//		List<Integer> test = Arrays.asList(10, 20, 30, 40, 50); 
//		test.add(60); //★생성자로 만든 리스트는 변경, 추가가 안됨!!
		
		list.addAll(Arrays.asList(60, 70, 80)); //addAll은 배열단위로 추가가능!
		System.out.println(list);
		
		list.removeAll(Arrays.asList(30, 40, 10)); //역시 값 동일을 찾아 지움! -> 띄워져 있어도 상관없음, 중복까지 싹다
		System.out.println(list);
		
		System.out.println(list.containsAll(Arrays.asList(10, 80))); //역시 값 동일을 찾아 t/f -> 띄워져 있어도 상관없음
		
		List<Integer> sub = list.subList(0,  3); //0~3인덱스까지만 복사한 list만들기
		System.out.println(sub);
		System.out.println(list);
	}
}
