//1. 비밀번호 확인,일치
//2. 이미 등록아이디 -> X
//3. 아이디와 비밀번호 입력 길이 4자이상 12자 이하
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class T0627 extends JFrame {
	private Map<String, String> info = new HashMap<>();
	Set keyset = info.keySet();
	
	private boolean findId(String s) {
		return keyset.contains(s);
	}
	
	public T0627() {
		CardLayout cardLayout = new CardLayout(); //카드레이아웃은 next, previous, 키워드로 전환하기 등이 가능
		JPanel center = new JPanel(cardLayout);
		JPanel pnl1 = new JPanel(); //로그인창
		JPanel pnl2 = new JPanel(); //로그인성공or실패창
		JPanel pnl3 = new JPanel(); //회원가입창
		
		//pnl1
		JTextField tf = new JTextField("아이디 입력", 10);
		JPasswordField pf = new JPasswordField("비밀번호 입력", 10); 
		JPanel pnlLeft = new JPanel();
		pnlLeft.setLayout(new BoxLayout(pnlLeft, BoxLayout.Y_AXIS));
		pnlLeft.add(tf);
		pnlLeft.add(pf);
		JButton btn1 = new JButton("로그인");
		JButton btn2 = new JButton("회원가입");
		JPanel pnlRight = new JPanel();
		pnlRight.setLayout(new BoxLayout(pnlRight, BoxLayout.Y_AXIS));
		pnlRight.add(btn1);
		pnlRight.add(btn2);
		pnl1.add(pnlLeft);
		pnl1.add(pnlRight);
		
		//pnl2
		JLabel lbl = new JLabel();
		JButton btn3 = new JButton("돌아가기");
		pnl2.add(lbl);
		pnl2.add(btn3);
		
		//pnl3
		JTextField new_tf = new JTextField(10);
		JPasswordField new_pf = new JPasswordField(10); 
		JPasswordField new_pf_chck = new JPasswordField(10); 
		JButton btn4 = new JButton("가입");
		pnl3.setLayout(new BoxLayout(pnl3, BoxLayout.Y_AXIS));
		pnl3.add(new JLabel("아이디"));
		pnl3.add(new_tf);
		pnl3.add(new JLabel("비밀번호"));
		pnl3.add(new_pf);
		pnl3.add(new JLabel("비밀번호 확인"));
		pnl3.add(new_pf_chck);
		pnl3.add(btn4);
		
		center.add(pnl1, "login");
		center.add(pnl2, "pf");
		center.add(pnl3, "signup");
		add(center);
		
		//cardlayout 버튼으로 전환하기
		btn1.addActionListener(new ActionListener() { //로그인창-로그인버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				Toolkit kit = Toolkit.getDefaultToolkit();
//				info.put("qwer", "1234");
				if (findId(tf.getText()) && pf.getText().equals(info.get(tf.getText()))) {
					lbl.setText("로그인 성공!!!!!!");
					URL url = T0627.class.getClassLoader().getResource("춘식9.png");
					pnl2.add(new JLabel(new ImageIcon(kit.getImage(url))));
				} else {
					lbl.setText("로그인 실패!!!!!!");
					URL url = T0627.class.getClassLoader().getResource("춘식13.png");
					pnl2.add(new JLabel(new ImageIcon(kit.getImage(url))));
				}
				tf.setText("아이디 입력");
				pf.setText("비밀번호 입력");
				cardLayout.show(center, "pf");
			}
		});
		btn2.addActionListener(new ActionListener() { //로그인창-회원가입버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(center, "signup");
			}
		});
		btn3.addActionListener(new ActionListener() { //확인창-돌아가기버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(center, "login");
			}
		});
		btn4.addActionListener(new ActionListener() { //회원가입-가입버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!new_pf.getText().equals(new_pf_chck.getText())) {
					JOptionPane.showMessageDialog(center, "비밀번호와 비밀번호 확인의 입력이 다릅니다");
				} else if (findId(new_tf.getText())) {
					JOptionPane.showMessageDialog(center, "이미 있는 아이디 입니다");
				} else {
					info.put(new_tf.getText(), new_pf.getText());
					new_tf.setText("");
					new_pf.setText("");
					new_pf_chck.setText("");
					JOptionPane.showMessageDialog(center, "가입성공!");
					cardLayout.show(center, "login");
				}
			}
		});
		new_tf.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!(new_tf.getText().length() >= 4 && new_tf.getText().length() <= 12)) {
					JOptionPane.showMessageDialog(center, "아이디는 4글자 이상 12글자 이하여야 합니다");
					new_tf.grabFocus();
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		new_pf.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!(new_pf.getText().length() >= 4 && new_pf.getText().length() <= 12)) {
					JOptionPane.showMessageDialog(center, "비밀번호는 4글자 이상 12글자 이하여야 합니다");
					new_pf.grabFocus();
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		//로그인창 필드 채우기
		tf.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (tf.getText().equals("")) {
					tf.setText("아이디 입력");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (tf.getText().equals("아이디 입력")) {
					tf.setText("");
				}
			}
		});
		pf.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (pf.getText().equals("")) {
					pf.setText("비밀번호 입력");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (pf.getText().equals("비밀번호 입력")) {
					pf.setText("");
				}
			}
		});
		center.setFocusable(true); //★패널에다가는 포커스 안가는데 가게끔 설정 바꿈
		center.requestFocusInWindow(); //★바꾼 그 패널에 포커스 가게~!!! -> 이러면 창 켰을 때 텍스트필드에 포커스 가있지 않다!! 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
	}
	public static void main(String[] args) {
		new T0627().setVisible(true);

	}

}
