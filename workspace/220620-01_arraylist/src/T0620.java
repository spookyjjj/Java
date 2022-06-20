import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//1. 2의배수 5개를 가지는 정수형 리스트 생성 및 초기화
//2. 7의 배수 5개를 가지는 정수형 리스트 생성 및 초기화
//3. 위의 리스트 원소를 모두 다 가지는 리스트
//4. 3번의 리스트를 오름차순으로 정렬된 원소로 가지는 리스트
//5. random객체를 사용하며 0~10사이의 (정수형)난수 6개를 가지는 리스트 (각 숫자값은 중복되지 않아야 함)
public class T0620 {

	public static void main(String[] args) {
		//1. 2의배수 5개를 가지는 정수형 리스트 생성 및 초기화
		List<Integer> a = new ArrayList<>(Arrays.asList(2,4,6,8,10));
		System.out.println("1번문제" + a);
		
		//2. 7의 배수 5개를 가지는 정수형 리스트 생성 및 초기화
		List<Integer> b = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			b.add(i * 7);
		}
		System.out.println("2번문제" + b);
		
		//3. 위의 리스트 원소를 모두 다 가지는 리스트
		List<Integer> c = new ArrayList<>();
		c.addAll(a);
		c.addAll(b);
		System.out.println("3번문제" + c);
		
		//4. 3번의 리스트를 오름차순으로 정렬된 원소로 가지는 리스트
		List<Integer> d = new ArrayList<>(c);
		Collections.sort(d);
		System.out.println("4번문제" + d);
		
		//5. Random객체를 사용하며 0~10사이의 (정수형)난수 6개를 가지는 리스트 (각 숫자값은 중복되지 않아야 함)
		//0~10까지 리스트 만들어서 shuffle하고 subList로 0~5까지인덱스만 가져오는것도 가능
		Random r = new Random();
		List<Integer> e = new ArrayList<>();
//		(int) (r.nextDouble() * 10) + 1;
		while (e.size() < 6) {
			int random = r.nextInt(11); //범위 설정하면 0~10까지 랜덤 수 나옴
			if (!e.contains(random)) {
				e.add(random);
			}
		}
		System.out.println("5번문제" + e);
		
		for (int i = 0; i < 6; i++) {
			int random = r.nextInt(11);
			e.add(random);
		}
		System.out.println("5번문제" + e);
	}

}
