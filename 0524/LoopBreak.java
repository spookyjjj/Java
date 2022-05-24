public class LoopBreak {
	public static void main (String args[]) {
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				break; //그 "즉시" 반복이 중단되고 for/while문 밖으로 나감 -> 선호도는 낮다!
			}
			System.out.println(i);
		}
		System.out.println("프로그램 종료");
		// 일반 break;는 가장 가까운쪽의 반복문에서 탈출
		// break outer_loop;라고하면 모든 루프에서 탈출
		
		for (int i = 10; i < 20; i++) {
			if (i % 10 == 5) {
				continue; //현재 반복은 넘어가고 다음 반복으로~ -> i++ ->조건 확인 -> ..
			}
			System.out.println(i);
		}
		
		int i = 20;
		while (i < 30) {
			if (i == 25) {
				continue; //이렇게 써버리면 25일때 현재 반복 넘어가 버려서 i++가 안됨 -> i값이 계속 25 -> 종료X
			}
			System.out.println(i);
			i++;
		}
		System.out.println("프로그램 종료");
	}
}