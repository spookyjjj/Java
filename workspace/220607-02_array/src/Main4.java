import java.util.Arrays;

public class Main4 {
	//문자배열 출력하기
	static void printArray(char[] target) {
		for (int i = 0; i < target.length; i++) {
			System.out.println(target[i]);
		}
	}
	
	//배열의 모든 원소를 문자열로 표현해서 반환하는 메소드
	static String arrayToString(char[] target) {
		String s = "";
		for (int i = 0; i < target.length; i++) {
			s += target[i];
		}
		return s;
	}
	
	//배열에서 하나의 특정 문자의 인덱스를 찾아 반환하는 메소드
	static int whereIs(char[] target, char c) {
		for(int i = 0; i < target.length; i++) {
			if (target[i] == c) {
				return i;
			} 
		}
		return -1;
	}
	
	public static void main(String[] args) {
		char[] hello = { 'H', 'e', 'l', 'l', 'o' };
		
		printArray(hello);
		
		System.out.println("-----------------");
		
		System.out.println(arrayToString(hello)); //우리가 만든 to String 메소드
		System.out.println(Arrays.toString(hello)); //기존에 java에서 만든 to String 메소드
		
		System.out.println("-----------------");
		
		System.out.println(whereIs(hello, 'o')); //우리가 만든 문자찾기 메소드
	}
}
