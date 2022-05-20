import java.util.Scanner;

public class InputString {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		int i = input.nextInt();
		System.out.println("한 줄을 입력하세요");
		input.nextLine(); //이게 없으면 nextInt의 잔여물인 엔터 자체를 입력값으로 인식해서 엔터만 출력된다 ->이걸 넣어서 엔터 없애줌 reset
		String line = input.nextLine();
		
		System.out.println(line);
	}
}