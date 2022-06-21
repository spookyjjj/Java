import java.util.Deque;
import java.util.LinkedList;

public class Main3 {

	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<>();
		//Deque라는 인터페이스가 stack을 위한 기능들 다 담고있다~
		//stack은 빼달라고하면 맨 뒤에꺼부터 빼줌
		//마찬가지고 LinkedList가 List Queue Deque모두 구현하고 있으니 골라서 쓰면됨~
		
		stack.push("10"); //Deque에서만 쓰는 추가 메소드
		stack.push("20");
		stack.push("30"); //차곡차곡 쌓여서
		
		System.out.println(stack.pop()); //Deque에서만 쓰는 제거 메소드
		System.out.println(stack.pop()); //맨뒤에꺼부터 뽑아다 줌
		System.out.println(stack.pop());
	}

}
