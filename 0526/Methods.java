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
	
	//숫자 하나가 짝수 홀수인지 알아낼수있는 메소드 만들기
	public static String evenodd(int a) {
		if (a % 2 == 0) {
			return "짝수";
		} else {
			return "홀수";
		}
	}
	public static void main(String args[]) {
		int a = 10;
		increase(a); //★Call By Value -> int가 아닌 변수이름을 불러서 넣어도 된다. 대신 int박스여야함
		a = increase(a); //메인메소드의 변수 a값을 increase메소드 반환값으로 바꿈 
		System.out.println(a); //이건 메인메소드의 변수 a를 출력
		
		System.out.println(evenodd(100));
		
	}
}