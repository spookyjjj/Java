import java.util.Arrays;
import java.util.Random;

public class Main3 {
	public static int[][] randomArray() {
		Random random = new Random();
		int[][] array = new int[7][5];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = random.nextInt(10);
			}
		}
		
		return array;
	}
	
	//예쁘게 출력하기
	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
		
	//각 행의 합
	public static int[] rowSum(int[][] a) {
		
//		int sum = 0;
//		for (int i = 0; i < a[0].length; i++) {
//			sum += a[0][i];
//		}
		//이걸 줄 마다 반복해서, 나온 값은 리턴할 배열에다 집어넣으면 됨~!
		int[] rowSum = new int[a.length];
		for (int j = 0; j < a.length; j++) {
			int sum = 0;
			for (int i = 0; i < a[j].length; i++) {
				sum += a[j][i];
			}
			rowSum[j] = sum;
		}
		return rowSum;
	}
	
	//각 열의 합
	public static int[] columSum(int[][] a) {
//		int sum = 0;
//		for (int i = 0; i < a.length; i++) {
//			sum += a[i][0];
//		}
		//이걸 행 마다 반복해서, 나온값은 리턴할 배열에다 집어 넣으면 됨~!
		int[] columSum = new int[a[0].length];
		for (int j = 0; j < a[0].length; j++) {
			int sum = 0;
			for (int i = 0; i < a.length; i++) {
				sum += a[i][j];
			}
			columSum[j] = sum;
		}
		return columSum;
	}
	
	//숫자 7의 개수
	public static int count7(int[][] a) {
		int count = 0;
		for (int j = 0; j < a.length; j++) { //세로 갯수
			for (int i = 0; i < a[j].length; i++) { //가로 갯수
				if (a[j][i] == 7) {
					count++;
				}
			}
		}
		return count;
	}
	
	//----------선생님 풀이---------------
	//배열을 집어넣으면 배열의 합을 구하는 메소드를 만들어버리면,
	//열의 합은 각 열의 배열을 걍 집어넣으면 되고, 행의 합은 ★행만 떼서 따로 배열 만드는 메소드를 생성해★, 거기서 나온걸 합공장에 집어넣음~
	public static int[] col(int[][] array, int col) {
		int[] columArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			columArray[i] = array[i][col];
		}
		return columArray;
	}
	public static int sum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	//★★★★★
	public static void print2(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(Arrays.toString(array[i]));
			System.out.println(sum(array[i]));
		}
		for (int i = 0; i < array[0].length; i++) {
			System.out.print(sum(col(array, i)) + " ");
		}
	}
	
	
	
	public static void main(String[] args) {
		int[][] randomArray = randomArray();
		
//		System.out.println(Arrays.deepToString(randomArray));
		
//		System.out.println(Arrays.toString(randomArray[0]));
//		System.out.println(Arrays.toString(randomArray[1]));
//		System.out.println(Arrays.toString(randomArray[2]));
//		System.out.println(Arrays.toString(randomArray[3]));
//		System.out.println(Arrays.toString(randomArray[4]));
//		System.out.println(Arrays.toString(randomArray[5]));
//		System.out.println(Arrays.toString(randomArray[6]));
		
		print(randomArray);
		
		System.out.println("각 열의 합 : " + Arrays.toString(rowSum(randomArray)));
		System.out.println("각 행의 합: " + Arrays.toString(columSum(randomArray)));
		System.out.println("7의 개수: " + count7(randomArray));
		
		//-------------선생님풀이------------
		System.out.println(Arrays.toString(col(randomArray,0)));
		System.out.println(sum(col(randomArray,0)));
		print2(randomArray);
	}

}
