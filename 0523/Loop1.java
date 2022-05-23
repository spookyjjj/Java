//1부터 10까지 출력하세요
public class Loop1 {
	public static void main (String args[]) {
		/*
		//1부터 10까지 출력하시오
		System.out.println(1); System.out.println(2); System.out.println(3); System.out.println(4); System.out.println(5);
		System.out.println(6); System.out.println(7); System.out.println(8); System.out.println(9);	System.out.println(10);
		->천 개면? 만 개면? ->반복문의 필요성 */
		
		/*
		boolean con = true;
		
		while (con) {
			System.out.println("반복됩니다.");
		} //-> while은 중괄호 끝을 만나면 다시 돌아가서 (조건)을 검사하러 감
		*/
		
		int i = 0;
				
		while (i < 10) { //9까지 들어가야 +1한 10 출력되고 종료
			i++; 
			System.out.println(i);
		}
		
		/* 또는
		int i = 1;
				
		while (i <= 10) { //10까지 들어가야 10출력되고 종료~!
			System.out.println(i);
			i++; 
		}
		*/
		
		int j = 0;
				
		while (j < 5) { //5번 출력한 기록이 있으면 더이상 출력 안하겠다~
			System.out.println("Hello World 5번 출력");
			j++; //한번 출력할 때 마다 횟수 기록~
		}
	}
}