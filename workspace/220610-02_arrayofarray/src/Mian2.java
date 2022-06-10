import java.util.Arrays;

public class Mian2 {
	public static void main(String[] args) {
		//2~5의 제곱수들을 각 원소로 가지는 2차원 배열 선언 초기화 후에 모든 원소 출력해보기
		//2 4 8 16..
		//3 9 27 81..
		//..
		
//		int[] a = new int[6];
//		int[] b = new int[6];
//		int[] c = new int[6];
//		int[] d = new int[6];
		
//		int num = 1;
//		for (int i = 0; i < 6; i++) {
//			num *= 2;
//			a[i] = num;
//		}
//		num = 1;
//		for (int i = 0; i < 6; i++) {
//			num *= 3;
//			b[i] = num;
//		}
//		num = 1;		
//		for (int i = 0; i < 6; i++) {
//			num *= 4;
//			c[i] = num;
//		}
//		num = 1;
//		for (int i = 0; i < 6; i++) {
//			num *= 5;
//			d[i] = num;
//		}
//		num = 1;
//		for (int i = 0; i < 6; i++) {
//			num *= 5;
//			e[i] = num;
//		}
//		
//		int[][] sq = new int[4][6];	
//		
//		sq[0] = a;
//		sq[1] = b;
//		sq[2] = c;
//		sq[3] = d;
		
		int[][] sq = new int[4][6]; //sq.length = 4(세로)!!!! sq[0].length = 6(가로)!!!!!!!!!!
		
		for (int j = 2; j <= 5; j++) { 		//for (int j = 0; j < sq.length; j++) <-j를 0으로 하고 length사용하려면
			int num = 1;					//	int num = 1;
			for (int i = 0; i < 6; i++) { 	//	for (int i = 0; i < sq[j].length; i++)
				num *= j; 					//		num *= j + 2
				sq[j-2][i] = num; 			//		sq[j][i] = num;
			}
		}

//		System.out.println(Arrays.toString(sq[0]));
//		System.out.println(Arrays.toString(sq[1]));
//		System.out.println(Arrays.toString(sq[2]));
//		System.out.println(Arrays.toString(sq[3]));
		
		System.out.println(Arrays.deepToString(sq)); //★deepToString(배열)메소드를 쓰면 이중배열 안쪽까지 들어가서 문자열로 바꿔준다~!
		
		int[][] arr = {{2, 4, 8, 16, 32, 64},{3, 9, 27, 81, 243, 729},{4, 16, 64, 256, 1024, 4096},{5, 25, 125, 625, 3125, 15625}};
		
		System.out.println(Arrays.equals(sq, arr)); //(X) 마찬가지로.. sq와 arr의 참조가 다르기 때문에 
		System.out.println(Arrays.deepEquals(sq, arr)); //★deepEquals(배열1, 배열2)메소드를 써야 값 동일을 체크 할 수 있다!
	}
}
