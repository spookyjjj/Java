import java.util.Scanner;
import java.util.Random; //Random클래스 불러오기

public class LetterGame {
	public static void main(String args[]) {
		Random random = new Random(); //Random 인스턴스 설정
		int answer = random.nextInt(100); //Random 메소드 사용하기
		int guess;
		int tries = 0;
		Scanner scan = new Scanner(System.in);
		//반복구조
		do {
			System.out.println("정답을 추측하여 보시오: ");
			guess = scan.nextInt();
			tries++;
			
			if (guess > answer) 
				System.out.println("제시한 정수가 높습니다.");
			if (guess < answer) 
				System.out.println("제시한 정수가 낮습니다.");
		} while (guess != answer);
		
		System.out.printf("축하합니다. 시도횟수=%d\n", tries);
	}
}