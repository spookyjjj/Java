import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main4 extends JFrame {
	public Main4() {
		JPanel pnl = new JPanel();
		JPanel pnlTop = new JPanel();
		JPanel pnlBottom = new JPanel();
		
		JRadioButton rdb1 = new JRadioButton("cm → inch");
		JRadioButton rdb2 = new JRadioButton("inch → cm");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdb1);
		group.add(rdb2);
		
		JButton button = new JButton("변환");
		JTextField text = new JTextField("값을 입력하세요", 15);
		JLabel result = new JLabel("결과영역");
		
		pnlTop.add(rdb1);
		pnlTop.add(rdb2);
		pnlTop.add(button);
		pnlBottom.add(text);
		pnlBottom.add(result);
		
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		pnl.add(pnlTop);
		pnl.add(pnlBottom);
		
		text.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) { //포커스가 벗어났을때 ""이었으면 "값을 입력하세요"이고, 뭐라도 값이 있었으면 아무짓도 안함
				if (text.getText().equals("")) {
					text.setText("값을 입력하세요");
				}
			}
			@Override
			public void focusGained(FocusEvent e) { //포커스 되었을때 "값을 입력하세요"면 ""으로 바꾸고 값이 입력되어있으면 아무짓도 안함
				if (text.getText().equals("값을 입력하세요")) {
					text.setText("");
				}
			}
		});
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				버튼1일때, cm->in text.getText()에다가 *0.4
//				버튼2일때, in->cm text.getText()에다가 *2.54
//				String으로 받아서
//				result에 출력하기
				String s = "";
				if (rdb1.isSelected()) {
					s = String.format("%.2f inch", (Integer.valueOf(text.getText()) * 0.4));
					result.setText(s);
				} else if (rdb2.isSelected()) {
					s = String.format("%.2f cm", (Integer.valueOf(text.getText()) * 2.54));
					result.setText(s);
				}
			}
		});
		
		add(pnl);
		setSize(500, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Main4().setVisible(true);

	}

}
