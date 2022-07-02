package Scratch;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Egg extends JPanel {
	private JLabel[] lbls = new JLabel[256];
	private List<JLabel> black = new LinkedList<>(); 
	private List<JLabel> darkGreen = new LinkedList<>(); 
	private List<JLabel> lightGreen = new LinkedList<>(); 
	private int count = 0;
	private boolean revealState = false; // for revealNum 1회만 더해주기 위해서

	// 좌표를 lbls[]로 옮겨주는 메소드
	private JLabel p(int x, int y) {
		int index = ((x - 1) * 16) + (y - 1);
		return lbls[index];
	}

	// 전부 다까는 메소드
	public void reveal() {
		for (JLabel lbl : black) {
			lbl.setBackground(new Color(0, 0, 0));
		}
		for (JLabel lbl : darkGreen) {
			lbl.setBackground(new Color(0, 176, 80));
		}
		for (JLabel lbl : lightGreen) {
			lbl.setBackground(new Color(146, 208, 60));
		}
		revealState = true;
		Scratch.revealNum++;
	}

	public Egg() {
//		JPanel pnl = new JPanel();
//		pnl.setLayout(new GridLayout(16, 16));
		setLayout(new GridLayout(16, 16));
		for (int i = 0; i < 256; i++) {
			JLabel lbl = new JLabel();
			lbl.setOpaque(true); // 해줘야 배경색 먹음
			lbls[i] = lbl;
			add(lbl); 
		}
		black.addAll(Arrays.asList( p(2, 7), p(2, 8), p(2, 9), p(2, 10), p(3, 5), p(3, 6), p(3, 11), p(3, 12),
			p(4, 4), p(4, 13), p(5, 3), p(5, 14), p(6, 3), p(6, 14), p(7, 2), p(7, 15), p(8, 2), p(8, 15), p(9, 2),
			p(9, 15), p(10, 2), p(10, 15), p(11, 2), p(11, 15), p(12, 3), p(12, 14), p(13, 3), p(13, 14), p(14, 4),
			p(14, 5), p(14, 12), p(14, 13), p(15, 6), p(15, 7), p(15, 8), p(15, 9), p(15, 10), p(15, 11) )); 
		darkGreen.addAll(Arrays.asList( p(4, 5), p(4, 9), p(5, 4), p(5, 9), p(5, 10), p(7, 6), p(8, 5), p(8, 6), p(8, 7), p(8, 13), p(9,6), p(9,7), p(9, 12), p(9, 13), p(11, 3), p(11, 10),
			p(11, 11), p(11, 12), p(12, 8), p(12, 9), p(12, 10), p(12, 11), p(12, 12), p(12, 13), p(13, 8), p(13, 9),
			p(13, 7), p(13, 10), p(13, 11), p(13, 12), p(14, 9), p(14, 10), p(14, 11) ));
		lightGreen.addAll(Arrays.asList( p(3, 8), p(3, 9), p(3, 10), p(4, 6), p(4, 10), p(4, 11), p(5, 5), p(5, 6),
			p(6, 4), p(6, 5), p(7, 11), p(7, 12), p(8, 11), p(8, 12), p(10, 5), p(10, 6), p(10, 9), p(10,10), p(11, 5), p(11, 6),p(11, 8), p(11, 9),
			p(14, 6) ));

		MouseListener turnBlackLister = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((JLabel) e.getSource()).setBackground(new Color(0, 0, 0));
				count++;
				if (count >= (256 * 0.4) && !revealState) {
					reveal();
				}
			}
		};
		MouseListener turnDarkGreenLister = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((JLabel) e.getSource()).setBackground(new Color(0, 176, 80));
				count++;
				if (count >= (256 * 0.4) && !revealState) {
					reveal();
				}
			}
		};
		MouseListener turnLightGreenLister = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((JLabel) e.getSource()).setBackground(new Color(146, 208, 60));
				count++;
				if (count >= (256 * 0.4) && !revealState) {
					reveal();
				}
			}
		};
		for (int i = 0; i < 256; i++) {
			for (JLabel lbl : black) {
				if (lbls[i].equals(lbl)) {
					lbls[i].addMouseListener(turnBlackLister);
				}
			}
			for (JLabel lbl : darkGreen) {
				if (lbls[i].equals(lbl)) {
					lbls[i].addMouseListener(turnDarkGreenLister);
				}
			}
			for (JLabel lbl : lightGreen) {
				if (lbls[i].equals(lbl)) {
					lbls[i].addMouseListener(turnLightGreenLister);
				}
			}
		}

		JLabel result = p(16, 16);
		result.setText("X");
		result.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				reveal();
			}
		});
//		add(pnl);
		setSize(500, 500);
	}

	public static void main(String[] args) {
		new Egg().setVisible(true);

	}

}
