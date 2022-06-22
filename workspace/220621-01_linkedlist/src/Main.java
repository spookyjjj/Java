import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		//ArrayList와 LinkedList는 거의 똑같다~!! 차이점은? 밑에,,
		list.add("문자열01");
		list.add("문자열02");
		list.add("문자열03");
		list.add("문자열04");
		
		list.get(0);
		list.get(1);
		list.get(2);
		list.get(3);
		
		for (int i = 0; i <list.size(); i++) {
			list.get(i);
		}
		
		for (String s : list) {
			System.out.println(s);
		}
		
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		List<String> list2 = new LinkedList<>(Arrays.asList("a", "b", "c", "d"));
		//ArrayList와 달리 LinkedList는 추가 삭제시 인덱스 번호가 왔다갔다 하는게 아니라, 앞과의 연결을 끊냐 마냐 이기 때문에
		//자주 추가 삭제하는 경우에는 LinkedList를 쓰면 좋고
		//모든 원소에 순차적 접근을 해야 할 때는 ArrayList를 쓰면 좋다 (주소찾아가기 잘함)
		list2.remove(0);
		System.out.println(list2);
		LinkedList<String> down = (LinkedList) list2;
		//★아래의 메소드들은 LinkedList에서 추가된 애들이라서 list에서 다운캐스팅되어야 사용가능 
		down.addFirst("asdf");
		System.out.println(list2);
		down.removeFirst();
		down.getFirst();
		
		List<Integer> test = Arrays.asList(10, 20, 30, 40, 50); 
		test.add(60); //★생성자로 만든 리스트는 변경, 추가가 안됨!!
		System.out.println(test);
		
	}

}
