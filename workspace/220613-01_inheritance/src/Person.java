
public class Person {
	private	String name; //자식조차도 부모의 private에는 접근 불가
	protected int age; //★protected접근제한자 : default(자기자신 or 같은 클래스) + 다른 클래스라도 자기 자식이면 추가로 접근할 수 있게 열어둠 
	//So, subclass에서 super.age = age; 가 허용된다
	
	public Person(String name, int age) { //부모의 생성자를 호출
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	
}
