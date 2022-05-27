class Car {
	//필드 정의
	String color;
	int speed;
	int gear;
	void print() {
		System.out.println("( " + color + ", " + speed + ", " + gear + " )");
	}
}

public class CarTest { //★public이 붙은 쪽의 class이름으로 파일명을 저장해야 컴파일 에러가 안난다~!
	public static void main(String args[]) {
		Car myCar = new Car(); //객체(인스턴스) 생성
		myCar.color = "red";
		myCar.speed = 0; //객체의 필드 변경
		myCar.gear = 1;
		myCar.print(); //객체의 메소드 호출
		
		Car yourCar = new Car(); //또 새로운 객체(인스턴스) 생성
		yourCar.color = "blue";
		yourCar.speed = 60; //객체의 필드 변경
		yourCar.gear = 3;
		yourCar.print(); //객체의 메소드 호출 -> 이건 항상 공통이라는 것을 알 수 있음
	}
}