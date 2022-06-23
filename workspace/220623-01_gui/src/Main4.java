import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main4 extends JFrame {
	public Main4() {
		JPanel pnl = new JPanel();
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		btn1.setActionCommand("임의의 커멘드"); //.getActionCommand()때 가져올 텍스트 설정
		
		pnl.add(btn1);
		pnl.add(btn2);
		add(pnl);
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()); //.getActionCommand()는 버튼의 텍스트값을 가져온다 ->따로 커멘트를 설정해뒀다면 그게 나옴
			}
		};
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) {
		Main4 m = new Main4();
		m.setVisible(true);
	}

}
