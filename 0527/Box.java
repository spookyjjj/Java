//자바에서는 객체가 class로 표현됨
public class Box {
	//객체를 이루는 값(=상태) -> 필드(fields) 혹은 멤버변수(member variable)라 부름
	int length;
	int width;
	int height;
	//자기 자신의 부피를 구하기? by필드 이용
	//int volume = length * width * height;	//(X)실행오류..Box()의 기본값이 0이라서
	
	//객체를 이루는 메소드(=기능or동작)
	public void printAllState() { //static 빠져있다는거 체크
		System.out.println(width);
		System.out.println(length);
		System.out.println(height);
	}
	
	//자기 자신의 부피를 구하기? by메소드 이용
	public int getVol() { //★각 인스턴스에 저장된 변수들 가지고 지지고볶고 할거라서 파라미터 필요없음
		return length * width * height;
	}
	

}