class Car {
	public int speed;
	public int gear;
	public String color;
	
	public Car() {
		speed = 0;
		gear = 1;
		color = "red";
	}
	public void speedUp() {
		speed += 10;
	}
	public String toString() { //★Car 객체의 상태를 문자열로 반환하는 기본 메소드!!
		return "속도: " + speed + " 기어: " + gear + " 색상: " + color;
	}
}

public class CarArrayTest {

	public static void main(String[] args) {
		final int NUM_CARS = 5;
		Car[] cars = new Car[NUM_CARS]; //cars는  Car type 5개를 가지는 배열
		
//		for (Car c : cars) { 
//			c = new Car(); //cars[0]와 연결된 끈을 c에 불러왔는데(null상태), 그 끈 대신 new Car()를 c에 새로 연결시켜버림
//			System.out.println(c); //결국 new Car()의 값들이 출력되고, car[0]은 여전히 null상태
//		}
		
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car();
		}
//		for (Car c : cars) { //cars[0]와 연결된 끈을 c에 불러왔는데, c에서 speed를 올려버리면 공유중인 cars[0]의 값도 올라감!
//			c.speedUp(); 	 //(비교) for(int number : arr)였다면 끈으로 연결된 공간 공유 개념이 아니기 때문에, number에 변화를 줘도 arr[0]는 변화 없다
//		}
//		for (Car c : cars) { //결국 cars[0]의 값 자체가 바뀌었으니깐 출력도 변화된 값으로 나옴
//			System.out.println(c);
//		}
		for (int i = 0; i < cars.length; i++) {
			cars[i].speedUp();
		}
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]); //★toString() 쓰지도 않았는데 왜 쓴것처럼 출력됨???? 
		} 				//★-> 객체의 출력 시에는 "@어쩌고"로 출력하기 전에, 그 객체  class에 존재하는 "toString"이란 메소드 찾는게 기본행동!! 자동임
	}

}
