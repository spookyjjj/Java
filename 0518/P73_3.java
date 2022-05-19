// p73 3

import java.util.Scanner;

public class P73_3 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("반지름을 입력하시오: ");
		double radius = input.nextDouble();
		
		double vol = (4 * radius * radius * radius) / 3;
		//double vol = (4 / 3 * radius * radius * radius); 값에는 오류가 생기는 이유?
		/* 컴퓨터는 앞에서 부터 계산을 해 나가므로 4/3부터 계산을 하게 되는데
		이것이 정수 나누기 정수 값으로 인식되어 결과값도 정수로 내게 된다. 즉, 1.333이 아니라 1로 계산함!!!
		이는 들어갈 값의 문제이므로 담길 통인 vol를 double처리 한 것과는 무관하다. 
		따라서 둘 중 하나라도 실수로 만들어줘야 실수값으로 출력한다.
		위의 계산식이 옳은 결과를 내는 것도 radius에 doule처리가 되어있기 때문~ 
		((double) 4 / 3 ); 혹은 (4.0 / 3); 적용하면 됨! */
		
		System.out.println("부피: " + vol);
	}
}