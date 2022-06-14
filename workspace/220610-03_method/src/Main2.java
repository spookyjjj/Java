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
	//★문자열을 받아와 숫자면 리턴T, 문자면 리턴F하는 메소드
	static boolean checkNumber(String str){ 
		if(str.equals(""))
		{
			//문자열이 공백인지 확인
			return false;
		}
		char check;
		for(int i = 0; i<str.length(); i++){
			check = str.charAt(i);
			if( check < 48 || check > 57) //48=0, ... ,57=9 이므로 이 아스키 밖의 문자는 숫자가 아님!
			{
				return false;
			}
		}		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VendingMachine m = new VendingMachine();
		System.out.println(m.makeCan(1));
		System.out.println(m.makeCan("cider"));
		
		//★스캐너로 받아내는 방법?! -> boolean checkNumber(String str)라는 메소드 생성해서 써먹으면 됨
		System.out.print("입력하세요: ");
		String str = sc.next();
		if(checkNumber(str)) {
			System.out.println(m.makeCan(Integer.parseInt(str)));
		} else {
			System.out.println(m.makeCan(str));
		}
	}
}
