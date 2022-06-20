import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class T0620_2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(3, 23, 35, 11, 23, 57, 79));
		
		//1. 합, 평균
		int sum = 0;
		Iterator<Integer> i = list.iterator();
		while (i.hasNext()) {
			sum += i.next();
		}
		System.out.println("합: " + sum);
		System.out.println("평균: " + (sum / list.size()));
		
		//2. 정수 57이 리스트에 있는지? 있으면 몇번째 index에 위치하는지?
		int find = list.indexOf(57);
		if (find != -1) {
		System.out.println("57의 인덱스 번호: " + list.indexOf(57));
		} else {
			System.out.println("57은 없다");
		}
		
		//3. 정수 23의 개수
		Iterator<Integer> i2 = list.iterator(); //StringTokenizer과 마찬가지로, i에서 next()로 다 뽑아냈으면 텅 빈 주머니임
		int count = 0;
		while (i2.hasNext()) {
			if (i2.next().equals(23)) {
				count++;
			}
		}
		System.out.println(count);
		
		//4. 중복되는 원소 23을 '하나'삭제하기
//		list.removeAll(Arrays.asList(23)); //얘로하면 있는 23이란 23은 다 지워버림
		System.out.println(list);
		int first23 = list.indexOf(23);
		list.remove(first23); //첫번째 23의 인덱스를알아내서 지우든가.
//		list.remove(Integer.valueOf(23)); //23 객체를 찾아 지우든가. 얘도 처음나온 한개 지워줌 -> 지울게있으면 true
//		list.remove(Integer.valueOf(23)); //두번해야 싹다지워짐
		System.out.println(list);
	}

}
