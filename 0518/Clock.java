//사용자에게 초단위의 시간을 입력받아 시간 분 초로 변환을 하는 프로그램
//입력예) 3666 출력예) 1시간 1분 6초

import java.util.Scanner;

public class Clock{
	public  static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("초단위 시간을 입력하시오: ");
		int sec = input.nextInt();
		
		int h = (sec / 3600); //시간 단위(3600) 몫
		int m = ((sec % 3600) / 60); //시간 단위 나누고 남은 초를 분단위(60)로 나눈 몫
		int s = ((sec % 3600) % 60); //분단위로 나누고 남은 나머지 초들 (=sec%60)
		System.out.println(h + "시간 " + m + "분 " + s + "초" );
	}
}