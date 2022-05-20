public class IntegerTypes {
	public static void main(String args[]) {
		byte b = 100;
		short s = 30000;
		int i = 10_000_000; //자릿수 표현! 쉼표(X)->컴파일에러, 언더바(O)! 기본형은 int
		long l = 123456789L; //l(L)을 붙여야 롱타입이라는걸 인식함
		
		/*
		byte b2 = 100;
		byte sum = b + b2; -> byte(~127)를 넘어선 범위의 값! -> 컴파일에러
		*/
		
		/*
		int sum = 100 + 100L; -> (X)
		long sum = 100 + 100L; -> (O) 즉, 정수끼리 연산은 큰 범위를 따라가므로 큰 박스 준비!!
		*/
	}
}