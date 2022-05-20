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
		//바로 print하는 것이 아닌 a++; 혹은 ++a;꼴로 쓸 때는,
		//결국 a에 1더한 값을 내부에 저장하고 있을 뿐(출력X)인건 같기에 아무거나 써도 됨~
		//일반적으로 a++을 사용
		
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