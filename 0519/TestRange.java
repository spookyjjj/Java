public class TestRange {
	public static void main(String args[]) {
		//0 ~ 100 사이? 
		int num = -50;
		
		System.out.println(0 <= num);
		System.out.println(num <= 100);
		// System.out.println(0 <= num <= 100); -> 컴파일에러! true<=100를 비교하게 되어버림
		System.out.println((0 <= num) && (num <= 100)); //&&연산자를 이용해서 연결
	}
}