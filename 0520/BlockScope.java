public class BlockScope {
	public static void main(String args[]) {
		// 지역변수의 개념알기
		int a = 10;
		{
			int b = 20;
			//int a = 99; //(X) 재선언
			a = 99; //(O) 재할당
			System.out.println("가능한가?");
			System.out.println(a); //(O) a를 찾는다 ->a변수의 범위(메인메소드)가 아직 지속중. 괄호 안닫혔음.
		}
		// System.out.println(b); //(X) b를 찾지 못한다 ->범위 안에서 만들어진 변수는 범위가 끝나면 사라진다.
	}
}