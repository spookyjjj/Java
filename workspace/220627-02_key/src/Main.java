import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {
	private int x;
	private int y;
	
	public Main() {
		
		JPanel pnl = new JPanel();
		JLabel lbl = new JLabel("입력");
		x = 100;
		y = 100;
		lbl.setBounds(x, y, 50, 50);
		
		pnl.add(lbl);
		
		add(pnl);
		
		pnl.setFocusable(true); //키 이벤트는 포커스가 위치해 있어야 키 이벤트 발생! 컴포넌트가 여러개 있을 때, 우선적으로 입력받기 위해 설정~~
//		pnl.addKeyListener(new KeyListener() {
//			@Override
//			public void keyTyped(KeyEvent e) { //타이핑이 온전히 한번 되었을 때
//			}
//			@Override
//			public void keyReleased(KeyEvent e) { //키보드 버튼 뗄 때
//			}
//			@Override
//			public void keyPressed(KeyEvent e) { //키보드 버튼을 눌렀을 때
//			}
//		});
		pnl.addKeyListener(new KeyAdapter() { //얘도 마찬가지고 KeyAdapter()클래스 쓰면 하나씩만 사용가능
			@Override
			public void keyPressed(KeyEvent e) {
//				char c = e.getKeyChar(); //tab, space, shift, 방향키등은 문자가 아니라서 인식을 못함 -> ★code로ㄱㄱ
//				lbl.setText(String.valueOf(c));
				
				int code = e.getKeyCode();
				if (code == KeyEvent.VK_LEFT) { //37인데,, final상수로 정해져있음 버츄얼키보드
					x -= 5;
				} else if (code == KeyEvent.VK_RIGHT) {
					x += 5;
				} else if (code == KeyEvent.VK_UP) {
					y -= 5;
				} else if (code == KeyEvent.VK_DOWN) {
					y += 5;
				}
				lbl.setLocation(x, y);
			}
		});
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main().setVisible(true);
	}

}
