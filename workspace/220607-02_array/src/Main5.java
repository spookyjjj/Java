//1. 사용자에게 5번 정수를 입력받아 역순으로 출력하기
//2. 사용자가 0 이하의 수를 입력할 때 까지 반복하여 입력하여. 최근 5개를 역순 출력

import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//1. 사용자에게 5번 정수를 입력받아 역순으로 출력하기
		System.out.println("정수 5개를 입력하세요");
		int[] a = new int[5];
		for (int i = 0; i < 5; i++) {
			a[i] = scan.nextInt();
		}
		for (int i = 4; i >= 0; i--) {
			System.out.println(a[i]);
		}
		
		//2-1. 사용자가 0 이하의 수를 입력할 때 까지 반복하여 입력하여. 최근 5개를 역순 출력
		int[] b = new int[6];
		while (true) {
			b[5] = scan.nextInt();
			if (b[5] <= 0) {
				break;
			}
			b[0] = b[1];
			b[1] = b[2];
			b[2] = b[3];
			b[3] = b[4];
			b[4] = b[5];
		}
		for (int i = 4; i >= 0; i--) {
			System.out.println(b[i]);
		}
		//2-2. 순서가 상관 없다면, int값 5개 배열 ..사용자 입력 받을 때 마다 5개 안에서 set..음수값들어오면 멈추고..
		int[] c = new int[5];
		Loop : //중첩반복문 전체를 빠져나오기 위해 바깥루프에 이름붙여줌
		while (true) {
			int x;
			for (int i = 0; i < 5; i++) {
				x = scan.nextInt();
				if (x <= 0) break Loop; else c[i] = x;
			}
		}
		for (int i = 4; i >= 0; i--) {
			System.out.println(c[i]);
		}
//---------------다른답안--------------
//for반복 안하고! i++ 걸고, ★if(i == 5) i = 0;으로 반복하게 함
//		int i = 0;
//		while(true) {
//			int n = scan.nextInt();
//			if(n < 0) {
//				break;
//			}
//			arr[i] = n;
//			i++;
//			if(i == 5) { //arr[5]의 자리는 없으니깐 arr[0]으로 복귀
//				i = 0;
//			}			
//		}
	}
}
