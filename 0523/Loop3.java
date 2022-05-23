public class Loop3{
	public static void main (String args[]) {
		//5. 0부터 100사이의 수 중 3의 배수 또는 7의 배수를 출력. 예)0 3 6 7 9 12 14 15 ..
		int i = 0;
		while (i < 100) {
			if (i % 3 == 0 || i % 7 == 0) {
			System.out.println(i);
			}
			i++;
		}
		
		//6. 0부터 100사이의 수 중 일의 자리ㅣ 수가 3, 6, 9 일때만 출력. 예) 3 6 9 13 16 19 ..
		int j = 0;
		while (j < 100) {
			if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9) { //일의 자리만 골라내는건 %10하면 된다는 것~!
			System.out.println(j);
			} 
			j++;
		}
	}
}