class Dog {
	private String name;
	private String breed;
	private int age;
	
	public Dog(String name, String breed, int age) {
		//name = name; 둘다 파라미터 name으로 인식해버린다
		this.name = name; //this.name이라고 해줘야 필드name을 가져옴
		this.breed = breed;
		this.age = age;
	}
	public Dog(String name, String breed) {
		this(name , breed, 1);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void printAll() {
		System.out.println(name);
		System.out.println(breed);
		System.out.println(age);
	}
}

//위와 아래는 다른 클래스~~~~
public class TestDog {
	public static void main(String arg[]) {
		Dog d1 = new Dog("겨울", "포메라니안", 3);
		d1.printAll();
		
		Dog d2 = new Dog("길이", "잡종");
		d2.printAll();
		
		d2.setName("퐁이");
		d2.setBreed("진도");
		d2.setAge(5);
		
		System.out.println(d2.getName());
		System.out.println(d2.getBreed());
		System.out.println(d2.getAge());
	}
}