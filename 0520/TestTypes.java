public class TestTypes {
	public static void main(String args[]) {
		byte b = 10; 
		//byte b = (int)10; 과 같지 않다;; 이렇게만 알아두기  
		short s = 100;
		int i = 1000;
		// int i = 1000L; //손실이 있을 수 있다는 에러
		//int i = (int)1000L; //int로 형변환 시켜주면 극복. 1000이 출력
		//int i = (int)3215458456326L; //아예 int가 담을 수 없는 값을 넣어버리면 형변환으로 극복은 되겠지만, 완전 다른값이 출력됨
		long l = 10000; //L안붙여주면 int취급
		
		//추가질문) 1000L는 그럼 (long)1000? noooo.. 전자는 태생long, 밑에것은 태생 1000인데 long으로 바꾼것
		
		//short sum = b + s; //(X) 더 큰 박스 short를 준비했음에도 에러나는 이유? 계산할땐 수를 기본적으로 int취급하기 때문에 작은박스가 되버림
		//int sum = b + s; //(O)
		long sum = b + s; //(O)
		System.out.println(sum);
		
		double d = 123.456;
		// int i2 = d; //손실이 있을 수 있다는 에러
		int i2 = (int) d; //손실(소수점 부분)을 감수하고서 형변환. 이건 자주쓴다~!!
		System.out.println(i2);
		
		//int i3 = (int) true; //(X)불연값은 형변환 안됨
		//char a = 'A';
		int num = (int) 'A'; //하지만 char만은 내장된 수가 있기때문에 형변환 가능
		System.out.println(num); 
	}
}