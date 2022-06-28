import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class SubWindow extends JDialog { //Frame이랑 유사하지만 부가창 전용~ 최소화버튼 최대화버튼이 없다
	private JTextField tf = new JTextField(10);
	
	public SubWindow(JFrame owner) {
		super(owner); //★super(frame이름(주요창));라는 JDialog의 생성자 사용가능
//		getOwner(); //super에서 주요창 전달받았으면 이런 메소드도 사용가능한점이 좋다~
		setModal(true); //★부가창이 켜져있는 동안에는 다른창과는 상호작용 할 수 없게끔 막아둠 -> ★super(frame이름(주요창), 모달값t/f);라는 JDialog의 생성자로도 가능
		setTitle("부가 창"); //JDialog는 super로 제목 받는게 아니라 setTitle로 ㄱㄱ
		
		add(tf,"North");
		
		JButton btn = new JButton("다른 버튼");
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); 
			}
		});
		
		setSize(500, 500);
//		setDefaultCloseOperation(EXIT_ON_CLOSE); //JFrame일때는 부가 창에도 이걸 걸어놓으면 부가 창 닫히면 전부 닫힘 + JDialog일때는 부가창일 할 일이 아니다~ 해서 컴파일에러
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //이걸로 해 놓으면 해당 창만 사라짐
		//사실 x눌렀을때의 기본값이 dispose이므로 설정안해줘도 ok~
		//setVisible(False)와 dispose()는 유사
	}
	
	public String showDialog() {
		setVisible(true);
		return tf.getText();
	}
}

public class Main extends JFrame {
	public Main() {
		super("주요 창");
		
		JButton btn = new JButton("버튼");
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SubWindow dialog = new SubWindow(Main.this); //this.라고 하면 ActionListener도 클래스라서 지라고 생각함. 그래서 Main클래스라고 딱 찝은것!
				String result = dialog.showDialog(); //이 메소드 안에 setVisible(true)있으니 흐름 멈춤!
				//
				//(★Modal이 true인) SubWindow창이 열리면 흐름이 멈추고, 닫아야지 다시 아래로 흘러감
				//그래서 SubWindow에서 얻은 값 전달받기가 쉽다!!
				//
				System.out.println("이 문장은 언제 호출됨?");
				btn.setText(result);
			}
		});
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main().setVisible(true);
	}

}
