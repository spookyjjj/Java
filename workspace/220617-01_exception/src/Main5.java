
public class Main5  {
	public static int divide(int left, int right) throws MyException { //여기는 "throws" 실제로 여러 예외클래스 나열 가능
		if (right == 0) {
			throw new MyException("나눌 수 없음"); //여기는 "throw"
		} else {
			return left / right;
		}
	}
	public static int myFunction() {
			//아직 미완성
//			return  0;
			throw new UnsupportedOperationException("내일 만들게 아직 덜 만듬"); //덜 만든거 티내기!
		
	}
	
	public static void main(String args[]) {
		try {
			divide(100, 0); //이렇게하면 try문 안에 또 if써서 throw할 필요가 없어짐. 메소드 자체에서 다 일어나니깐?
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		
//		divide(1000, 0);
		//이 메소드의 예외처리가 Exception을 확장한게 아니라 RuntimeException를 확장했다면 예외처리 안해줘도 컴파일에러 안남
		//========================
		//Exception클래스
		//checked는 무조건 예외처리 해야함 -> 안하면 컴파일 에러
		//RuntimeException클래스 
		//unchecked는 해도되고 안해도 되고 -> 안해도 컴파일 에러는 안나는데 런타임에러 날거임
		myFunction();
		
	}
}
