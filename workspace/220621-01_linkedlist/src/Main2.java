import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {

	public static void main(String[] args) { 
		Queue<String> queue = new LinkedList<>(Arrays.asList("a", "b", "c", "d")); //linklist생성이니깐 aslist됨~
		//★Queue는 젤 앞에꺼 빼가고, 젤 뒤에 추가하고~
		//★LinkedList는 Queue도, List도 구현하고있으니(implements는 ,로 여러개 가능)
		//뭘로 쓰고 싶은지 대략 정해지면 그걸로 업캐스팅해서 쓰자~
		queue.add("원소1");
		queue.offer("원소2"); //Queue에서만 쓰는 메소드 add와 유사함
		
		System.out.println(queue);
		
		
		String elem1 = queue.poll(); //언제나 앞에있는 원소를 빼내서 //->원소없음 null반환
		String elem2 = queue.remove(); //그 원소를 반환 //->원소없으면 예외발생
		
		System.out.println(elem1);
		System.out.println(elem2);
		
		System.out.println(queue.size());
		

	}

}
