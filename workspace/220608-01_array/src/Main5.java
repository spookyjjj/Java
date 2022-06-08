import java.util.Arrays;

public class Main5 {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		//★for-each문 -> 인덱스 고려없이 걍 한 방향으로 전부 쭉 읽어줌
		for (int number : arr) { //왼쪽은 값(참조)을 담을 타입과 박스이름 (":" 기준!) 오른쪽은 배열과 같이 여러개를 담는 객체 
			arr[0] = 50; //0번 인덱스는 수정 값으로 출력 안됨~~ arr[0]을 number에 담고 나서야 for문 안으로 들어왔으니 기본값으로 출력됨
			arr[1] = 50; //얘는 수정된 값 나옴~~ 두번째 부터는 for문 한번 돌면서 변한 arr[1]값을 number에 담고 들어오니깐 변한값으로 출력됨
			arr[2] = 50; //얘도 수정된 값 나옴~~ 위와 동일한 이유
			number += 1; //number에다가 뭘 해도  arr 원본 배열에는 변화X
					     //(비교) for(Car c : cars)였다면 c의 참조가 car[0]의 참조와 같은곳이기 때문에 c에 변화를 주면 car[0]도 변함!
			System.out.println(number);
		} //★그래서, 이런저런거 생각할 것 없이 그냥 for-each에서는 '='쓰는거 지양하자~~
		System.out.println(Arrays.toString(arr)); //+1 없이 [10, 20 , 30, 40, 50]나옴
	}

}
