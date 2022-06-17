import java.time.LocalTime;

public class MyException extends Exception {
	public MyException(String message) {
		super(message + ", " + LocalTime.now() + "에 발생하였음"); //super생성자 중 String만 넣으면 되는거 부른것
		//즉, message + ", " + LocalTime.now() + "에 발생하였음" 이게 다 하나의 String이다~!
	}
}
