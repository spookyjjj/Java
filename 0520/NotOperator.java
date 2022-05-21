public class NotOperator {
	public static void main(String args[]) {
		boolean t =  true;
		
		t = !t; //!는 not. 논리를 뒤집는 연산자
		System.out.println(t);
		
		//!((10 > 3) && (3 == 3)) -> F
		//!(!(10 > 3) || (3 == 3)) -> F
	}
}