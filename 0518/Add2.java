//사용자가 입력한 두 개의 숫자를 더해서 출력한다.
import java.util.Scanner; //Scanner 클래스 가져옴 (from 자바클래스라이브러리)

public class Add2 {
	public static void main(String args[]) {
		//사용자에게 입력 받기 위해 Scanner의 Instance 생성.
		/*  Scanner input; 변수선언과 (Scanner가 type, input이 변수이름)
			input = new Scanner(System.in); 초기화를 한 줄로 표현한 것 */
		Scanner input = new Scanner(System.in);
		int x;
		int y;
		int sum;
		
		System.out.print("첫 번째 숫자를 입력하시오: ");
		x = input.nextInt(); //Scanner클래스의 nextInt라는 메소드 호출
		
		System.out.print("두 번째 숫자를 입력하시오: ");
		y = input.nextInt();
		
		sum = x + y;
		
		System.out.println(sum);
	}
	
}