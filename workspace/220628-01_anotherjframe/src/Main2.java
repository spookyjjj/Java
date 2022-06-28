import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class ExitDialog extends JDialog {
	private boolean exit;
	
	public ExitDialog(JFrame owner) {
		super(owner, true);
		
		JPanel pnl = new JPanel();
		JButton btnYes = new JButton("종료");
		JButton btnNo = new JButton("취소");
		
		//1. 버튼 누르면 그걸 주요창으로 전달해서 주요창에서 스스로 종료/취소
//		ActionListener actionlistener = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				exit = (e.getSource() == btnYes);
//				dispose();
//			}
//		};
//		btnYes.addActionListener(actionlistener);
//		btnNo.addActionListener(actionlistener);
		//2. 버튼 누르면 부가창이 주요창 자체를 종료시키거나/취소시키거나
//		하는방법 알겠지?
		//3. JOptionPane의 만들어진 메소드 이용하기
//		주요창으로 가서 ㄱㄱ
		
		pnl.add(btnYes);
		pnl.add(btnNo);
		add(pnl);
		setSize(250, 250);
	}
	
	//1. 버튼 누르면 그걸 주요창으로 전달해서 주요창에서 스스로 종료/취소
	public boolean showDialog() {
		setVisible(true);
		return exit;
	}
}

public class Main2 extends JFrame{
	public Main2() {
		
		setSize(500, 500);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //행동은 아무것도 안일어 나지만, 닫기버튼을 눌렀다는 이벤트는 있다!
		
//		addWindowListener(new WindowListener() {
//			@Override
//			public void windowOpened(WindowEvent e) { //창이 열렸을 때
//				// TODO Auto-generated method stub
//			}
//			@Override
//			public void windowIconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//			}
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//			}
//			@Override
//			public void windowDeactivated(WindowEvent e) { //윈도우 비활정화(포커스off)
//				// TODO Auto-generated method stub
//			}
//			@Override
//			public void windowClosing(WindowEvent e) { //닫으려고 할 때
//				// TODO Auto-generated method stub
//			}
//			@Override
//			public void windowClosed(WindowEvent e) { //닫혔을 때
//				// TODO Auto-generated method stub
//			}
//			@Override
//			public void windowActivated(WindowEvent e) { //윈도우 활성화(포커스on)
//				// TODO Auto-generated method stub
//			}
//		});
		addWindowListener(new WindowAdapter() { //얘도 Adapter가 있다~!
			@Override
			public void windowClosing(WindowEvent e) { //닫으려고 할 때
				//1. 버튼 누르면 그걸 주요창으로 전달해서 주요창에서 스스로 종료/취소
//				System.out.println("닫으려고 함???");
//				ExitDialog dialog = new ExitDialog(Main2.this);
//				boolean result = dialog.showDialog();
//				if (result) {
//					setDefaultCloseOperation(EXIT_ON_CLOSE);
//				}
				
				//3. JOptionPane의 만들어진 메소드 이용하기
				int result = JOptionPane.showConfirmDialog(Main2.this, "종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
				//JOptionPane.showConfirmDialog(주요창, 메세지, 제목, 리턴받을것) //JOptionPane.YES_NO_OPTION은 yes/no/cancle같은거 뭐눌렀는지 int로 반환
				JOptionPane.showInputDialog(Main2.this, "입력창");
				//요거는 걍 showInputDialog하나 생성
				if (result == JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
			}
		});
			
	}
	public static void main(String[] args) {
		new Main2().setVisible(true);

	}

}
