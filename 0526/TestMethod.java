public class TestMethod {
	//메소드는 클래스 안에~!!
	public static void printRepeat() { //메소드 머리(head), printRepeat라는 메소드를 만들었을 뿐 실행되는 부분은 아님! 
		//메소드 몸통(body), 비워져 있어도 ok
		for (int i = 0; i < 3; i++) {
			System.out.println("반복중");
		}
	}
	public static void printHello() {
		//int num = 10; //지역변수
		System.out.println("Hello");
		//System.out.println("초기화한 변수 값: " + num); //num 찾아낸다
	}
	
	public static void main(String args[]) { //실행 흐름은 여기서부터 시작한다~!
		System.out.println("프로그램 시작~!");
		
		printRepeat(); //만든 메소드를 호출
		printHello();
		//System.out.println("헬로 안에서 초기화한 변수 값: " + num); //num 찾아내지 못한다
		
		System.out.println("프로그램 끝~!");
	}
}