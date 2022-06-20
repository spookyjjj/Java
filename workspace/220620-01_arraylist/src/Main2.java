import java.util.ArrayList;

public class Main2 {

	public static void main(String[] args) {
		
//		ArrayList list = new ArrayList();
//		list.add(10);
//		list.add(20);
//		list.add(30);
//		list.add(40);
//		int sum = 0;
//		for (int i = 0; i < list.size(); i++) { //컴파일에러! Object중에는 합연산 안되는 애도 있음
//			sum += list.get(i);			//★Integer만 있다고 보장되면 얘는 오토언박싱되니깐 합연산 됨!
//		} 
//		System.out.println(sum);
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(20);
		list2.add(30);
		list2.add(40);
		
//		list2.add("asdf"); //제네릭에 걸려서 컴파일 에러
		
		int sum = 0;
		for (int i = 0; i < list2.size(); i++) { 
			sum += list2.get(i);
		} 
		System.out.println(sum);
	}

}
