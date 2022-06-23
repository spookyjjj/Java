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
		
		JLabel qBox = new JLabel(makeQ.qPrint()); //위에층
		
		JTextField a = new JTextField(15); //밑에층-1
		JButton button = new JButton("확인"); //밑에층-2
		
		JPanel aBox = new JPanel(); //밑에층 (밑에층-1, 밑에층-2) 
		aBox.add(a);
		aBox.add(button);
		
		JLabel cBox = new JLabel("연속 성공 점수: " + makeQ.getCount());
		
		JPanel box = new JPanel(); //전체박스 (qbox, abox, cbox) -> 세로배열
		BoxLayout yy = new BoxLayout(box, BoxLayout.Y_AXIS);
		box.setLayout(yy);
		box.add(qBox);
		box.add(aBox);
		box.add(cBox);
		
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
		
		add(box);
		setSize(300, 130);
		setLocationRelativeTo(null); //윈도우 가운데 정렬
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		T0623 m = new T0623();
		m.setVisible(true);
	}

}
