import java.util.Scanner;
public class ArrayTest1 {
	public static void main(String[] args) {
		final int STUDENT = 5;
		int total = 0;
		Scanner scan = new Scanner(System.in);
		int[] scores = new int[STUDENT];
		for (int i = 0; i < STUDENT; i++) {
			System.out.println("성적을 입력하시오: ");
			scores[i] = scan.nextInt();
			total += scores[i];
		}
		System.out.println("평균 성적은 " + total / STUDENT + "입니다");
	}
}
