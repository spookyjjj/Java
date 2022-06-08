import java.util.Arrays;

public class Main5 {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		//★for-each문 -> 인덱스 고려없이 걍 한 방향으로 전부 쭉 읽어줌
		for (int number : arr) { //왼쪽은 값(참조)을 담을 타입과 박스이름 (":" 기준!) 오른쪽은 배열과 같이 여러개를 담는 객체 
			arr[0] = 50;
			arr[1] = 50; //값 수정 안됨~~ for-each에서 "="을 쓰면 내맘대로 안됨;
			arr[2] = 50;
			number += 1;
			System.out.println(number);
		}
		System.out.println(Arrays.toString(arr));
	}

}
