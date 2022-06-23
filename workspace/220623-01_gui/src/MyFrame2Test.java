import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame2 extends JFrame {
	public MyFrame2() {
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MyFrame");
		
		JButton button = new JButton("버튼");
		
		getContentPane().setLayout(new FlowLayout()); //이거 안하면 화면 전체가 버튼이되어버림
		getContentPane().add(button);
		//getContentPane()를 생략해도 상관없음
//		setLayout(new FlowLayout());
//		this.add(button);
		
		JButton button2 = new JButton("버튼2");
		add(button2);
		
		setVisible(true);
	}
}
public class MyFrame2Test {

	public static void main(String[] args) {
		MyFrame2 f = new MyFrame2();

	}

}
