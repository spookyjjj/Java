//사용자의 점수(정수형)를 입력받아 60점 이상이면 "합격" 출력, 미만이면 "불합격"과 부족한 점수도 같이 출력
import java.util.Scanner;

public class PandF {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("점수(정수형)를 입력하세요: ");
		int score = input.nextInt();

		if (score >= 60) {
			System.out.println("합격입니다");
		} else {
			System.out.println("불합격입니다");
			System.out.println((60 - score) + "점만 더 올리세요~!!");
		}
	}
}