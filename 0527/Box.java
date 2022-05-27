//자바에서는 객체가 class로 표현됨
public class Box {
	//객체를 이루는 값(=상태) -> 필드(fields) 혹은 멤버변수(member variable)라 부름
	int length;
	int width;
	int height;
	/*
	int volume = length * width * height; 
	※Box()로 인스턴스 불러올때 기본값을 0으로 주기때문에 volume은 0이됨
	*/
	
	//객체를 이루는 메소드(=기능or동작)
	public void printAllState() { //static이라는게 빠져있다? -> 나중에 배울거임
		System.out.println(width);
		System.out.println(length);
		System.out.println(height);
	}
	
	//자기 자신의 부피를 구하기?
	//정수형 값으로 돌려주는 메소드를 이용
	public int getVol() { //★각 인스턴스에 정해진 변수들 가지고 지지고볶고 할거라서 파라미터 필요없음
		return length * width * height;
	}
	
	//static이해하기~
	int a = 100;
	static int b = 500;
}