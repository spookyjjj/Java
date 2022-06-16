interface PrintAll {
	void printAll();
}


public class Main {
	public static void main(String[] args) {
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
		//이게 로컬클래스임,,
		
		//==============================================
		
		PrintAll a = new PrintAll() {
			@Override
			public void printAll() {
				System.out.println("너무 어려워요");
			}
		}; //a에다 참조해놓기
		a.printAll(); //a를 출력하기
		
		//==============================================
		
		new PrintAll() {
			@Override
			public void printAll() {
				System.out.println("너무 어려워요");
			}
		}.printAll(); //찐 일회용
	}

}
