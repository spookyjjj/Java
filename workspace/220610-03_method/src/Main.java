
public class Main {
	public static void someMethod(int param) {
		
	}
	
	public static void sum(int a, int b) {
		System.out.println(a + b);
	}
	public static void sum(double a, double b) { //Method Overloading!! 
		System.out.println(a + b);
	}
	//★메소드의 중복은 메소드 이름뿐만아니라 파라미터 타입, 갯수도 따지므로, 파라미터 다르게해서 여러개 만들기 가능
	//만약 메소드 이름과 파라미터 타입,갯수가 같다면 ★★리턴타입이 다르더라도 똑같은 메소드라고 인식함
	
	
	
	public static void main(String[] args) {
		//파라미터 타입에 맞는 애만 들어갈 수가 있음ㅠㅠ
//		someMethod(3791.03733);
//		someMethod("sdf");
		
		//하지만 얘가 쓰는 메소드는 아무 타입이나 다 들어가는디요? -> Method Overloading을 해놔서 그럼;;
		System.out.println(123123);
		System.out.println(123.123);
		System.out.println("123123");
		
		sum(13, 42);
		sum(13.5, 42.6);
	}

}
