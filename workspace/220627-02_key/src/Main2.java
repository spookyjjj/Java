import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main2 extends JFrame {
	public Main2() {
		JPanel pnl = new JPanel();
		JTextField tf = new JTextField(10);
		JPasswordField pf = new JPasswordField(10); 
		
		JTextArea ta = new JTextArea(20, 20);
		JScrollPane scrl = new JScrollPane(ta); //생성자에 스크롤 붙이고 싶은 컴포넌트 넣으면됨 <-JScrollPane이 담고있는거임!
		
		pnl.add(tf);
		pnl.add(pf);
		
		add(pnl);
		add(scrl, "South");
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { //textField에서의 action은 엔터임!!
				System.out.println("엔터누름");
			}
		});
		
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int id = e.getID();
				if (id == KeyEvent.KEY_TYPED) {
					char ch = e.getKeyChar();
//					ta.setText(내용); //.setText() 얘는 전체를 다 바꾸는거
					ta.append(String.valueOf(ch) + "\n"); //.append() 얘는 덧붙히는거
				}
			}
		});
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
	}
	public static void main(String[] args) {
		new Main2().setVisible(true);
	}
}
