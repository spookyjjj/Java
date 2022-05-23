public class Loop2{
	public static void main (String args[]) {
		//1. 10 9 8 .. 0 출력하시오
		int k = 10;
				
		while (k >= 0) { //0까지 들어가야
			System.out.println(k); //0까지 나오고
			k--; //-1은 팅겨서 나옴
		}
		
		//2. 20부터 29까지 출력하시오
		int j = 20;
				
		while (j <= 29) { //29까지 들어가야
			System.out.println(j); //29까지 나오고
			j++;  //30은 팅겨서 나옴
		}
		
		//3. 50아래의 3의 배수를 출력해 보시오 0 3 9 12 ...
		int l = 0;
				
		while (l < 50) { 
			System.out.println(l); 
			l += 3;  
		}
		
		//4. ★☆번갈아서, 총 8번 나오게
		int s = 1;
		
		while (s <= 8) { 
			if (s % 2 == 0){
				System.out.println("☆");
			} else {
				System.out.println("★");
			}
			//또는 System.out.println((s % 2 == 0) ? "☆" : "★");
			s++; 
		}
	}
}