import java.util.Scanner;

public class InputString {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요");
		int i = input.nextInt();
		
		System.out.println("한 줄을 입력하세요");
		input.nextLine(); //★이게 없으면 nextInt의 잔여물인 엔터 자체를 입력값으로 인식해서 엔터만 출력된다 ->이걸 넣어서 엔터 없애줌 reset
		String line = input.nextLine();
		//String line = input.next(); //이것도 있다. 이건 한 줄이 아니라 한 마디(띄어쓰기)를 인식
		
		
		System.out.println(line);
	}
}