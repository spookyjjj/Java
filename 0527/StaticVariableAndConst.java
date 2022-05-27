public class StaticVariableAndConst {
	public static void main(String args[]) {
		int i = 10;
		i++;
		System.out.println(i); //변수인 i가 11로 변한거지 상수인 10은 그대로임 
		
		final int MY_NUMBER = 22; //final int로 선언하면, 상수처럼 변하지 않는 값이 됨
		//MY_NUMBER++; //(X) -> ★재할당이 안된다는 컴파일에러! 즉, 22에 +1한 값을 재할당하려 시도했지만 final이라 불가했다~		
		//final 키워드가 붙으면, 대문자와 언더바로 이름을 짓는다
		
		final double PI = 3.14;
		System.out.println(5 * 5 * PI);
	}
}