
public final class MyImpleClass extends MySubClass { //★종단선언 final
	//손자는 myMethod1은 구체화할 책임이 없다! 자식이 이미 해 놨기 때문에~
	@Override
	public void myMethod2() { //손자는 자식의 추상메소드만 책임지면 됨.
		System.out.println("마이메소드2 손자 클래스에서 구현되었습니다.");
	}
	//만일 자식에서 부모의 myMethod1를 구체화 하지 않았다면, 손자가 myMethod, myMethod2 전부 구현해야할 책임..
	
//	★myMethod가 자식클래스에서 final되었기 때문에 손자가 다시 override못함
//	@Override
//	public void myMethod() {
//		System.out.println("마이메소드를 자식이 구현했음에도 손자가 새롭게 오버라이드");
//	}
	
	public static void main(String arg[]) {
		MyClass m = new MyImpleClass();
		m.myMethod();
		
		MySubClass sub = (MySubClass) m; //다운캐스딩
		sub.myMethod2();
	}
	//즉, 지금의 형에서 정의된 메소드만 실행되지만
	//그 메소드가 오버라이드 되었다면 instanceof의 형 쫒아가서 실행
}
