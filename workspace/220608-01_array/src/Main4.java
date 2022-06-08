import java.util.Arrays;

public class Main4 {
	//0. 칸수를 원하는 만큼 늘리는 메소드
	public static int[] expand(int[] a, int b) {
		int[] expand = new int[a.length + b];
		for (int i = 0; i < a.length; i++) {
			expand[i] = a[i];
		}
		return expand;
	}
	
	//1. 두개의 정수 배열을 전달받아 결합한 배열로 바꿔주는 메소드 [1, 2, 3] [10, 11, 12, 13, 14] -> [1, 2, 3, 10, 11, 12, 13, 14]
	public static int[] combine(int[] a, int[] b) {
		int[] combine = expand(a, b.length);
		for (int i = 0; i < b.length; i++) {
			combine[i + a.length] = b[i];
		}
		return combine;
	}
	
	//2. 두개의 정수 배열의 합을 가지는 배열을 반환하는 메소드 [1, 2, 3] [10, 11, 12, 13, 14] -> [11, 13, 15, 13, 14]
	public static int[] plus(int[] a, int[] b) {
		int leng;
		int[] plus;
		if (a.length >= b.length) {
			leng = a.length;
			plus = expand(b, leng - b.length);
			for (int i = 0; i < leng; i++) {
				plus[i] += a[i];
			}
		} else {
			leng = b.length;
			plus = expand(a, leng - a.length);
			for (int i = 0; i < leng; i++) {
				plus[i] += b[i];
			}
		}
		return plus;
	}

	public static void main(String[] args) {
		int[] arr = {10, 20, 30};	//칸 수를 2칸 더 늘리고 싶다면?
		
		int[] larger = new int[arr.length + 2]; //더 큰 배열 박스 가져와서
		for (int i = 0; i < arr.length; i++) {	//기존의 값을 집어넣기
			larger[i] = arr[i];
		}
		System.out.println(Arrays.toString(larger)); //이것을 메소드로 아예 만들어 버리기~! -> 0.메소드로 ㄱㄱ
		System.out.println(Arrays.toString(expand(arr, 3))); //0번 메소드 이용
		System.out.println(Arrays.toString(Arrays.copyOf(arr, 7))); //★Arrays.copyOf 메소드 이용 근데 이미 java에서 만든게 있음.. 뒤에건 길이값
		
		
		int[] a = {1, 2, 3};
		int[] b = {10, 11, 12, 13, 14};
		System.out.println(Arrays.toString(combine(a, b)));
		System.out.println(Arrays.toString(plus(a, b)));
		
		int[] c = {10, 20, 30};
		Arrays.fill(c, 100); //★Arrays.fill 메소드 이용
		System.out.println(Arrays.toString(c));
	}

}
