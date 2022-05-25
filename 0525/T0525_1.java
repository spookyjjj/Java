//(1,1)(1,2)..(1,4)
//..
//(4,1)(4,2)..(4,4)

public class T0525_1 {
	public static void main (String args[]) {
		for (int j = 1; j <= 4; j++) {
			for (int i = 1; i <= 4; i++) {
				System.out.printf("(%d, %d) ", j, i);
			}
			System.out.println("");
		}
	}
}