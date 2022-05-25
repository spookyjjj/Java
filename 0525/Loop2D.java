public class Loop2D {
	public static void main (String args[]) {
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) { //inner loop부터 보고, outer loop를 파악
				System.out.print('*');
			}
			System.out.println();
		}
		
		//구구단 만들기
		for (int j = 2; j <= 9; j++) {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", j, i, j * i);
			}
			System.out.println(j + "단 끝!");
		}
	}
}