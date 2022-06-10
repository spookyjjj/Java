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


public class Main2 {
	public final int COLA = 1;
	public final int SPRITE = 2;
	public final int FANTA = 3;
	
	//자판기 메소드
	//정수형 1 -> 반환타입 Can 
	// 1 -> field "콜라"
	//..
	//문자열 COLA -> 반환타입 Can
	// "cola" -> field "콜라"
	//..
	
	public static Can bending(int a) {
		String name;
		if (a == 1) {
			name = "콜라";
		} else if (a == 2) {
			name = "사이다";
		} else if (a == 3) {
			name = "환타";
		} else {
			name = "솔의눈";
		}
		return new Can(name);
	}
	
	public static Can bending(String a) {
		String name;
		if (a.equals("cola")) {
			name = "콜라";
		} else if (a.equals("cider")) {
			name = "사이다";
		} else if (a.equals("fanta")) {
			name = "환타";
		} else {
			name = "솔의눈";
		}
		return new Can(name);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println(bending(sc.nextInt()));
//		System.out.println(bending(sc.nextLine()));
		
//		System.out.println(bending(1));
//		System.out.println(bending("cola"));
	}

}
