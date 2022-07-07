
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chunsik extends JDialog {
	int num1;
	int num2;
	int result = 0; // 깐 춘식이가 3개니?
	int chunCount = 0; // 춘식이 몇번깠니?
	ImageIcon icon;
	private JLabel[] lbl;

	Toolkit kit1 = Toolkit.getDefaultToolkit();
	URL url1 = Lotto1.class.getClassLoader().getResource("춘식17.png");
	ImageIcon img1 = new ImageIcon(kit1.getImage(url1));

	Toolkit kit2 = Toolkit.getDefaultToolkit();
	URL url2 = Lotto1.class.getClassLoader().getResource("춘식18.png");
	ImageIcon img2 = new ImageIcon(kit2.getImage(url2));

	Toolkit kit3 = Toolkit.getDefaultToolkit();
	URL url3 = Lotto1.class.getClassLoader().getResource("춘식19.png");
	ImageIcon img3 = new ImageIcon(kit3.getImage(url3));

	Map<Integer, ImageIcon> pic1 = new HashMap<>();
	Map<Integer, ImageIcon> pic2 = new HashMap<>();
	private JLabel toplbl1, toplbl2, toplbl3, toplbl4, toplbl5;

	public void runChunsick(JLabel l) { // 춘식이 까는 메소드 ! JLabel을 파라미터로 불러옴

		l.addMouseListener(new MouseAdapter() { // 우측 춘식이들
			int count = 0;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (num1 == 1 || num1 == 2 || num1 == 3) {
					if (count == 0) {
						chunCount++;
						pic2.put(1, img1);
						pic2.put(2, img2);
						pic2.put(3, img3);
						Random random = new Random();
						num2 = random.nextInt(3) + 1;
						count++;
						icon = pic2.get(num2);
						l.setIcon(icon);

						if (num1 == num2) {
							result++;
						}

					}

					resultCheck();

				} else {
					JOptionPane.showMessageDialog(Chunsik.this, "오늘의 춘식이를 확인해주세요");
				}
			}
		});
	}

	public void resultCheck() {
		if (chunCount == 5 && result == 3) {
			JOptionPane.showMessageDialog(Chunsik.this, "축 ★ 당첨 ★\n3000원이 충전됩니다");
			Lotto_info.money += 3000;
			dispose();
		} else if (chunCount == 5 && result != 3) {
			JOptionPane.showMessageDialog(Chunsik.this, "깡 ~\n다음기회에..");
			dispose();
		}
	}

	public Chunsik(JDialog owner) {
		setModal(true);
		setTitle("춘식이 찾기");
		setSize(400, 284);

		JPanel pnl = new JPanel(); // 큰패널
		getContentPane().add(pnl);
		pnl.setLayout(null);

		JPanel lftPnl = new JPanel();
		lftPnl.setBackground(new Color(250, 250, 210));
		lftPnl.setBounds(12, 10, 141, 222);
		pnl.add(lftPnl);
		lftPnl.setLayout(null);
		JLabel lftlbl = new JLabel("오늘의 춘식");
		lftlbl.setFont(new Font("휴먼엑스포", Font.PLAIN, 14));
		lftlbl.setBounds(30, 153, 83, 38);
		lftPnl.add(lftlbl);

		JLabel lftlbl2 = new JLabel("  Click ");
		lftlbl2.setFont(new Font("휴먼엑스포", Font.PLAIN, 16));
		lftlbl2.setBounds(36, 53, 65, 65);
		lftPnl.add(lftlbl2);

		JPanel topPnl = new JPanel();
		topPnl.setBackground(new Color(250, 250, 210));
		topPnl.setBounds(165, 10, 207, 222);
		pnl.add(topPnl);
		topPnl.setLayout(null);

		toplbl1 = new JLabel("     1");
		toplbl1.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		toplbl1.setBounds(44, 47, 55, 55);
		topPnl.add(toplbl1);

		toplbl2 = new JLabel("    2");
		toplbl2.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		toplbl2.setBounds(111, 47, 55, 55);
		topPnl.add(toplbl2);

		toplbl3 = new JLabel("     3");
		toplbl3.setBounds(22, 112, 55, 55);
		toplbl3.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		topPnl.add(toplbl3);

		toplbl4 = new JLabel("    4");
		toplbl4.setBounds(79, 112, 55, 55);
		toplbl4.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		topPnl.add(toplbl4);

		toplbl5 = new JLabel("    5");
		toplbl5.setBounds(140, 112, 55, 55);
		toplbl5.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		topPnl.add(toplbl5);

		JLabel lblNewLabel = new JLabel("오늘의 춘식이가 3개 나오면 당첨!");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel.setBounds(22, 174, 201, 38);
		topPnl.add(lblNewLabel);

		lftlbl2.addMouseListener(new MouseAdapter() { // 오늘의 춘식
			int count = 0;

			@Override
			public void mouseClicked(MouseEvent e) {

				if (count == 0) {
					pic1.put(1, img1);
					pic1.put(2, img2);
					pic1.put(3, img3);
					Random random = new Random();
					num1 = random.nextInt(3) + 1;
					count++;
					ImageIcon icon = pic1.get(num1);
					lftlbl2.setIcon(icon);
				}
			}
		});

		runChunsick(toplbl1);
		runChunsick(toplbl2);
		runChunsick(toplbl3);
		runChunsick(toplbl4);
		runChunsick(toplbl5);

		setLocationRelativeTo(owner);
	}

	public static void main(String[] args) {
//		new Chunsik().setVisible(true);
	}
}
