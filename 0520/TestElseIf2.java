//사용자의 점수를 입력받아서 90점 이상~A, 90점 미만 80이상~B, 80점 미만 70이상~C, 70점 미만 60이상~D, 60점 미만~F

import java.util.Scanner;

public class TestElseIf2 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요.");
		int score = input.nextInt();
		
		char grade; //할당할때는 ""가 아니라 ''라는것 항상 기억!!!!
		if (score >= 90) {
			grade = 'A';
		} else if(score >= 80) {
			grade = 'B';
		} else if(score >= 70) {
			grade = 'C';
		} else if(score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("점수: " + grade);
	}
}