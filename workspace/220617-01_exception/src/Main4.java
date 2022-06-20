import java.time.LocalTime;

public class Main4 {
	public static void main(String arg[]) {
		try {
			int left = 10;
			int right = 0;
			
			if (right == 0) {
				//0으로 나눌려고 함(예외적인 상황)
				//보고서 적어서 던질거임
				throw new MyException("0으로 나누는 예외적인 상황이 발생했습니다~~"); 
				//Exception 클래스는 필드로  메세지를 가지고 있다. 이 메세지 값을 채울 수 있는 생성자 사용!
				//throw는 catch랑 한쌍
			}
		} catch (MyException e) { //여기서 throw를 받음
			System.out.println(e.getMessage());
		}
	}
}


