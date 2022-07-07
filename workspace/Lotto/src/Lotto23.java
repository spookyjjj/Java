import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

public class Lotto23 extends JFrame {
	public Lotto2 lotto2;
	public Lotto3 lotto3;

	public Lotto23() {
		super("REAL LOTTO");
		lotto2 = new Lotto2();
		lotto3 = lotto2.getLt3();
		getContentPane().setLayout(null);

		if (Lotto_info.money < 1000) {
			Lotto2.falseBtns();
		}
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lotto2, lotto3);
		split.setBounds(0, 0, 994, 471);
		split.setDividerLocation(500);

		getContentPane().add(split);

		// lotto2의 돈벌러가기 버튼 액션 -> GetMoney로 연결
		lotto2.getMoneybtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GetMoney money = new GetMoney(Lotto23.this);
				money.setVisible(true);
				if (Lotto_info.money >= 1000) {
					Lotto2.trueBtns();
					Lotto2.btnSAuto.setEnabled(false);
					Lotto2.btnEnter.setEnabled(false);
				}
			}
		});

		// lotto3의 결과보기버튼 액션 -> Lotto4로 연결
		lotto3.getResultBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lotto4 lt4 = new Lotto4(Lotto23.this);
				lt4.winNbangLbl(lt4.allCheck(Lotto_info.allGame));
				lt4.allGameInBtn();
				lt4.winNbangSetText();
				lt4.setVisible(true); // 여기서 새 인스턴스로 Lotto4만들어야 작성한 allGame값 받아옴
				// lt4 꺼진후의 흐름 (oneGame allGame 초기화 하고 넘어옴)
				dispose();
				new Lotto23().setVisible(true);
			}
		});

		// 닫기 버튼 클릭 시 프로그램 전체 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int answer = JOptionPane.showConfirmDialog(Lotto23.this, "프로그램이 완전히 종료됩니다\n정말 종료하시겠습니까?", "confirm",
						JOptionPane.YES_NO_OPTION); // 프로그램 닫기 여부 확인
				if (answer == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		// 도움말 클릭시 도움창 뜨기(소(0705))
		lotto2.getHelplbl().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Help hlpDialog = new Help(Lotto23.this);
				hlpDialog.setVisible(true);
			}
		});

		setResizable(false);
		setSize(1000, 500);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
