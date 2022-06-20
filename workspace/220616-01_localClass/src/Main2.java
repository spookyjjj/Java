
interface Days { //인터페이스안에 추상메소드 안넣고 필드값 넣으면!
	int num = 10; //public static final int num = 10;인거임~
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WENDSDAY = 3;
}

interface MyInterface { //인터페이스는 항상 public 어디에서든 호출가능,,,
	default void prtintHello() { //interface의 추상메소드 바디에는 원래 암것도 없는데, default붙이면 기본값으로 바디 꾸밀수 있다
		System.out.println("Hello");
	}
	
	
	//java9버전 부터는 interface에 private를 붙일 수 있음 지금쓰는 8버전은 private안됨
	
	public static void myStaticMethod() {}
	static int sum(int a, int b) { //static은 해당 클래스 부르기만 해도(객체생성없이) 항상 작동하는 놈! 
		return a + b;			//★추상메소드가 아니라 걍 정적메소드이기 때문에 인터페이스안에 있어도 상관없다! 
	}
}

public class Main2 {
	public static void main(String arg[]) {
		System.out.println(Days.num);
//		Days.num = 100; //final상수라서 변경안됨
		
	}
}
