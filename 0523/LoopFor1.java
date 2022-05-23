public class LoopFor1{
	public static void main (String args[]) {
		/* 기존 while 반복문 -> ★조건이 만족될 때 까지 계속해야 할 때는 while문을 잘 이용함~!!!!
		int i = 0;
		while (i < 5) {
			System.out.println("출력");
			i++;
		}
		*/
		
		//for문을 이용하여 "출력" 5회 반복 -> ★숫자를 세면서 하는건 for문을 잘 이용함~!!!!
		for (int i = 0; i < 5; i++) { //for( 선언부(초기화까지); 조건부; 증감부(중괄호끝나면 여기로 옴->조건부로 감) )
			System.out.println("출력"); //true일땐 중괄호 안으로 들어옴
		} //false일땐 중괄호 밖으로
		
		/* for문의 특징 1
		int i = 0 	//따로 선언했다면 선언부 비워둬도 ok
		for ( ; ; ) { 	//조건부 비워둬도 ok->true로 인식, 증감부도 비워둬도 ok->대신 변화가 없으니 계속반복됨
		}
		*/
		
		/* for문의 특징 2
		for ( int i = 0; ; ) {
		}
		System.out.println(i); 	//(X) for문 밖에서는 i를 인식하지 못한다. i는 {}안의 지역변수이기 때문에
		★따라서, for문마다 int i = 값 이라고 선언,초기화를 해도 상관없다~!! */
		
		//for문을 사용하여 1부터 10까지 출력하기
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		//for문을 사용하여 21부터 30까지 3의배수 출력하기
		for (int i = 21; i <= 30; i += 3) {
			System.out.println(i);
		}
		
		//for문을 사용하여 30 29 28 ... 20 까지 역순 출력하기
		for (int i = 30; i >= 20; i--) {
			System.out.println(i);
		}
	}
}