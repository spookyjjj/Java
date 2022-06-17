import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("프로그램시작");
	
		Scanner scan = new Scanner(System.in);
		
		//try-catch 예외처리 꼬라지
//		try {
//			예외가 발생할 수 있을 것 같은 문장들
//			프로그램 흐름 문장
//			정상적으로 흘러가면 pass
//			근데 예외오류가 나면 catch로 들어감
//		} catch (내가 잡고자 하는 예외를 타입으로 명시) {
//			예외를 처리하는 문장-> 오류로 프로그램이 종료되는 것을 막는다
//		}
		
		try { //nextInt스캐너에 문자열 집어넣는 경우의 예외처리
			System.out.println("왼쪽 수 입력?");
			int left = scan.nextInt(); 
			System.out.println("오른쪽 수 입력?");
			int right = scan.nextInt();
			
			if (right != 0) { // 0일 때 예외처리
				System.out.println("나눈 몫: " + (left / right));
			} else {
				System.out.println("분모에 0을 넣을 수 없습니다");
			}
		} catch (InputMismatchException e) { //객체라서 이름 설정 필요. 유틸패키지 클래스니깐 임포트 필요
			System.out.println("숫자를 입력하셔야 합니다 선생님");
			System.out.println(e.getMessage()); //★어떤 오류메세지인지 출력
			e.printStackTrace(); //★예외 발생된 경로를 콘솔창에 출력하라~
		}
		
		System.out.println("프로그램종료");

	}

}
