//1. 원의 반지름(실수형)을 전달받아 원넓이(실수형)를 반환하는 메소드 작성 후, 메인메소드에서 호출하여 값을 확인.
//2. 전달받은 정수만큼 안녕 이라는 문자열을 출력하는 메소드 return type : void
//3. 전달받은 두 문자열의 길이 값의 합을 반환하는 메소드
//4. 키(실수, 미터단위) 몸무게(실수, kg단위)를 전달받아 bmi지수(실수)를 반환하는 메소드 -> bmi = 몸무게 / 키^2

import java.util.Scanner;
public class T0526 {
	
	//1. 원의 반지름(실수형)을 전달받아 원넓이(실수형)를 반환하는 메소드 작성 후, 메인메소드에서 호출하여 값을 확인.
	public static double area(double a) {
		return a * a * 3.14;
	}
	
	//2. 전달받은 정수만큼 안녕 이라는 문자열을 출력하는 메소드 return type : void
	public static void hello(int a) {
		for (int i = 0; i < a; i++) {
			System.out.println("안녕");
		}
	}
	
	//3. 전달받은 두 문자열의 길이 값의 합을 반환하는 메소드
	public static int stringsum(String a, String b) {
		return a.length() + b.length();
	}
	
	//4. 키(실수, 미터단위) 몸무게(실수, kg단위)를 전달받아 bmi지수(실수)를 반환하는 메소드 -> bmi = 몸무게 / 키^2
	public static double bmi(double a, double b) {
		return b / (a * a);
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("넓이를 구하고 싶은 원의 반지름?: ");
		double radius = scan.nextDouble();
		System.out.println("원의 넓이: " + area(radius));
		
		System.out.print("안녕 몇번 볼래?: ");
		int count = scan.nextInt();
		hello(count);
		
		scan.nextLine();
		System.out.print("첫번째 문자열?: ");
		String a = scan.nextLine();
		System.out.print("두번째 문자열?: ");
		String b = scan.nextLine();
		System.out.println(stringsum(a, b));
		
		System.out.print("키(m)?: ");
		double h = scan.nextDouble();
		System.out.print("몸무게(kg)?: ");
		double w = scan.nextDouble();
		System.out.println(bmi(h, w));
	}
}