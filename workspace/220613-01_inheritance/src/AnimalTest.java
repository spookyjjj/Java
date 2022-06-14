
class Animal {
	protected void sleep() {
		System.out.println("zzz");
	}
	protected void eat() {
		System.out.println("냠냠");
	}
	
	protected void sound() { //메소드 오버라이드 할 대상!
		System.out.println("동물은 제각각의 소리를 냅니다");
	}
}


class Dog extends Animal {
	public void bark() {
		System.out.println("멍멍");
	}
	
	@Override //annotation을 사용해서 제대로 쓴건지 체크!!
	protected void sound() { //메소드 오버라이드 <-부모의 헤더부분은 고대로~ 바디만 바뀜
		System.out.println("헥헥");
	}
}

class Cat extends Animal {
	public void play() {
		System.out.println("와다닥");
	}
	
	@Override //annotation을 사용해서 제대로 쓴건지 체크!!
	protected void sound() { //메소드 오버라이드 <-부모의 헤더부분은 고대로~ 바디만 바뀜
		System.out.println("골골");
	}
}


public class AnimalTest {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.sound();
		
		Dog d = new Dog();
		d.sleep();
		d.eat();
		d.bark();
		d.sound();
		
		Cat c = new Cat();
		c.sleep();
		c.eat();
		c.play();
		c.sound();
		
		System.out.println("========다형성=========");
		Animal a2 = new Dog();
		a2.sound(); //헥헥 -> ★override한것은 원래 인스턴스의 것 따라가지 형변환 후의 것 안따라감!!
		
		Animal another = new Animal();
		another.sound(); //동물은 제각각의 소리를 냅니다
		
		Animal a3 = new Cat();
//		Dog d2 = (Dog) a3; //컴파일은 되지만 실행오류 -> Cat인스턴스를 Dog로 형변환 시키려 해서
				
		Object o = new Dog(); //Object는 java에 기본적으로 있는, 모든 객체의 최상위클래스~!
		//Object에 있는 메소드가 equals, toString(Dog@12546)임! 그래서 어떠한 객체더라도 이 두 메소드를 쓸 수 있었던것.
		//우리가 클래서 생성후에 만든 toString메소드는 사실 Object의 toString을 override한것이었다,,
	}

}
