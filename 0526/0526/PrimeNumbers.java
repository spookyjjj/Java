public class PrimeNumbers {
	public static boolean isPrime(int i) {
		int count = 0;
		for (int j = 1; j <= i; j++) {
			if (i % j == 0) {
				count++;
			}
		}
		if (count == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String args[]) {
		for (int i = 2; i < 10000; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}
}