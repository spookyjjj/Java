
public abstract class MySubClass extends MyClass { //추상 클래스의 자식도 추상클래스가 될 수 있다
//	@Override
//	public void myMethod() { //자식이 부모의 추상메소드를 구현해 놓았다면, 손자는?
//		System.out.println("마이메소드 자식 클래스에서 구현되었습니다.");
//	}
	
	@Override
	public final void myMethod() { //★메소드에 final을 붙이면 손자가 override 못함!!
		System.out.println("마이메소드 자식 클래스에서 구현되었습니다.");
	}
	
	public abstract void myMethod2();
}
