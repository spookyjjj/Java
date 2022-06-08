import java.util.Arrays;

public class Main3 {
	//배열의 원소값을 복사하는 메소드
	public static int[]	copyArray(int[] origin) {
		int[] copy = new int[origin.length];
		for (int i = 0; i < origin.length; i++) {
			copy[i] = origin[i];
		}
		return copy;
	}
	
	//정수형 배열 2개가 동일한지(길이와 각 원소값)을 알 수 있는 메소드
	public static boolean sameLength(int[] a, int[] b) {
		if (a.length == b.length) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean sameElement(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (b[i] != a[i]) {
				return false;
			}
		} return true;
	}
	public static boolean sameArray(int[] a, int[] b) {
		return sameLength(a, b) == true && sameElement(a, b) == true;
//		--------한번에 합쳐서 적기-------
//		if (a.length == b.length) {
//			for (int i = 0; i < a.length; i++) {
//				if (a[i] != b[i]) {
//					return false;
//				}
//			} return true;
//		} else {
//			return false;
//		}
//		--------★이렇게 하면 값이 아니라, 참조하고 있는 대상(인스턴스)가 같아야 true---------
//		return a == b;
	}
	
	public static void main(String[] args) {
		int[] test = {50, 70, 90, 110};
		int[] test2 = {60, 70, 50, 110};
		int[] c = copyArray(test); 
		System.out.println(Arrays.toString(c)); 
		System.out.println(sameArray(test, c));
		System.out.println(sameArray(test, test2));
		System.out.println(Arrays.equals(test, c)); //★Arrays.equals 근데 이미 java에서 만든게 있음.. 값의 동일
	}

}
