public class SwitchCase {
	public static void main (String args[]) {
		int i = 8;
		
		switch (i) { //정수뿐만 아니라 문자열(자바7~)도 인식!! 맞는 case 찾아서 거기서 부터 아래로 싹다 읽음
			case 1:
			System.out.println("일");
			break;
			case 2:
			System.out.println("이");
			break;
			case 3:
			System.out.println("삼");
			break;
			default: //맞는 case를 못 찾으면 디폴트로 옴(like else) 거서부터 아래로 싹다 읽음, 있어도 되고 없어도 되고
			System.out.println("일이삼이 아님");
		}
		System.out.println("프로그램 종료");
	}
}