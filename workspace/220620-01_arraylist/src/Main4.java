import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main4 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("apple");
		list.add("banana");
		list.add("carrot");
		list.add("dounut");
		
		System.out.println(list.contains("banana"));
		System.out.println(list.contains(new String("banana"))); //원소가 있는지 없는지는 equals로 찾아내고 있다!! 참조동일이 아니라 값동일
		
		list.remove("dounut");
		System.out.println(list); //지울때도 마찬가지로 equals로 값이 동일하면 지움
		
		list.add("dounut");
		
		//위의 리스트에서 5글자 문자열만 찾아서 지우기
		//0. for문 -> remove하면 index가 자꾸 변해서 불안정.. i--쓰면 되지 않냐 하는데, 논리적 오류 발생가능성 높아진다는 것 자체 때매 선호안함
		//1. for-each -> 위의 이유에다가 포이치는 변경, 삭제안된다는 문제~!!
//		for (String s : list) {
//			if(s.length() == 5) {
//				list.remove(s);
//			}
//		}
//		System.out.println(list);
		//2. ★iterable(반복자:리스트를 순회할 수 있게 해주는 객체)을 사용 <-interface. list가 상속하고 있다
		Iterator<String> iterator = list.iterator(); //list.iterator()의 리턴타입이 Iterator임 얘으 기능은 값을 담는게 아니라 가리키는거!
		while(iterator.hasNext()) {
			String str = iterator.next(); //다음거 가리켜라
			if (str.length() == 5) {
				iterator.remove(); //가리키고 있는거 지워라 -> ★list에 반영됨(참조가 같아서!!!)
			}
		}
		System.out.println(list);
	}

}
