public class Main {
	public static void main(String args[]) {
		Eagle e = new Eagle();
		Bird b = e; //upcast
		Animal a = e; //upcast
		
		Flyable f = e; //e가 flyable 인터페이스를 impements하니깐 가능! 
		f.fly(); //e가 override하여 구체화한 메소드가 실행됨
		
//		Flyable test = new Penguin(); //(X) penguin은 flyable 인터페이스를 impements안하는 놈이니깐
		
		Flyable p = new Plane();
		Flyable fish = new FlyingFish();
		
		p.fly();
		fish.fly();
		
		Eagle downCasting = (Eagle) f; //downcast
		downCasting.fly(); //f가 애초에 eagle이었으니 원활~
//		Plane downCasting2 = (Plane) f; //downcast
//		downCasting2.fly(); //f가 eagle이었는데 plane에다 집어넣으려고 하니 실행오류!
		//따라서 다운캐스팅의 짝궁 instanceof사용
		if (f instanceof Eagle) {
			Plane downCasting2 = (Plane) f;
			downCasting2.fly();
		}
	}
}
