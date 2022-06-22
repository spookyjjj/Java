import java.util.Set;
import java.util.TreeSet;

public class Main6 {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		//★대소비교가 가능한 원소를 넣으면 정렬된 순서로 기억하고 있는 tree set~!
		//index없는건 역시 마찬가지~ㅎㅎ
		set.add(50);
		set.add(17);
		set.add(2);
		set.add(22);
		set.add(2);
		set.add(50);
		set.add(30);
		
		for (int i : set) {
			System.out.println(i);
		}
	}

}
