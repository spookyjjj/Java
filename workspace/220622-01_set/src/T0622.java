import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

//중복되지 않는 1~45사이의 정수 6개를 가지는 집합
public class T0622 {

	public static void main(String[] args) {
		Random random = new Random();
		Set<Integer> lotto = new HashSet<>();
		
//		for (int i = 1; i <= 6; i++) { //이렇게 하면 중복일때 팅겨나와도 1회 추가된걸로 침;;
//			int j = random.nextInt(45) + 1; //0일때를 이렇게 회피함
//			lotto.add(j);
//		}
		
		while (lotto.size() < 6) {
			lotto.add(random.nextInt(45) + 1);
		}
		System.out.println(lotto);
		
		//정렬하기
//		Collections.sort(lotto); //set은 정렬할때 필요한 인덱스가 없음!!
		List<Integer> list = new ArrayList<>(lotto); //인덱스 있는 list에 넣어야
		Collections.sort(list); //sort가 됨
		System.out.println(list);
	}

}
