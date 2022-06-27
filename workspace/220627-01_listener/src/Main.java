import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
	public Main() {
		MouseListener listener = new MouseListener() { //애는 추상메소드가 5개라서 오버라이드도 5개 필요
			@Override
			public void mouseReleased(MouseEvent e) { //클릭일 때는 주로 이거
				System.out.println("마우스 버튼을 땜");
			}
			@Override
			public void mousePressed(MouseEvent e) { //아니면 이걸로 이벤트 준다
				System.out.println("마우스 버튼을 누름");
			}
			@Override
			public void mouseExited(MouseEvent e) { //마우스가 영역에 hover됨/안됨을 구분함
				System.out.println("Exit!!");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Enter!!");
			}
			@Override
			public void mouseClicked(MouseEvent e) { //★이거는 더블클릭일 때 or 우클릭 좌클릭 구분하고 싶을 때 주로 사용한다
				if (e.getClickCount() == 2) {
					System.out.println("더블클릭");
				}
				
				System.out.println(e.getButton()); //우클릭 좌클릭 휠클릭은 os마다 다르다!! 출력 함 해본후에 그걸로 조건 걸거나
				switch (e.getButton()) {
				case 1: System.out.println("1번"); break;
				case 2: System.out.println("2번"); break;
				case 3: System.out.println("3번"); break;
				}
				
				System.out.println("좌클릭인가요? " + SwingUtilities.isLeftMouseButton(e)); //이런 메소드 써서 t/f값으로 알아낸 후에 조건 걸기
				System.out.println("우클릭인가요? " + SwingUtilities.isRightMouseButton(e)); 
				System.out.println("휠클릭인가요? " + SwingUtilities.isMiddleMouseButton(e)); 
			}
		};
		
		JPanel pnl = new JPanel();
		
		pnl.addMouseListener(listener);
		
		add(pnl);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Main().setVisible(true);

	}

}
