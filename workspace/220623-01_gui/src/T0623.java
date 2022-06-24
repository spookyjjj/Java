import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
class MakeQ {
	int a;
	int b;
	int answer;
	int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void run() {
		Random random = new Random();
		a = random.nextInt(100) + 1;
		b = random.nextInt(100) + 1;
		answer = a + b;
	}
	
	public String qPrint() {
		return a + " + " + b;
	}
	public String aPrint() {
		return String.valueOf(a + b);
	}
}

public class T0623 extends JFrame {
	public T0623() {
		super("수학문제풀기"); //프로그램 제목
		
		MakeQ makeQ = new MakeQ(); 
		makeQ.run(); //문제생성
		
		JTextField a = new JTextField(15); //밑에층-1
		a.setForeground(Color.DARK_GRAY);
		JButton button = new JButton("확인"); //밑에층-2
		
		JPanel aBox = new JPanel(); //밑에층 (밑에층-1, 밑에층-2) 
		aBox.add(a);
		aBox.add(button);
		
		JPanel box = new JPanel(); //전체박스 (qbox, abox, cbox) -> 세로배열
		BoxLayout yy = new BoxLayout(box, BoxLayout.Y_AXIS);
		box.setLayout(yy);
		
		JPanel panel = new JPanel();
		box.add(panel);
		
		JLabel qBox = new JLabel(makeQ.qPrint());
		panel.add(qBox);
		qBox.setAlignmentY(Component.TOP_ALIGNMENT);
		qBox.setHorizontalTextPosition(SwingConstants.CENTER);
		qBox.setVerifyInputWhenFocusTarget(false);
		qBox.setHorizontalAlignment(SwingConstants.CENTER);
		qBox.setFont(new Font("Engravers MT", Font.PLAIN, 30));
		box.add(aBox);
		
		
		getContentPane().add(box);
		
		JPanel panel_1 = new JPanel();
		box.add(panel_1);
		
		JLabel cBox = new JLabel("연속 성공 점수: " + makeQ.getCount());
		cBox.setFont(new Font("궁서체", Font.PLAIN, 20));
		panel_1.add(cBox);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (a.getText().equals(makeQ.aPrint())) {
					JOptionPane.showMessageDialog(T0623.this, "맞았습니다!");
					makeQ.setCount(makeQ.getCount() + 1); //점수 1점더하고
					cBox.setText("연속 성공 점수: " + makeQ.getCount()); //점수출력
					makeQ.run(); //문제생성기 다시돌려서
					qBox.setText(makeQ.qPrint()); //문제출력
					a.setText(""); //입력창 비우기
				} else {
					JOptionPane.showMessageDialog(T0623.this, "틀렸는디요;");
					makeQ.setCount(0);
					cBox.setText("연속 성공 점수: " + makeQ.getCount());
					a.setText(""); //입력창 비우기
				}
			}
		});
		setSize(329, 150);
		setLocationRelativeTo(null); //윈도우 가운데 정렬
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		T0623 m = new T0623();
		m.setVisible(true);
	}

}
