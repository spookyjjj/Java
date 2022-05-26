public class TestMethod2 {
	//메소드 이름: 변수이름 지을때와 같다! 주로 동사.. ★변수이름과 겹쳐도 됨! ()가 항상 붙어있을거라서
	public static int sum() { //return type : void(없음) or 반환될 타입을 쓰면 됨
		int a = 10;
		int b = 20;
		int sum = a + b;
		
		return sum; //int sum안에 들은 값을 가지고 main으로 복귀
		//★return은 break와 유사! 함수를 종료를 하고 호출한 곳으로 리턴값가지고 돌아감
		//★★return = sum; 아니라는것~!!!
	}
	
	public static double pi() {
		double a = 3.14;
		
		return a;
	}
	
	public static void main(String args[]) {
		System.out.println("시작");
		
		int result = sum(); //result에 sum()에서 가지고온 값을 넣어 줄 수 있게됨!
		System.out.println(result);
		
		System.out.println(pi());
		
		System.out.println("끝");
	}
}