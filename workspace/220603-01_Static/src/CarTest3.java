class Car {
	private String color;
	private int speed;
	private int gear;
	private int id;	//자동차의 시리얼 번호
	private static int numberOfCars = 0; //실체화된 car 객체의 개수를 위한 정적변수
	//★★-> 만약 static이 없었다면, 인트턴스마다 각각의 numberOfCars 가질 뿐.. 결국 1짜리만 여러개 쌓인다
	
	public Car(String c, int s, int g) {
		color = c;
		speed = s;
		gear = g;
		//자동차의 갯수를 증가하고 id번호를 할당한다
		id = ++numberOfCars;
	}
	//정적 메소드
	public static int getNumberOfCars() {
		return numberOfCars;
	}
	
	public void printStaticNumber() {
		System.out.println(numberOfCars);
	}
	
//	public static void printColor() { //color는 객체 생성 되어야 존재하는건데, static하게 color 출력하라그러면 어찌할바를..모름..
//		System.out.println(color); //★즉, 정적 메소드에서는 인스턴스 변수와 인스턴스 메소드에 접근할 수 없다
//	}
}


public class CarTest3 {
	public static void main(String args[]) {
		//Car.numberOfCars; //정적변수라도, private하면 볼수 없음!!
		int n = Car.getNumberOfCars(); //public한 getter이용~! //0
		
		//Car.printStaticNumber() //클래스 이름으로 부르기 안된다~! 얘는 안 static한 메소드라서, 객체 생성 후에 쓸 수 있음
		
		Car c1 = new Car("blue", 100, 1); // id = 1
		Car c2 = new Car("white", 0, 1); // id = 2
		
		n = Car.getNumberOfCars(); //2
		
		c1.printStaticNumber(); //2
		c2.printStaticNumber(); //2 //★c1이나 c2나 NumberOfCars()는 인스턴스마다가 아니라 클래스에 단 1개라 공유~!
		
		System.out.println("지금까지 생성된 자동차 수 = " + n);
	}
}
