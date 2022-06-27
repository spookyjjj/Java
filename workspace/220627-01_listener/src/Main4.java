import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main4 extends JFrame{
	public Main4() {
		JPanel pnl = new JPanel(null);
		pnl.setPreferredSize(new Dimension(500, 500));
		
		JButton btn = new JButton("Click me");
		btn.setBounds(150, 150, 100, 100);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setLocation((int) (Math.random() * 400), (int) (Math.random() * 400));
			}
		});
		
		pnl.add(btn);
		add(pnl);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); //프레임크기 고정
	}
	public static void main(String[] args) {
		new Main4().setVisible(true);

	}

}
