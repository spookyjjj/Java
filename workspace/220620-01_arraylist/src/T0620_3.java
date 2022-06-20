import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class T0620_3 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "carrot", "donut", "egg"));
		
		//1. 문자열의 길이가 5글자인 문자열만을 원소로 가지는 리스트 생성
		List<String> a = new ArrayList<>();
		Iterator<String> i = list.iterator();
		while(i.hasNext()) {
			String s = i.next();
			if (s.length() == 5) {
				a.add(s);
			}
		}
		System.out.println(a);
		
		//2. 문자열 중에 'e'문자를 포함하는 문자열만을 원소로 가지는 리스트 생성
		List<String> b = new ArrayList<>();
		Iterator<String> i2 = list.iterator();
		while(i2.hasNext()) {
			String s = i2.next();
			if (s.contains("e")) {
				b.add(s);
			}
		}
		System.out.println(b);
		
		
		//======================================
		
		
		List<String> list2 = new ArrayList<>(Arrays.asList("가", "1", "@", "3", "나"));
		
		//3. '정수형태의 값'을 가지는 문자열을 찾아 해당원소를 가지고 리스트 생성
		List<String> c = new ArrayList<>();
		Iterator<String> i3 = list2.iterator();
		while(i3.hasNext()) {
			String s = i3.next();
			char letter = s.charAt(0); 
			if (letter >= '0' && letter <= '9') { //아스키코드 48(0) ~ 57(9)까지가 정수형
				c.add(s);
			}
		}
		System.out.println(c);
		//예외처리를 이용한 풀이
		List<String> c2 = new ArrayList<>();
		for (int k = 0; k < list2.size(); k++) {
			String str = list2.get(k);
			try {
				Integer value = Integer.valueOf(str);
				c2.add(str);
			} catch (NumberFormatException e){
				System.out.println("예외상황이 발생하였으나 정상흐름으로 돌아가기 위해 예외처리함");
			}
		}
		System.out.println(c2);
		
		//4. '정수형태의 값'을 가지는 문자열을 -> Integer형으로 변환
		String test = "55시66";
		//예전풀이
		boolean tf = true; //스위치 역할
				for(int j = 0; j < test.length(); j++) {
			if (!(test.charAt(j) >= '0' && test.charAt(j) <= '9')) {
				System.out.println("숫자로 변환불가 문자열");
				tf = false;
				break;
			} 
		}
		if (tf) {
			Integer d = Integer.valueOf(test);
			System.out.println(d);
		}
		//이제는 예외처리를 배웠으니 예외상황자체를 조건으로 해서 풀면됨                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 그냥 catch하면됨
		try {
			Integer d = Integer.valueOf(test);
			System.out.println(d);
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환불가 문자열");
		}
	
	}
}

	
