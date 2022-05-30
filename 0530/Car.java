//의자 클래스 제조사,생산일자,가격,모델명 & 초기화 할 수 있는 생산자
class Car {
	private int speed; //private 키워드쓰면, Car라는 자기 자신의 클래스 안에서만 접근가능
	private int gear;
	private String color;
	
	//첫번째 생성자
	public Car(String c, int s, int g) {
		color = c;
		speed = s;
		gear = g;
	}
	//색상만 주어진 생성자
	public Car(String c) {
		// color = c;
		// speed = 0;
		// gear = 1; //쓰고보니 이미 필드 세가지 정의하는 생성자 이미 존재
	
		// Car(c, 0, 1); //이렇게 쓰면 된다
		
		// System.out.println("생성자가 첫 줄 아니게 방해하는 역할"); //(X)
		this(c, 0, 1);	//자기 자신 중, 갯수와 타입이 같은 생성자를 호출한다
	}
	
	void printAll() {
		System.out.println(color);
		System.out.println(speed);
		System.out.println(gear);
	}

	public static void main(String args[]) {
		Car c = new Car("red", 10, 1);
		Car c1 = new Car("red");
		
		c.color = "green"; //(O) Car class안이니깐 private여도 접근가능
		System.out.println(c.color); //(O) 
		
		c.printAll();
	}
}