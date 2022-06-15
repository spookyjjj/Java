
public class Main {

	public static void main(String[] args) {
//		Shape s1 = new Shape(); //(X) 추상적이라 인스턴스화 할 수 없다!
//		Shape s2 = new Shape(10, 20); //(X) 도형이라는 도형은 만들수 없다는것..
		
		Triangle t = new Triangle(0, 0, 5, 5); //(O) 구체적이라 인스턴스화 가능!
		System.out.println(t.getArea());
		
		Shape s = t; //upcast한 후, (부모는 인스턴스화 안되지만, 자식의 인스턴스 빌려오면 됨)
		System.out.println(s.getArea()); //★자식의 getArea가능! 이건 오버라이드된 메소드니깐ㅎㅎ
		
		Shape r = new Rectangle(0, 0, 10, 10); //instanceof가 Rectangle이니깐
		System.out.println(r.getArea()); //getArea가능!
	}

}
