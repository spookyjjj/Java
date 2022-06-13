import java.util.Arrays;

public class Main {
	static void insertionSort(int[] arr) { //삽입정렬의 소스코드
	   for(int index = 1 ; index < arr.length ; index++){
	      int temp = arr[index];
	      int aux = index - 1;

	      while( (aux >= 0) && ( arr[aux] > temp ) ) {
	         arr[aux + 1] = arr[aux];
	         aux--;
	      }
	      arr[aux + 1] = temp;
	   }
	}

	public static void main(String[] args) {
		int[] arr = {50, 30, 20, 60, 10};
		
//		Arrays.sort(arr); //Arrays의 정렬 메소드 -> 정렬 기준이 없는  배열에 sort를 쓰면 컴파일은 되지만, 실행오류!
//		System.out.println(Arrays.toString(arr));
		
		insertionSort(arr); //디버그 이용해서 어떤과정인지 확인해보기
		System.out.println(Arrays.toString(arr));
		
		//정렬을 통해 배열에 의미를 주면, 값을 찾아내기도 쉬워짐  즉, 검색을 위해서의 조건 1.정렬되어있기 2.중복된 값이 없기
		//예를 들면 이진검색!! -> 절반을 보고 또 그 절반의 절반을 보고...
		
		int index = Arrays.binarySearch(arr, 20); //Arrays의 값 찾기 메소드
		System.out.println("20의 인덱스: " + index);
		
		
	}

}
