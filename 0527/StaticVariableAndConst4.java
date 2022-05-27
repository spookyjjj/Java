public class StaticVariableAndConst4 {
	public static int number = 100; //전역변수! 변수 앞에 static이 있어야 동작하지 않더라도 항상 인식함..
	
	public static void test() {
		number++;
		System.out.println("테스트 메소드에서 : " + number);
	}
	
	public static void main(String args[]) {
		number++;
		System.out.println("메인 메소드에서 : " + number);
		
		test();
		//StaticVariableAndConst4.test(); 와 동일 -> 같은 클래스 안이니 생략하고 쓴거
		
		System.out.println("메인 메소드에서 : " + number);
		//System.out.println("메인 메소드에서 : " + StaticVariableAndConst4.number); 와 동일 -> 같은 클래스 안이니 생략하고 쓴거
			
		//전역변수는 전체 영역에서 값이 바뀌므로 관리하기가 힘들다.. -> 최대한 적게 사용하는걸 지향
		
		//굳이 쓸거라면  고정시켜 쓰자..
		//final 변수로 놓고 쓴 예시
		// Math.PI; //Math클래스에 있는 PI라는 변수 불러오기!
		/* 즉,
		class Math {
			public static final double PI = 3.14159....;
			public static final double GOLDEN_RATIO = 1.618..;
			public static double abs(double x) {x를 절대값으로 반환하는 내용의 body};
			public static double random() {램덤한 실수값을 반환하는 내용의 body};
		}
		같은게 Math클래스에 이미 있음
		*/
		System.out.println(Math.PI);
		//Math.PI++; //(X) -> final이니깐
		
		/* 
		Q. Math a = new Math(); a.PI;를 안하고 바로 클래스에서 불러오는게 가능한 이유?
		A. Math클래스의 모든 필드,메소드는 static이라서, 인스턴스를 생성하지 않고도 바로 사용할 수 있다.
		Q. import java.lang.Math;안하는 이유는?
		A. 자주써서 import안써도 작동되게 해놨음 String클래스도 매번 안불러와도 되는것과 마찬가지
		*/
	}
}