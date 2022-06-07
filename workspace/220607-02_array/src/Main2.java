public class Main2 {
	public static void main(String[] args) {
		//길이가 5인 정수형 배열을 선언 초기화하고, 모든 원소의 값을 100으로 설정하기
		int[] a = new int[5];
		
		for (int i = 0; i < a.length; i++ ) {
			a[i] = 100;
		}
		
//		a[0] = 100;
//		a[1] = 100;
//		a[2] = 100;
//		a[3] = 100;
//		a[4] = 100;
//		a[5] = 100; //(X) 컴파일은 되지만, 실행할 때 에러난다~!
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + "번째 index 원소값: " + a[i]);
		}
		
		System.out.println("프로그램 종료");
	}
}
