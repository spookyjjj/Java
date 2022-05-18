import java.util.Scanner;

public class CircleArea {
	public static void main(String args[]) {
		double radius; //double은 실수형 타입
		double area;
		Scanner input = new Scanner(System.in);
		System.out.print("반지름을 입력하시오: ");
		radius = input.nextDouble(); //실수를 입력받을 수 있는 메소드
		area = 3.14 * radius * radius;
		
		System.out.println(area);
	}
}