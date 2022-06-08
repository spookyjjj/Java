
public class Main {

	public static void main(String[] args) {
		//다음과 같은 정수형 배열이 있을 때
		int[] arr = {15, 32, 222, 119, 534, 36, 9, 1234};
		//2자리 수의 개수와 목록을 출력해보기
		int count = 0;
		String s = "";
		for (int i = 0; i < 8; i++) {
			if (arr[i] >= 10 && arr[i] < 100) {
				count++;
				s += arr[i] + "\n"; 
			}
		}
		System.out.println("개수 : " + count);
		System.out.println("-- 목록 --");
		System.out.print(s);
		}

}
