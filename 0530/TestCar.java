class Car {
	private int speed; //private 키워드쓰면, Car라는 자기 자신의 클래스 안에서만 접근가능
	private int gear;
	private String color;
	
	public Car(String c, int s, int g) {
		color = c;
		speed = s;
		gear = g;
	}
	
	public Car(String c) {
		this(c, 0, 1);
	}
	
	//색상에게 접근, 설정
	public String getColor() {
		return color;
	}
	public void setColor(String c) {
		color = c;
	}
	//속도에게 접근, 설정
	public int getspeed() {
		return speed;
	}
	public void setspeed(int s) {
		speed = s;
	}
	//기어에게 접근, 설정
	public int getgear() {
		return gear;
	}
	public void setgear(int g) {
		gear = g;
	}
}

//별개의 class라는것~!!!

public class TestCar{ //Car과 다른 class인 TestCar에서는 Car의 private에 접근 안됨!!!
	public static void main(String args[]) {
		Car c = new Car("red", 10, 1);		
		//c.color = "green"; //(X) 설정도 안되고
		//System.out.println(c.color); //(X) 출력도 안됨
		//-------일반적으로는 private에 접근 안됨----------
		c.setColor("green");
		System.out.println(c.getColor());
		//-------하지만 따로 관련 메소드를 만들어 두었다면, 이를 통해서는 접근가능--------
	}
}