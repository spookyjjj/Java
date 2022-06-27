import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main2 extends JFrame{
	public Main2() {
		JPanel pnl = new JPanel();
		JButton btn = new JButton("버튼입니다");
		//클릭에 대한 이벤트 만들고 싶을때 방법 2가지
		//1번
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("액션이벤트 발생");
			}
		});
		//2번
//		btn.addMouseListener(new MouseListener() { //but,,얘를 쓰면 오버라이드 5번 해야함 안 쓸 메소드 공란으로 둔다 하더라도 공간차지!
//			@Override
//			mouseReleased, mousePressed, mouseExited, mouseEntered, mouseClicked
//			}
//		});
		btn.addMouseListener(new MouseAdapter() { //그때 MouseAdapter 얘를 쓰면됨 정의하고싶은 애만 override가능~~
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("마우스 Pressed");
			}
			
		});
		
		pnl.add(btn);
		add(pnl);
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main2().setVisible(true);

	}

}
