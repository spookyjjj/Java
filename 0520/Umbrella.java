//오늘의 날씨를 물어보고 "비"를 입력받으면 우산을 챙겨가라고 문자열을 출력하는 프로그램
import java.util.Scanner;

public class Umbrella {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("오늘의 날씨? ");
		String weather = input.nextLine();
		
		boolean condition = weather.equals("비"); //스트링의 값 동일은 equals이용!!
		if (condition) {
			System.out.println("우산을 챙겨가세요.");
		}
		System.out.println("좋은 하루 보내세요.");
	}
}