class Car {
	private String model;
	public Car(String model) {
		this.model = model;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Car) {
			return model.equals(((Car) obj).model);
		} else {
			return false;
		}
	}
}
public class CarTest {
	public static void main(String[] args) {
		Car firstCar = new Car("HMW520");
		Car secondCar = new Car("HMW520");
		if (firstCar.equals(secondCar)) { //동일한 종류의 자동차입니다. 전달된게 Car타입(O)->모델필드String동일(O)
			System.out.println("동일한 종류의 자동차입니다.");
		} else {
			System.out.println("동일한 종류의 자동차가 아닙니다.");
		}
		if (firstCar.equals("HMW520")) { //동일한 종류의 자동차가 아닙니다. 왜냐하면 애초에 전달되는게 String이라서!
			System.out.println("동일한 종류의 자동차입니다.");
		} else {
			System.out.println("동일한 종류의 자동차가 아닙니다.");
		}
	}
}
