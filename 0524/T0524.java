//2~9까지 무작위의 수를 정하여 보여주고, 사용자가 해당하는 수의 배수를 순서대로 입력하게 하여 틀리면 종료
//예) 랜덤수가 6일 경우, 사용자 입력이 6(O), 12(O), 18(O), 21(X) 종료

import java.util.Scanner;
import java.util.Random;

public class T0524 {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		//0이나 1이나 2가 나오면 다시 할당받으러 돌아가기 
		int random = ran.nextInt(10);
		while (random == 0 || random == 1 || random == 2) {
			random = ran.nextInt(10);
		}
		//또는 받은 랜덤수에 +2를 해줘버리기
		//int random = ran.nextInt(8) + 2;
		System.out.printf("할당된 수는 %d입니다\n", random);
		
		System.out.println("배수를 차례로 입력해주세요");
		int answer;
		int multiple;
		for (int i = 1; ; i++) {
			answer = random * i;
			multiple = scan.nextInt();
			if (multiple != answer)
				break;
		}
		/* 선생님 답안
		정답 변수 선언 초기값 0 -> int answer = 0
		while (true) {
			정답은 반복할 때마다 number만큼 커짐 -> answer += number
			사용자의 입력값 받기
			정답과 비교하기
			if (사용자가 틀림) {
				브레이크
			}
		}
		*/
		System.out.println("틀렸습니다!");
		System.out.println("프로그램 종료");
	}
}