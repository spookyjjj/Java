public class StaticVariableAndConst2 {
	public static void main(String args[]) {
		int inner = 10;
		//System.out.println(TEST_SCOPE); //(X) 선언,할당 전에 출력 안됨
		final int TEST_SCOPE = 20;
		
		{
			System.out.println(inner);
			System.out.println(TEST_SCOPE);
			
			//final int TEST_SCOPE; //(X) 재선언 안됨
			final int BLOCK = 100;
		}
		
		//System.out.println(BLOCK); //(X) 지역변수 범위 밖
	}
}