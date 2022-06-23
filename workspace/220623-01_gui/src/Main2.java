import javax.swing.JFrame;
//★나만의 gui를 만들 수 있다! JFrame을 상속을 통해 가져다가 쓰면서~ 이게 기본틀입니다
class MyFrame extends JFrame {
	public MyFrame(String title) {
		super(title);
		
		this.setSize(500, 500); //setSize(500, 500) -> this안붙여도됨ㅎㅎ차피 지꺼니깐
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setDefaultCloseOperation(EXIT_ON_CLOSE) -> 얘도 앞에거 다 떼도됨ㅎㅎ
	}
}


public class Main2 {

	public static void main(String[] args) {
		JFrame frame = new MyFrame("나만의 프레임");
		frame.setVisible(true);

	}

}
