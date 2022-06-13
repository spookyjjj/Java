import java.util.Scanner;

class Can {
	private String name;
	
	public Can(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}

class VendingMachine {
	public static final int COLA = 1;
	public static final int SPRITE = 2;
	public static final int FANTA = 3;
	
	public Can makeCan(int choice) {
		if (choice == COLA) {
			return new Can("콜라");
		} else if (choice == SPRITE) {
			return new Can("사이다");
		} else if (choice == FANTA){
			return new Can("환타");
		} else {
			return new Can("솔의눈");
		}
	}
	
	public Can makeCan(String choice) {
		if (choice.equals("cola")) {
			return new Can("콜라");
		} else if (choice.equals("cider")) {
			return new Can("사이다");
		} else if (choice.equals("fanta")) {
			return new Can("환타");
		} else {
			return new Can("솔의눈");
		}
	}
}


public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VendingMachine m = new VendingMachine();
		System.out.println(m.makeCan(1));
		System.out.println(m.makeCan("cider"));
		
		//스캐너로 받아내는 방법?!
	}
}
