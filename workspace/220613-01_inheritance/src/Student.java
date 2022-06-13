
public class Student extends Person {
	private int score;
	
	public int getScore() {
		return score;
	}
	public Student(String name, int age, int score) {
		//this.name = name; //this에는 더이상 name이란 필드가 없다
		//super.name = name; //super에 존재하는 필드는 private라 접근이 안된다
		super(name, age); //★얘도 생성자안에 생성자를 쓰고 있으니 첫문장이여야 한다~!!
		this.score = score;
	}
	public void setAge() { //superclass의 age필드는 proteted라서 자식이 ★자기것 처럼 접근가능
		super.age = 110; //(O) 부모의 필드라고 명시해도 되지만
		this.age = 120; //(O) 자기 자신의 것처럼 불러도 됨
		age = 100; //(O) 
	}
}
