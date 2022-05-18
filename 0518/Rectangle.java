//사용자의 사각형의 밑변과 높이를 정수로 입력받아 사각형의 둘레와 넓이를 출력

import java.util.Scanner;

public class Rectangle {
	public static void main(String args[]){
		Scanner putput = new Scanner(System.in);
		
		System.out.print("사각형의 밑변의 길이: ");
		int x = putput.nextInt();
		System.out.print("사각형의 높이: ");
		int y = putput.nextInt();
		
		System.out.println("사각형의 둘레: " + 2 * (x + y));	
		System.out.println("사각형의 넓이: " + x * y);
	}
}