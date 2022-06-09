import java.util.Scanner;
public class P237_2 {
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d - %d : ", 1 + (10 * i), 10 * (1 + i));
			for (int j = 0; j < arr[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//메인메소드
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = new int[10]; //10개의 정수 입력받는 배열
		for (int i = 0; i < 10; i++ ) {
			a[i] = scan.nextInt();
			if (a[i] <= 0 || a[i] >= 100) {
				System.out.println("1에서 100사이의 정수를 입력해 주세요");
				i--; 
//		----for문에서 증감식이 또 등장하면 논리오류발생확률 매우증가 하니깐 지양하자!! 아래와 같이 올바른 수만 받는 메소드를 이용하는 방법------
//				public boolean isOk(int number) {
//					return number > 0 && number <= 100; 
//				}
//				public int inputNumber() { //입력받은 수가 올바를때 까지 계속 돈다
//					int number = 0;
//					do {
//						number = scan.nextInt();
//					} while (isOk(number));
//				}
//				return number;
//		-----------------------------------------------------------------------------------------------				
			}
		}
		int[] b = new int[10]; //10자리수 마다 count해서 넣는 배열
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (1 + (10 * i) <= a[j] && a[j] <= 10 * (1 + i)) {
					b[i]++;
				}
			}
		}
		print(b);
	}

}
