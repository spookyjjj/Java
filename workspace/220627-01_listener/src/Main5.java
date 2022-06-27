import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main5 extends JFrame {
	public Main5() {
		JPanel pnl = new JPanel();
		Toolkit kit = Toolkit.getDefaultToolkit(); //툴킷을 이용하면 이미지를 가져오기가 쉬워짐~
		
//		Image img1 = kit.getImage("춘식3.png"); //이미지를 반환하는 메소드~~(project안에 위치할 때)<-자바프로젝트 기준
//		Image img2 = kit.getImage("춘식10.png"); //상대경로라서,,배포하면 파일 위치 못 찾는다 -> 해결법:절대경로!
		
		URL url1 = Main5.class.getClassLoader().getResource("images/춘식3.png"); //★url로 반환하는 메소드~~ (src파일 안에 위치할 때)<-src폴더 기준
		URL url2 = Main5.class.getClassLoader().getResource("images/춘식10.png"); //url은 배포파일만들어도 경로 잘 찾아감!
		Image img1 = kit.getImage(url1);
		Image img2 = kit.getImage(url2);
		
		
		JLabel lbl = new JLabel(new ImageIcon(img2)); //이미지를 또 아이콘으로 바꿔줘야함
		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lbl.setIcon(new ImageIcon(img1));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lbl.setIcon(new ImageIcon(img2));
			}
		});
		pnl.add(lbl);
		add(pnl);
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main5().setVisible(true);

	}

}
