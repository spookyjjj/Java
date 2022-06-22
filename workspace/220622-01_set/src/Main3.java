import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main3 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("가", "나", "다", "다", "다", "다", "가", "라"));
		//리스트의 중복값을 빼고싶다? -> Set을 한번 거쳐오먄됨
		
		
		Set<String> set = new HashSet<>();
		for(int i = 0; i < list.size(); i++) {
			set.add(list.get(i));
		}
		System.out.println(set);
		
		//위 과정을 줄여서, ★★ Collection객체들의 생성자 안에는, 다른 Collection의 객체들도 집어넣을 수 있다는 점!을 이용하여
		Set<String> set2 = new HashSet<>(list);
		System.out.println(set2);
	}

}
