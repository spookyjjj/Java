import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyCounter extends JFrame {
	private int number = 0;
	
	public MyCounter() {
		super("카운터");
		
		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel(String.valueOf(number)); //int값을 안받아서 String으로 변환해줄 필요있음
		
		//증가버튼 만들기~~
		JButton btn = new JButton("증가");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				number++;
				lbl.setText(String.valueOf(number)); //int값을 안받아서 String으로 변환해줄 필요있음
			}
		});
		
		//이제 감소버튼 만들기~~
		JButton btn2 = new JButton("감소");
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				number--;
				lbl.setText(String.valueOf(number)); //int값을 안받아서 String으로 변환해줄 필요있음
			}
		});
		
		pnl.add(lbl);
		pnl.add(btn);
		pnl.add(btn2);
		
		add(pnl);
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyCounter().setVisible(true);

	}

}
