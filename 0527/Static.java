public class Static {
	public static int number = 100; //전역변수 ★변수 앞에 static이 있어야 동작하지 않았더라도 항상 인식(정적변수)
	
	public static void test() { //★변수 앞에 static이 있어야 동작하지 않았더라도 항상 인식(정적메소드)
		number++;
		System.out.println("테스트 메소드에서 : " + number);
	}
	
	//Q1. static이해하기~시작
	public int a = 300;
	public static int b = 500;
	
	public int c() {
		return 700;
	}
	public static int d() {
		return 900;
	}
	//Q1. static이해하기~끝
	
	public static void main(String args[]) {
		number++;
		System.out.println("메인 메소드에서 : " + number);
		
		test();
		//Static.test(); 와 동일 -> 같은 클래스 안이니 생략하고 쓴거
		
		System.out.println("메인 메소드에서 : " + number);
		//System.out.println("메인 메소드에서 : " + Static.number); 와 동일 -> 같은 클래스 안이니 생략하고 쓴거
			
		//전역변수는 전체 영역에서 값이 바뀌게되므로 관리하기가 힘들다.. -> 최대한 적게 사용하는걸 지향
		//굳이 쓸거라면 final로 고정시켜 쓰자..
		//final 변수로 놓고 쓴 예시 -> Math.PI; (Math클래스에 있는 PI라는 final변수 불러온것!)
		/* 좀 더 알아보자면,
		class Math {
			public static final double PI = 3.14159....;
			public static final double GOLDEN_RATIO = 1.618..;
			public static double abs(double x) {x를 절대값으로 반환하는 내용의 body};
			public static double random() {램덤한 실수값을 반환하는 내용의 body};
		}
		같은 Math클래스가 이미 있음..
		*/
		System.out.println(Math.PI);
		//Math.PI++; //(X) -> final이니깐
		
		/* -----------
		Q1. Math a = new Math(); a.PI;를 안하고 바로 클래스에서 불러오는게 가능한 이유?
		A. Math클래스의 모든 필드,메소드는 static이라서, 인스턴스를 생성하지 않고도 바로 사용할 수 있다.
		---------- */
		
		//Q1. static이해하기~ 시작
		//System.out.println(Static.a); //(X)컴파일에러 -> int a = 100;라서
		Static exF = new Static();
		System.out.println(exF.a); //얘는 객체를 생성해야 필드에 접근이 가능
		System.out.println(Static.b); //(O)-> static int b = 500;정적변수라서 객체생성 없이도 접근 가능!
		
		//System.out.println(Static.c()); //(X)컴파일에러
		Static exM = new Static();
		System.out.println(exM.c()); //얘는 객체를 생성해야 필드에 접근이 가능
		System.out.println(Static.d()); //(O) d메소드는 정적메소드라서 객체생성 없이도 접근 가능!
		//Q1. static이해하기~ 끝
		
		/* -------------
		Q2. import java.lang.Math;안해도 되는 이유?
		A. 자주써서 import 안 써도 작동되게 해놨음 String클래스도 매번 안불러와도 되는것과 마찬가지
		-------------- */
	}
}