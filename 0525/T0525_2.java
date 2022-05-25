//(1) (2) (3) (4) (5)
//(5) (4) (3) (2) (1)
//(1) (2) (3) (4) (5)
//(5) (4) (3) (2) (1)
//(1) (2) (3) (4) (5)

public class T0525_2 {
	public static void main (String args[]) {
		for (int j = 1; j <= 5; j++) {
			if (j % 2 != 0) {
				for (int i = 1; i <= 5; i++) {
					System.out.printf("(%d) ",i);
				}
			} else {
				for (int i = 5; i > 0 ; i--) {
				System.out.printf("(%d) ", i);
				}
			}
				System.out.println("");
		}
	}
}