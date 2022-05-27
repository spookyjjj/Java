public class TestBox {
	public static void main(String args[]) {
		Box box1; //Box라는 클래스가 참조형type으로 사용됨 -> Box클래스를 참조할 box1이라는 이름의 상자 생성 
		box1 = new Box(); //★인스턴스화 : box1의 참조 끈을 인스턴스박스(new Box() : Box의 값과 메소드들이 담김)에 연결
		
		box1.width = 3; //★box1이름을 가진 애의 끈이 연결된 인스턴스 박스 안에 .이하의 값(width)을 찾아감!
		box1.length = 4;
		box1.height = 5;
		//System.out.println(box1.color); //color라는 필드가 없으므로 컴파일에러
		
		Box box2 = new Box(); //★box2의 참조끈을 또 새로운 인스턴스 박스에 연결~!
		box2.width = 10;
		box2.length = 11;
		box2.height = 12;
		
		System.out.println(box1.width);
		System.out.println(box1.length);
		System.out.println(box1.height);
		box1.printAllState(); //★box1이름을 가진 애의 끈이 연결된 인스턴스 박스 안에 .이하의 메소드(printAllState())를 호출!
		
		/*
		System.out.println(box1.volume);
		※new Box()할때, class내에 width,length,height 초기값이 없어 임의로 0을 집어넣게 되고
		volume에는 그들의 곱 0이 들어가게됨.
		이후에 width length height는 값이 변경되었지만, volume은 여전히 0인 상태
		따라서 값 받고 나서 다시 계산하는 과정이 필요함
		*/
		System.out.println(box1.getVol()); 
		
		System.out.println(box2.width);
		box2.printAllState();
		
		box1.width = 5;
		System.out.println(box1.width);
		
		// Box none = null; //인스턴스박스가 null 즉, 참조하는게 없다
		// none.width = 3; //컴파일은 됨 -> 문법은 맞다고 여겨짐, but 실행오류
		
		
		//static이해하기~
		//System.out.println(Box.a); //(X)컴파일에러 -> int a = 100;라서
		
		Box box3 = new Box();
		System.out.println(box3.a);
		
		System.out.println(Box.b); //(O)-> static int b = 500;이라서
	}
}