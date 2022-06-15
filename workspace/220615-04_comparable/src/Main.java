import java.util.Arrays;

class Member2 implements Comparable<Member2> { //자바에 만들어져있는 interface인 Comparable를 쓰면 Arrays.sort까지도 연동됨
	String name;
	int height;
	int weight;
	public Member2(String name, int height, int weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	@Override //자바에 만들어져있는 interface인 Comparable의 추상메소드인 compareTo를 재정의 해줘야함
	public int compareTo(Member2 o) { //리턴과 파라미터까지 똑같아야 오버라이딩. 제네릭 안쓰면(<Member>) Object가 들어가있어서 골라내줘야함
		return this.height - o.height;
	}
//	public int compare(Member member) { //직접 만든 메소드 -> Arrays.sorts가 써먹는 비교기준이 못됨
//		return this.height - member.height;
//	}
	
}
public class Main {
	public static void main(String[] args) {
		Member2[] members = {new Member2("키큰놈", 190, 60), new Member2("키작은놈", 130, 30), new Member2("중간즈음", 176, 65)};
		System.out.println(members[0].compareTo(members[1]));
		Arrays.sort(members); //자바에 만들어져있는 interface인 Comparable를 썼기에 가능!
		System.out.println(members[0].height);
		System.out.println(members[1].height);
		System.out.println(members[2].height);
	}
}
