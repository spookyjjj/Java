package Scratch;

import javax.swing.JLabel;

public class Lbl256 extends JLabel{
	public JLabel[] lbls = new JLabel[256];
	
	public Lbl256() {
		for (int i = 0; i < 256; i++) {
			JLabel lbl = new JLabel();
			lbl.setOpaque(true); // 해줘야 배경색 먹음
			lbls[i] = lbl;
		}
	}

}
