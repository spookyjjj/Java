//1. 사용자에게 5번 정수를 입력받아 역순으로 출력하기
//2. 사용자가 0 이하의 수를 입력할 때 까지 반복하여 입력하여. 최근 5개를 역순 출력

import java.util.Scanner;
class Store {
	int a;
	int b;
	int c;
	int d;
	int e;

	public Store() {}
	
	public void setA(int a) {
		this.a = a;
	}
	public void setB(int b) {
		this.b = b;
	}
	public void setC(int c) {
		this.c = c;
	}
	public void setD(int d) {
		this.d = d;
	}
	public void setE(int e) {
		this.e = e;
	}

}

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
		
		//2. 사용자가 0 이하의 수를 입력할 때 까지 반복하여 입력하여. 최근 5개를 역순 출력
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
		//순서가 상관 없다면, int값 5개를 매개변수로 두는 클래스를 하나 만들어서 ...사용자 입력 받을 때 마다 set하구...음수값들어오면 멈추고.. 출력은 void로
		int x;
		x = scan.nextInt();
	}
}
