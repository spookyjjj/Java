public class FloatTypes {
	public static void main(String args[]) {
		float f = 123.456F; //f(F)을 붙여야 플롯타입이라는걸 인식. 안하면 double을 float에 넣는게 되어 오류!
		double d = 7777.8888; //기본형은 double
		
		/*
		float sum = f + d; -> (X)
		double sum = f + d; -> (O) 즉, 실수끼리 연산도 큰 범위를 따라가므로 큰 박스 준비!!
		*/
		
		/*
		int i = 10000;
		int sum = i + f; -> (X) 
		float sum = i + f; -> (O) 실수와 정수끼리 연산은 큰 범위인 실수를 따라가므로 큰 박스 준비!!
		*/
		
		float one = 0.1F; //0.1자체가 1근사값! 오차발생
		System.out.printf("%.15f\n", one * 22); //%f는 실수 서식! %.15f는 소숫점이하 15자리까지 표현하겠다~!
		System.out.printf("%5d\n", 10); //%d는 정수 서식! %10d는 10자리까지 표현하겠다~!
		System.out.printf("%05d", 10); //%010d는 10자리까지 표현하고, 빈자리는 0으로 표현하겠다~!
	}
}