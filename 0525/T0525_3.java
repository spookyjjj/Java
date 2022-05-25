//중첩반복문을 이용하여 별 짓기
/*
1.					4. 
*						*
**					   ***
***					  *****
****				 *******
*****				*********

2. 				   5.
*****				*********
****				 *******
***					  *****
**					   ***
*						*

3.				   6. 2~100 사이의 모든 소수 출력하기
    *
   **
  ***
 ****
*****
*/
import java.util.Scanner;
public class T0525_3 {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		
		//별 수동
		// for (int i = 1; i <= 1; i++) {
			// System.out.print("*");
		// }
		// System.out.println("");
		
		// for (int i = 1; i <= 2; i++) {
			// System.out.print("*");
		// }
		// System.out.println("");
		
		// for (int i = 1; i <= 3; i++) {
			// System.out.print("*");
		// }
		// System.out.println("");
		
		//별 자동
		// for (int j = 1; j <= 3; j++) {
			// for (int i = 1; i <= j; i++) {
				// System.out.print("*");
			// }
			// System.out.println("");
		// }
		
		//별 입력받은 값까지 자동
		System.out.print("몇 줄을 생성하고 싶나요? ");
		int line = scan.nextInt();
		
		for (int j = 1; j <= line; j++) {
			for (int i = 1; i <= j; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//역순
		// for (int i = 1; i <= 3; i++) {
				// System.out.print("*");
			// }
			// System.out.println("");
		// for (int i = 1; i <= 2; i++) {
				// System.out.print("*");
			// }
			// System.out.println("");
		// for (int i = 1; i <= 1; i++) {
				// System.out.print("*");
			// }
			// System.out.println("");
		//->근데 이렇게 하면 역순과 정순을 섞을때 j로 묶기가 애매해진다, 정순은 j가 1 2 3커지고 역순은 j가 3 2 1작아지니깐
		//-> 1 2 3으로 변수가 커지게 고치면 j로 묶기가 쉬워진다
		// for (int i = 0; i <= 3-1; i++) {
				// System.out.print("*");
			// }
			// System.out.println("");
		// for (int i = 0; i <= 3-2; i++) {
				// System.out.print("*");
			// }
			// System.out.println("");
		// for (int i = 0; i <= 3-3; i++) {
				// System.out.print("*");
			// }
			// System.out.println("");
			
		// for (int j = 1; j <= 3; j++) {		
			// for (int i = 0; i <= 3-j; i++) {
				// System.out.print("*");
			// }
			// System.out.println("");
		// }
		
		for (int j = 1; j <= line; j++) {		
			for (int i = 0; i <= line-j; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//빈공간 역순과 정순을 섞으면 됨
		//역순
		// for (int j = 1; j <= line; j++) {		
			// for (int i = 0; i <= line-j; i++) {
				// System.out.print("*");
			// }
			// System.out.println("");
		// }
		//정순
		// for (int j = 1; j <= line; j++) {
			// for (int i = 1; i <= j; i++) {
				// System.out.print("*");
			// }
			// System.out.println("");
		// }
		//둘이 더하기
		for (int j = 1; j <= line; j++) {
			for (int i = 0; i <= line-j; i++) {
				System.out.print("  ");
			}
			for (int i = 1; i <= j; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//트리모양은? 공란을 한칸으로 고치기
		for (int j = 1; j <= line; j++) {
			for (int i = 0; i <= line-j; i++) {
				System.out.print(" ");
			}
			for (int i = 1; i <= j; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//역순트리는? 공란+별 순서! 공란은 증가, 별은 감소
		for (int j = 1; j <= line; j++) {
			for (int i = 1; i <= j; i++) {
				System.out.print(" ");
			}		
			for (int i = 0; i <= line-j; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
			
		//입력한 정수가 소수인지 알아내기
		// int input = 113;
		// int count = 0;
		// for (int i = 1; i <= input; i++) {
			// if (input % i == 0) {
				// count++;
			// }
		// }
		// if (count == 2) {
			// System.out.println(input);
		// }
		
		//반복문으로 묶기
		for (int j = 2; j <= 100; j++) {
			int count = 0;
			for (int i = 1; i <= j; i++) {
				if (j % i == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.println(j);
			}
		}
	}
}