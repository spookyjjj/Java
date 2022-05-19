public class AutoInc {
	public static void main(String args[]) {
		int a = 10;
		
		//복합대입연산자 +=, -=, ...
		a += 1; //11
		a -= 1; //10
		
		//증감연산자 (1씩 증감!)
		a++; //11
		a++; //12
		a++; //13
		
		a--; //12
		a--; //11
		System.out.println(a);
		
		int b = 20;
		System.out.println(b++); //증감연산자가 뒤에 붙었으면 b값부터 부르고(20) 더하기 수행(21)
		/* 즉,
		System.out.println(b);
		b++;
		*/
		System.out.println(++b); //증감연산자가 앞에 붙었으면 +부터 수행한 후(22) b값을 부름(22)
		/* 즉,
		b++;
		System.out.println(b);
		*/
		// ++b; b++; 가능
	}
}