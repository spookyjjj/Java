import java.util.StringTokenizer;

public class Main7 {

	public static void main(String[] args) {
		String longLine = "apple banana carrot dounut";
		
		//공백 단위로 끊어서 출력하기
		int firstBlank = longLine.indexOf(' ');
		for (int i = 0; i < firstBlank; i++) {
			System.out.print(longLine.charAt(i));
		}
		System.out.println();
		int secondBlank = longLine.indexOf(' ', firstBlank + 1);
		for (int i = firstBlank + 1; i < secondBlank; i++) {
			System.out.print(longLine.charAt(i));
		}
		System.out.println();
		int thirdBlank = longLine.indexOf(' ', secondBlank + 1); //얘는 lastIndexOf값과 같음 -> 얘로 잡아도 되고
		for (int i = secondBlank + 1; i < thirdBlank; i++) {
			System.out.print(longLine.charAt(i));
		}
		System.out.println();
		int fourthBlank = longLine.indexOf(' ', thirdBlank + 1); //애는 -1임 -> 얘로 잡아도 됨
		if (fourthBlank == -1) {
			for (int i = thirdBlank + 1; i < longLine.length(); i++) {
				System.out.print(longLine.charAt(i));
			}
		}
		System.out.println();
		
		//==============StringTokenizer
		//걍 이 클래스 쓰면 됨~!!
		//긴 문자열을 지정된 구분자를 기준으로 문자열을 슬라이싱하는데 사용한다 -> 나눈 물자열들을 token이라고 함
		System.out.println();
		StringTokenizer st = new StringTokenizer(longLine, " ");
		System.out.println(st.hasMoreTokens());
		System.out.println(st.nextToken()); //apple
		System.out.println(st.hasMoreTokens());
		System.out.println(st.nextToken()); //banana
		System.out.println(st.hasMoreTokens());
		System.out.println(st.nextToken()); //carrot
		System.out.println(st.hasMoreTokens()); //★얘도 T라는것~!!!! 다음 공백은 없지만 token(남은 문자열 단위)는 있으니깐
		System.out.println(st.nextToken()); //dounut
		System.out.println(st.hasMoreTokens());
//		while (st.hasMoreTokens()) { //" " 있을때만 그 전의 것을 데려온다 더이상 없는데 데려오려고 하면 오류나니깐
//			System.out.println(st.nextToken());
//		}
		
		//StringTokenizer는 문자로 문자열을 구분한다면, split는 정규표현식으로 구분합니다.
		//StringTokenizer는 결과값이 문자열이라면 split는 결과 값이 문자열 배열입니다.
		
		//============String의 slpit메소드
		System.out.println();
		String[] split = longLine.split(" ");
		System.out.println(split[2]);
	}

}
