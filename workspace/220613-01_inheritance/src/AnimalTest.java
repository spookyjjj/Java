
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
		
	}

}
