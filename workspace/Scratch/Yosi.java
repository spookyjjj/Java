package Scratch;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Yosi extends JPanel {
//	private JLabel[] lbls = new JLabel[256];
	private Lbl256 yosi = new Lbl256(); //<-★얘는 lbl 256개 생성해서 담아놓은 JLabel[] lbls가 필드로 있음
	private int count = 0;
	private boolean revealState = false; //for revealNum 1회만 더해주기 위해서
	private JLabel[] black = new JLabel[] { p(1, 6), p(1, 7), p(1, 10), p(1, 11), p(2, 5), p(2, 8), p(2, 9), p(2, 12),
			p(3, 4), p(3, 13), p(4, 4), p(4, 7), p(4, 10), p(4, 13), p(5, 4), p(5, 7), p(5, 10), p(5, 13), p(6, 3),
			p(6, 4), p(6, 6), p(6, 7), p(6, 8), p(6, 9), p(6, 10), p(6, 11), p(6, 13), p(6, 14), p(7, 2), p(7, 5),
			p(7, 12), p(7, 15), p(8, 1), p(8, 4), p(8, 13), p(8, 16), p(9, 1), p(9, 3), p(9, 7), p(9, 10), p(9, 14),
			p(9, 16), p(10, 1), p(10, 3), p(10, 14), p(10, 16), p(11, 1), p(11, 3), p(11, 14), p(11, 16), p(12, 1),
			p(12, 3), p(12, 14), p(12, 16), p(13, 1), p(13, 2), p(13, 3), p(13, 14), p(13, 15), p(13, 16), p(14, 2),
			p(14, 4), p(14, 13), p(14, 15), p(15, 3), p(15, 4), p(15, 5), p(15, 12), p(15, 13), p(15, 14), p(16, 5),
			p(16, 6), p(16, 7), p(16, 8), p(16, 9), p(16, 10), p(16, 11), p(16, 12) };
	private JLabel[] red = new JLabel[] { p(14, 7), p(14, 8), p(14, 9), p(14, 10) };
	private JLabel[] green = new JLabel[] { p(2, 6), p(2, 7), p(2, 10), p(2, 11), p(3, 5), p(3, 8), p(3, 9), p(3, 12),
			p(7, 3), p(7, 4), p(7, 6), p(7, 7), p(7, 8), p(7, 9), p(7, 10), p(7, 11), p(7, 13), p(7, 14), p(8, 2),
			p(8, 3), p(8, 5), p(8, 6), p(8, 7), p(8, 8), p(8, 9), p(8, 10), p(8, 11), p(8, 12), p(8, 14), p(8, 15),
			p(9, 4), p(9, 5), p(9, 6), p(9, 8), p(9, 9), p(9, 11), p(9, 12), p(9, 13), p(10, 4), p(10, 5), p(10, 6),
			p(10, 7), p(10, 8), p(10, 9), p(10, 10), p(10, 11), p(10, 12), p(10, 13), p(11, 4), p(11, 5), p(11, 6),
			p(11, 7), p(11, 8), p(11, 9), p(11, 10), p(11, 11), p(11, 12), p(11, 13), p(12, 4), p(12, 5), p(12, 6),
			p(12, 7), p(12, 8), p(12, 9), p(12, 10), p(12, 11), p(12, 12), p(12, 13), p(13, 4), p(13, 5), p(13, 6),
			p(13, 7), p(13, 8), p(13, 9), p(13, 10), p(13, 11), p(13, 12), p(13, 13) };

	// 좌표를 lbls[]로 옮겨주는 메소드
	private JLabel p(int x, int y) {
//		1,1 -> 0
//		1,2 -> 1
//		1,3 -> 2
//		1,16 -> 15
//		2,1 -> 16
//		2,2 -> 17
//		2,16 -> 31
//		3,1 -> 32
		int index = ((x - 1) * 16) + (y - 1);
		return yosi.lbls[index];
	}
	
	// 전부 다까는 메소드 
	public void reveal() {
			for (int j = 0; j < black.length; j++) {
				black[j].setBackground(new Color(0, 0, 0));
			}
			for (int j = 0; j < red.length; j++) {
				red[j].setBackground(new Color(255, 0, 0));
			}
			for (int j = 0; j < green.length; j++) {
				green[j].setBackground(new Color(30, 120, 0));
			}
			revealState = true;
			Scratch.revealNum++;
	}
	
	public Yosi() {
//		JPanel pnl = new JPanel();
//		pnl.setLayout(new GridLayout(16, 16));
		setLayout(new GridLayout(16, 16));
		
//		for (int i = 0; i < 256; i++) {
//			JLabel lbl = new JLabel();
//			lbl.setOpaque(true); // 해줘야 배경색 먹음
//			add(lbl);
//			lbls[i] = lbl;
//		}
		for (int i = 0; i < 256; i++) {
			add(yosi.lbls[i]);
		}
		
		/*
		//얘네 왜 밖으로 빼면 null에러가 나지???
		JLabel[] black = new JLabel[] { p(1, 6), p(1, 7), p(1, 10), p(1, 11), p(2, 5), p(2, 8), p(2, 9), p(2, 12),
				p(3, 4), p(3, 13), p(4, 4), p(4, 7), p(4, 10), p(4, 13), p(5, 4), p(5, 7), p(5, 10), p(5, 13), p(6, 3),
				p(6, 4), p(6, 6), p(6, 7), p(6, 8), p(6, 9), p(6, 10), p(6, 11), p(6, 13), p(6, 14), p(7, 2), p(7, 5),
				p(7, 12), p(7, 15), p(8, 1), p(8, 4), p(8, 13), p(8, 16), p(9, 1), p(9, 3), p(9, 7), p(9, 10), p(9, 14),
				p(9, 16), p(10, 1), p(10, 3), p(10, 14), p(10, 16), p(11, 1), p(11, 3), p(11, 14), p(11, 16), p(12, 1),
				p(12, 3), p(12, 14), p(12, 16), p(13, 1), p(13, 2), p(13, 3), p(13, 14), p(13, 15), p(13, 16), p(14, 2),
				p(14, 4), p(14, 13), p(14, 15), p(15, 3), p(15, 4), p(15, 5), p(15, 12), p(15, 13), p(15, 14), p(16, 5),
				p(16, 6), p(16, 7), p(16, 8), p(16, 9), p(16, 10), p(16, 11), p(16, 12) };
		JLabel[] red = new JLabel[] { p(14, 7), p(14, 8), p(14, 9), p(14, 10) };
		JLabel[] green = new JLabel[] { p(2, 6), p(2, 7), p(2, 10), p(2, 11), p(3, 5), p(3, 8), p(3, 9), p(3, 12),
				p(7, 3), p(7, 4), p(7, 6), p(7, 7), p(7, 8), p(7, 9), p(7, 10), p(7, 11), p(7, 13), p(7, 14), p(8, 2),
				p(8, 3), p(8, 5), p(8, 6), p(8, 7), p(8, 8), p(8, 9), p(8, 10), p(8, 11), p(8, 12), p(8, 14), p(8, 15),
				p(9, 4), p(9, 5), p(9, 6), p(9, 8), p(9, 9), p(9, 11), p(9, 12), p(9, 13), p(10, 4), p(10, 5), p(10, 6),
				p(10, 7), p(10, 8), p(10, 9), p(10, 10), p(10, 11), p(10, 12), p(10, 13), p(11, 4), p(11, 5), p(11, 6),
				p(11, 7), p(11, 8), p(11, 9), p(11, 10), p(11, 11), p(11, 12), p(11, 13), p(12, 4), p(12, 5), p(12, 6),
				p(12, 7), p(12, 8), p(12, 9), p(12, 10), p(12, 11), p(12, 12), p(12, 13), p(13, 4), p(13, 5), p(13, 6),
				p(13, 7), p(13, 8), p(13, 9), p(13, 10), p(13, 11), p(13, 12), p(13, 13) };
		*/
		
		// 1안. 256전부에 리스터 붙여놓고 리스너 안에서 색깔별로 for문 돌린다?
//		MouseListener mouseListener = new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				for (int i = 0; i < lblsRedColored.length; i++) {
//					if (((JLabel) e.getSource()).equals(lblsRedColored[i])) {
//						((JLabel) e.getSource()).setBackground(new Color(45, 70, 45));
//					}
//				}
//			}
//		};
//		for (int i = 0; i < 256; i++) {
//			lbls[i].addMouseListener(mouseListener);
//		}

		// 2안. 빨간색 먹일 애들만 리스너 붙인다?
		MouseListener turnBlackLister = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((JLabel) e.getSource()).setBackground(new Color(0, 0, 0));
				count++;
				if (count >= (256 * 0.6) && !revealState) {
					reveal();
				}
			}
		};
		MouseListener turnRedLister = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((JLabel) e.getSource()).setBackground(new Color(255, 0, 0));
				count++;
				if (count >= (256 * 0.6) && !revealState) {
					reveal();
				}
			}
		};
		MouseListener turnGreenLister = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				((JLabel) e.getSource()).setBackground(new Color(30, 120, 0));
				count++;
				if (count >= (256 * 0.6) && !revealState) {
					reveal();
				}
			}
		};
		
		
		for (int i = 0; i < 256; i++) {
			for (int j = 0; j < black.length; j++) {
				if (yosi.lbls[i].equals(black[j])) {
					yosi.lbls[i].addMouseListener(turnBlackLister);
				}
			}
			for (int j = 0; j < red.length; j++) {
				if (yosi.lbls[i].equals(red[j])) {
					yosi.lbls[i].addMouseListener(turnRedLister);
				}
			}
			for (int j = 0; j < green.length; j++) {
				if (yosi.lbls[i].equals(green[j])) {
					yosi.lbls[i].addMouseListener(turnGreenLister);
				}
			}
		}
		
		JLabel result = p(16,16);
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
		new Yosi().setVisible(true);

	}

}
