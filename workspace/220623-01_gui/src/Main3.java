import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main3 extends JFrame {
	public Main3() {
		super("버튼 활성화 테스트");
		
		JPanel pnl = new JPanel();
		JButton btnEnable = new JButton("활성화");
		JButton btnDisable = new JButton("비활성화");
		JButton btnNotShown = new JButton("보이나??");
//		JButton btn1 = new JButton("1");
//		JButton btn2 = new JButton("2");
//		JButton btn3 = new JButton("3");
//		JButton btn4 = new JButton("4");
//		JButton btn5 = new JButton("5");
		
		//★★포문으로 만든 버튼들을 배열, list, set에 담아서 기억하고 있어야!!!! 불러서 변화를 일으킬 수 있다
		List<JButton> buttons = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			buttons.add(btn);
			pnl.add(btn);
		}
		
		
//		btnDisable.setEnabled(false); //버튼은 있는데 회색으로 비활성화
		btnNotShown.setVisible(false); //버튼 자체가 안보임! 공간조차 차지 안함
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnDisable) {
//					btn1.setEnabled(false);
//					btn2.setEnabled(false);
//					btn3.setEnabled(false);
//					btn4.setEnabled(false);
//					btn5.setEnabled(false);
					for (JButton j : buttons) { //배열에 담은 버튼들을 불러오기~~
						j.setEnabled(false);
					}
				} else {
//					btn1.setEnabled(true);
//					btn2.setEnabled(true);
//					btn3.setEnabled(true);
//					btn4.setEnabled(true);
//					btn5.setEnabled(true);
					for (JButton j : buttons) { //배열에 담은 버튼들을 불러오기~~
						j.setEnabled(true);
					}
				}
			}
		};
		
		btnEnable.addActionListener(a);
		btnDisable.addActionListener(a);
		
		pnl.add(btnEnable);
		pnl.add(btnDisable);
		pnl.add(btnNotShown);
//		pnl.add(btn1);
//		pnl.add(btn2);
//		pnl.add(btn3);
//		pnl.add(btn4);
//		pnl.add(btn5);
		
		add(pnl);
		
		setSize(new Dimension(500, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Main3 m = new Main3();
		m.setVisible(true);

	}

}
