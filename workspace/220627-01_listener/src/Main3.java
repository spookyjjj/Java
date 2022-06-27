import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main3 extends JFrame {
	public Main3() {
		MouseMotionListener motion = new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("마우스가 움직입니다~." + e.getX() + "," + e.getY());
			}
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		};
		
		JPanel pnl = new JPanel();
		
		pnl.addMouseMotionListener(motion);
		
		add(pnl);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Main3().setVisible(true);

	}

}
