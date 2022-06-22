import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main4 {

	public static void main(String[] args) {
		Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5)); //생성자 안에는 모든 종류의 collection다 들어갈 수 있다!
		Set<Integer> setB = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7)); //지금은 list를 넣어 set을 생성
		
		Set<Integer> setUnion = new HashSet<>();
		setUnion.addAll(setA);
		setUnion.addAll(setB);
		
		System.out.println(setUnion);
		
		//교집합 찾기
		Set<Integer> setDuplicate = new HashSet<>();
		setDuplicate.addAll(setA);
		setDuplicate.retainAll(setB);
		System.out.println(setDuplicate);
		
		//차집합 찾기
		Set<Integer> setLeftOuter = new HashSet<>();
		setLeftOuter.addAll(setA);
		setLeftOuter.removeAll(setB);
		System.out.println(setLeftOuter);
		
		//동등한 집합인지 알기
		Set<Integer> setSame = new HashSet<>(Arrays.asList(7, 6, 5, 4, 3, 2, 1));
		System.out.println(setSame.equals(setUnion)); //순서상관없이 요소들 같으면
	}

}
