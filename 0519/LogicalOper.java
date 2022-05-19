public class LogicalOper {
	public static void main(String args[]) {
		//and연산자(&&)와 논리값 -> 둘다 true일때만 true
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);

		//or연산자(||)와 논리값 -> 하나라도 true면 true
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
	}
}