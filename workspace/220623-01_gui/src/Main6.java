import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main6 extends JFrame{
	public Main6() {
		JPanel pnlTop = new JPanel();
		JPanel pnlBottom = new JPanel();
		JPanel pnlBox = new JPanel();
		
		BoxLayout box = new BoxLayout(pnlBox, BoxLayout.Y_AXIS);
		pnlBox.setLayout(box);
		
		JTextField tf1 = new JTextField(20); //text를 입력하는 컴포넌트
		JTextField tf2 = new JTextField(20); //가로길이를 생성자 파라미터에 넣음!
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tf1.getText(); //JTextField의  .getText() : 입력한 텍스트 가져옴~
				JOptionPane.showMessageDialog(Main6.this, text); //Dialog는 jframe 주된 창 이외에 팝업창 같은것들,,
				//.showMessageDialog(position에 absolute역할을 할 컴포넌트~, 메세지창에 출력하고픈 메시지~); 
				//null : 컴퓨터창이 기준이 됨, 그냥 this : 중괄호 기준 자기것 찾아버림;;;
				tf2.setText(text);
			}
		});
		
		pnlTop.add(tf1);
		pnlTop.add(btn1);
		pnlBottom.add(tf2);
		pnlBottom.add(btn2);
		
		pnlBox.add(pnlTop);
		pnlBox.add(pnlBottom);
		
		add(pnlBox);
		
		pack(); //★창을 컴포넌트 크기에 맞춰서 나오게 하는 메소드~
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	public static void main(String[] args) {
		Main6 m = new Main6();
		m.setVisible(true);
	}

}
