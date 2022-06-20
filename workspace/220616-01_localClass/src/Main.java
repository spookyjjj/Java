interface PrintAll {
	void printAll();
}
//얘를 구현하고싶어~!

public class Main {
	public static void main(String[] args) {
		//by로컬클래스
//		class Point implements PrintAll{
//			int x;
//			int y;
//			public Point(int x, int y) {
//				this.x = x;
//				this.y = y;
//			}
//			@Override
//			public void printAll() {
//				System.out.println(x);
//				System.out.println(y);
//			}
//		}
//		
//		Point p = new Point(10, 20); 
		//메인메소드에서 잠시 사용하고 말 객체들은 따로 외부에 빼지 않고 안에서 걍 만들어서 쓰면 됨
		
		//==============================================
		
		//by익명클래스
		PrintAll a = new PrintAll() {
			@Override
			public void printAll() {
				System.out.println("너무 어려워요");
			}
		}; //a에다 참조해놓기
		a.printAll(); //a를 출력하기
		//이러면 아예 구현을 위해 자식클래스를 따로 만들 필요도 없음!
		
		//==============================================
		
		new PrintAll() {
			@Override
			public void printAll() {
				System.out.println("너무 어려워요");
			}
		}.printAll(); //찐! 일회용
	}

}
