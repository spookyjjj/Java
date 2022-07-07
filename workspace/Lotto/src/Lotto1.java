import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Lotto1 extends JFrame {

	public Lotto1() {
		super("REAL LOTTO");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(" ");

		lblNewLabel.setBounds(122, 179, 268, 149);
		getContentPane().add(lblNewLabel);

		Toolkit kit = Toolkit.getDefaultToolkit();
		URL url = Lotto1.class.getClassLoader().getResource("로또시작.jpg");
		ImageIcon img = new ImageIcon(kit.getImage(url));
		JLabel lbl = new JLabel(img);

		lbl.setBounds(0, 0, 484, 461);
		lbl.setBounds(0, 0, 484, 461);
		getContentPane().add(lbl);

		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Lotto23().setVisible(true);
			}
		});

		setSize(500, 500);
		setLocationRelativeTo(null); // 애는 size설정 후에 null로 만들어줘야 중앙에 위치. null만든후 size주면 그만큼 밀림
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Lotto1().setVisible(true);
	}
}
