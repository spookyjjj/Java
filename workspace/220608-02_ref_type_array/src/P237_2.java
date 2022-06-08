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
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = new int[10]; //10개의 정수 입력받는 배열
		int k = 0;
		while (k < 10) {
			a[k] = scan.nextInt();
			if (a[k] <= 0 || a[k] >= 100) {
				System.out.println("1에서 100사이의 정수를 입력해 주세요");
				continue;
				}
			k++;
		}
		for (int i = 0; i < 10; i++) {
			
		}
		int[] b = new int[10]; //10자리수 마다 count해서 넣는 배열
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (1 + (10 * i) <= a[j] && a[j] < 10 * (1 + i)) {
					b[i]++;
				}
			}
		}
		print(b);
	}

}
