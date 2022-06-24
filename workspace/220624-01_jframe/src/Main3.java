import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Main3 extends JFrame {
	public Main3() {
		JPanel pnl = new JPanel();
		JRadioButton rdb1 = new JRadioButton("라디오1");
		JRadioButton rdb2 = new JRadioButton("라디오2");
		JRadioButton rdb3 = new JRadioButton("라디오3");
		//3개 중 한 개만 선택할 수 있도록 하려면, 이 라디오버튼을 하나의 그룹으로 묶어줘야함!!
		ButtonGroup group = new ButtonGroup(); //JButton나 JCheckBox도 들어가긴 하는데 JRadioButton일때만 유의미하다
		group.add(rdb1);
		group.add(rdb2);
		group.add(rdb3);
		
		rdb1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		
		JRadioButton rdb4 = new JRadioButton("라디오4"); //얘네는 그룹에 없으니깐 중복으로 선택 가능하다
		JRadioButton rdb5 = new JRadioButton("라디오5");
		
		pnl.add(rdb1);
		pnl.add(rdb2);
		pnl.add(rdb3);
		pnl.add(rdb4);
		pnl.add(rdb5);
		
		add(pnl);
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main3().setVisible(true);

	}

}
