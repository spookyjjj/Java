import java.util.Scanner;
public class DoWhile{
	public static void main (String args[]) {
		do {
			System.out.println("실행되나?");
		} while (false); //★세미콜론 붙는다는 것~! 꼭꼮꼭~!!!
		//do문장 -> true -> do문장 ... 반복
		//do문장 -> false -> 종료
		//즉, do while은 무조건 1번은 실행하고 그 후에 반복을 할지 결정한다.
		//일반적인 while문으로도 가능한데 그냥 편의를 위해 do while이 있음
		
		Scanner input = new Scanner(System.in);
		int num;
		do {
			System.out.println("10을 나눌 수 입력하시오오오");
			num = input.nextInt();
			if(num == 0) {
				System.out.println("0으로는 나눌 수 없어요요요ㅓㅗ");
			} 
		} while (num == 0);
		System.out.println(10 / num);
	}
}