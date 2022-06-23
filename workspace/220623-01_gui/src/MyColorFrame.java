import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//★★ActionListener는 인터페이스~
class MyActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		//클릭을 했을 때 일어날 동작들 작성
		System.out.println("사용자가 버튼을 클릭했네요~"); //이렇게 하면 콘솔창에 나옴!
	}
}

public class MyColorFrame extends JFrame {
	public MyColorFrame() {
		super("색깔 있는 프레임");
		
		JPanel pnl = new JPanel(); //하나의 빈 판때기 -> ★기본적으로 FlowLayout이기 때문에 따로 설정할 필요 없음
		pnl.setBackground(Color.RED);
		
		JButton btn = new JButton("컨테이너 안의 버튼");
		
		MyActionListener listener = new MyActionListener(); //MyActionListener의 객체를 생성해서
		btn.addActionListener(listener); //addActionListener의 참조로 넘겨줌
		
		//익명클래스로도 바로 만들 수 있다!!
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("익명클래스 구현");
				pnl.setBackground(Color.BLUE);
			}
		});
		
		pnl.add(btn);
		
		add(pnl);
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MyColorFrame f = new MyColorFrame();
		f.setVisible(true);

	}

}
