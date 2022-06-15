
public interface Flyable {
	
	//필드없음. only 추상메소드만 가질 수 있음
//	public void print() {
//		System.out.println("hello");
//	}
	
	public abstract void fly();
	
	//어차피 모두 추상메소드니깐 (public abstract)생략가능~ -> 예시
//	void fly();
}

class Animal {}
class Bird extends Animal {}
class Eagle extends Bird implements Flyable {
	@Override
	public void fly() {
		System.out.println("독수리가 푸드득 푸드득 납니다");
	}
}
class Penguin extends Bird {}
class FlyingFish extends Animal implements Flyable {
	@Override
	public void fly() {
		System.out.println("날치가 첨벙 첨벙 납니다");
	}
}
class Plane implements Flyable {

	@Override
	public void fly() {
		System.out.println("비행기가 슈우울 납니다");
	}
	
}
