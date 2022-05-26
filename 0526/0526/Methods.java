public class Methods {
	/* 여러개의 값을 리턴하는 메소드는 안만들어 진다!
	public static int, int createTwoNumber() {
		return 20, 30;
	} 
	*/
	
	/* return하고자 하는 값과 실제 return값이 같아야 에러가 안남
	public static boolean test() {
		return 10;
	}
	*/
	
	public static int increase(int a) { //int a는 메인메소드의 int a가 아니라 increase메소드 안의 지역변수
		a++;
		return a;
	}
	
	public static void main(String args[]) {
		int a = 10;
		increase(a); //★Call By Value -> int가 아닌 변수이름을 불러서 넣어도 된다. 대신 int박스여야함
		//즉, a가 가진 값이 복사가 되어 increase 메소드로 들어간다
		a = increase(a); //메인메소드의 변수 a값을 increase메소드 반환값으로 바꿈 
		System.out.println(a); //이건 메인메소드의 변수 a를 출력
	}
}