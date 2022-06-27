import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main4 extends JFrame{
	public Main4() {
		CardLayout cardLayout = new CardLayout(); //카드레이아웃은 next, previous, 키워드로 전환하기 등이 가능
		JPanel center = new JPanel(cardLayout);
		
		JPanel pnl1 = makePanel("첫번째");
		JPanel pnl2 = makePanel("두번째");
		JPanel pnl3 = makePanel("세번째");
		
		center.add(pnl1, "a"); //카드레이아웃은 add할때 전환 키도 같이 입력
		center.add(pnl2, "b");
		center.add(pnl3, "c");
		
		add(center);
		
		cardLayout.show(center, "c"); //키로 부르면 화면 전환이 일어남
		
		//카드레이아웃 버튼으로 순환하는 전환 만들기
		JButton btn1 = new JButton("다음");
		JButton btn2 = new JButton("이전");
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btn1);
		pnlSouth.add(btn2);
		
		add(pnlSouth, "South");
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("다음")) {
					cardLayout.next(center);
				} else {
					cardLayout.previous(center);
				}
			}
		};
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
	}
	
	private JPanel makePanel(String text) {
		JPanel pnl = new JPanel();
		pnl.add(new JLabel(text));
		return pnl;
	}

	public static void main(String[] args) {
		new Main4().setVisible(true);

	}

}
