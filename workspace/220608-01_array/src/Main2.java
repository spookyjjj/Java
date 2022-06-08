
public class Main2 {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		
		int[] copy = arr; //★이건 참조를 공유한다는 개념!!
		
		arr[0] = 1000; //so, arr의 값을 바꾸면
		
		for (int i = 0; i <copy.length; i++) { //copy도 바뀜! arr의 인스턴스를 참조하고 있기때문에 
			System.out.println(copy[i]);
		}
		
		System.out.println("-------인스턴스 공유가 아닌 값 복사는?-------");
		
		int[] arr2 = {10, 20, 30, 40, 50};
		
		int[] copy2 = new int[arr2.length]; //값만 복사
		for (int i = 0; i < arr2.length; i++) {
			copy2[i] = arr2[i];
		}
		
		arr2[0] = 1000; //arr2의 값을 바꿔도,
		
		for (int i = 0; i <copy2.length; i++) { //copy2의 값은 노터치
			System.out.println(copy2[i]);
		}
	}

}
