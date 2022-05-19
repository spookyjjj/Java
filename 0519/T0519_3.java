//사용자의 벤치, 스쿼트, 데드 합이 500이상이면 true 아니면 false

import java.util.Scanner;

public class T0519_3 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("벤치: ");
		int x = input.nextInt();
		System.out.print("스쿼트: ");
		int y = input.nextInt();
		System.out.print("데드: ");
		int z = input.nextInt();
		
		int sum = x + y + z;
		System.out.println("3대 500이상? " + (sum >= 500));		
	}
}