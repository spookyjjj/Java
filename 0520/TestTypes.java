public class TestTypes {
	public static void main(String args[]) {
		byte b = 10; 
		short s = 100;
		int i = 1000;
		//int i = 1000L; //손실이 있을 수 있다는 에러
		//int i = (int) 1000L; //int로 형변환 시켜주면 극복. 1000이 출력
		//int i = (int) 3215458456326L; //아예 int가 담을 수 없는 값을 넣어버리면 형변환으로 극복은 되겠지만, 완전 다른값이 출력됨
		long l = 10000; //L안붙여주면 int취급
		
		//1000L: 태생 long VS (long)1000: 태생 1000인데 long으로 바꾼것
		
		//short sum = b + s; //(X) 더 큰 박스 short를 준비했음에도 에러나는 이유? 계산할땐 수를 int로 자동적 형변환! 
		//int sum = b + s; //(O) 								cf) byte b = (int) 10; 명시적 형변환!
		long sum = b + s; //(O)
		System.out.println(sum);
		
		double d = 123.456;
		// int i2 = d; //손실이 있을 수 있다는 컴파일 에러
		int i2 = (int) d; //극복 -> 손실(소수점 부분)을 감수하고서 명시적 형변환. 이건 자주쓴다~!!
		System.out.println(i2);
		
		//int i3 = (int) true; //(X)불연값은 형변환 안됨
		int num = (int) 'A'; //하지만 char만은 내장된 수가 있기때문에 형변환 가능
		System.out.println(num); 
	}
}