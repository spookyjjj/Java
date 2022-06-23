import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyCounter2 extends JFrame { 
	//이 클래스 자체에 implements ActionListener해서 이 클래스 안에 override하고, 부를때는 btn.addActionListener(this)하는 방법도 존재
	//-> 대신 이렇게 하면 컴포넌트들을 생성자 안에서의 지역변수가 아니라, 전역변수로 바꿔줘야함(필드)
	private int number = 0;
	
	public MyCounter2() {
		super("카운터");
		
		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel(String.valueOf(number)); //int값을 안받아서 String으로 변환해줄 필요있음
		
//		//증가버튼 만들기~~
//		JButton btn = new JButton("증가");
//		btn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				number++;
//				lbl.setText(String.valueOf(number)); //int값을 안받아서 String으로 변환해줄 필요있음
//			}
//		});
//		
//		//이제 감소버튼 만들기~~
//		JButton btn2 = new JButton("감소");
//		btn2.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				number--;
//				lbl.setText(String.valueOf(number)); //int값을 안받아서 String으로 변환해줄 필요있음
//			}
//		});
		
		//★한개로 합치기!!
		JButton btn = new JButton("증가");
		JButton btn2 = new JButton("감소");
		ActionListener aListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn) { // e.getSource(); 이벤트가 발생된 참조를 오브젝트타입으로 알려줌
					number++;
				} else {
					number--;
				}
				//또는 이렇게도 가능
//				JButton btn = (JButton) e.getSource(); //downcating
//				if (btn.getText().equals("증가")) {
//					number++;
//				} else {
//					number--;
//				}
				
				lbl.setText(String.valueOf(number));
			}
		};
		btn.addActionListener(aListener);
		btn2.addActionListener(aListener);
		
		pnl.add(lbl);
		pnl.add(btn);
		pnl.add(btn2);
		
		add(pnl);
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyCounter2().setVisible(true);

	}

}
