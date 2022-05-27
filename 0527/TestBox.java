public class TestBox {
	public static void main(String args[]) {
		Box box1; //★Box클래스가 참조형type으로 사용됨 -> Box클래스 내용물을 담을 box1이라는 이름의 상자 생성 
		box1 = new Box(); //★인스턴스화 : box1의 끈을 new Box()인스턴스(Box클래스의 구조로 실제 할당될 '저장공간')에 연결! 
		
		box1.width = 3; //★box1상자와 연결된 인스턴스에다가 .이하에 기재된 필드(width)를 찾아 실제 값을 채워넣음!
		box1.length = 4;
		box1.height = 5;
		//System.out.println(box1.color); //color라는 필드가 없으므로 컴파일에러
		
		Box box2 = new Box(); //★box2의 끈을 또 새로운 인스턴스('저장공간')에 연결~!
		box2.width = 10;
		box2.length = 11;
		box2.height = 12;
		
		System.out.println(box1.width);
		System.out.println(box1.length);
		System.out.println(box1.height);
		box1.printAllState(); //★box1상자와 연결된 인스턴스를 base로 하면서, .이하에 기재된 메소드(printAllState())를 호출!
		
		/*
		자기 자신의 부피를 구하기? by필드 이용
		
		System.out.println(box1.volume); -> 0이 나옴
		
		왜냐하면.. new Box()로 인스턴스화 할 때, class내에 width,length,height 초기값이 없어 임의로 0을 저장공간에 집어넣게 되고
		volume의 값은 그들의 곱인 0이 들어가게 됨.
		이후에 width length height은 3, 4, 5로 새로 할당되었지만, volume은 건드리질 않아 여전히 0인 상태인거
		해결하려면 새로 할당된 값으로 부피 계산하는 과정이 필요함
		*/
		System.out.println(box1.getVol()); 
		
		System.out.println(box2.width);
		box2.printAllState();
		
		box1.width = 5;
		System.out.println(box1.width);
		
		// Box none = null; //인스턴스박스가 null 즉, 참조하는게 없다
		// none.width = 3; //컴파일은 됨 -> 문법은 맞다고 여겨짐, but 실행오류
		
		
		
	}
}