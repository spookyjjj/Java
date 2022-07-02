package Scratch;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Scratch extends JFrame {
	public static int revealNum = 0;
	private List<JPanel> list = new LinkedList<>();
//	private Map<Integer, JPanel> map = new HashMap<>();

	private Yosi makeYosi() {
		Yosi y = new Yosi();
		list.add(y);
		return y;
	}

	private Egg makeEgg() {
		Egg e = new Egg();
		list.add(e);
		return e;
	} 

	private int random() {
		Random random = new Random();
		return (random.nextInt(2) + 1);
	}

	public Scratch() {
//		Yosi yosi1 = new Yosi();
//		Yosi yosi2 = new Yosi();
//		Egg egg = new Egg();
//		map.put(1,  yosi);
//		map.put(2, egg);

		setSize(700, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lbl = new JLabel("긁는복권");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbl, BorderLayout.NORTH);

		JButton btn = new JButton("결과바로보기");
		getContentPane().add(btn, BorderLayout.SOUTH);

		JPanel center = new JPanel();
		getContentPane().add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout());
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			int num = random();
			set.add(num);
			if (num == 1) {
				center.add(makeYosi());
			} else {
				center.add(makeEgg());
			}
		}
		
		//결과보기 버튼
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JPanel pnl : list) {
//					pnl.reveal(); //->JPanel업캐스팅을 하면 Yosi와 Egg에 있는 reveal을 못찾음
					if (pnl instanceof Yosi) {
						((Yosi)pnl).reveal();
					} else {
						((Egg)pnl).reveal();
					}
				}
			}
		});
		
		//다까발려지면 결과보기
		center.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (revealNum >= 3) {
					if (set.size() == 1) {
						JOptionPane.showMessageDialog(Scratch.this, "축 당 첨\n3000원이 충전됩니다");
					} else {
						JOptionPane.showMessageDialog(Scratch.this, "꽝\n다음기회에..");
					}
					dispose();
				}
			}
		});
//        center.add(yosi1);
//        center.add(yosi2);
//        center.add(egg);
//        center.add(map.get(1));
//        center.add(map.get(1));
//        center.add(map.get(1));

	}

	public static void main(String[] args) {
		new Scratch().setVisible(true);
	}
}
