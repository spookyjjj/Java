//사용자에게 국어, 영어, 수학 점수를 정수로 입력받아 총점과 평균점수를 출력하는 프로그램

import java.util.Scanner;

public class Average {
	public static void main(String args[]){
		Scanner inin = new Scanner(System.in);
		
		System.out.print("국어점수: ");
		int kor = inin.nextInt();
		System.out.print("영어점수: ");
		int eng = inin.nextInt();
		System.out.print("수학점수: ");
		int math = inin.nextInt();
		
		int sum = (kor + eng + math);
		
		System.out.println("총점: " + sum);	
		System.out.println("평균점수: " + (sum / 3));
	}
}