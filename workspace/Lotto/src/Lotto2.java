
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

class Help extends JFrame { // JDialog였는데 dialog창이 기존창 뒤로 안숨어져서 JFrame으로 바꿈
	public Help(JFrame owner) {

		setTitle("도움말");

		Toolkit kit = Toolkit.getDefaultToolkit();
		URL url = Lotto2.class.getClassLoader().getResource("도움창.png");
		ImageIcon img = new ImageIcon(kit.getImage(url));
		JLabel helppic = new JLabel(img);
		add(helppic);

		setSize(996, 580);
		setLocationRelativeTo(owner);
		setAlwaysOnTop(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		toBack();
	}
}

public class Lotto2 extends JPanel {
	public static List<RoundedButton> btnlist = new ArrayList<>();
	public static RoundedButton[] regNums = new RoundedButton[6];
	public static boolean editState = false; // 수정 모드 하이라이트 됨 이거 만져서 3번창에서 수정 시도 시 수정없는 상태로도 바로 적용되게 설정 요청
	private static RoundedButton btnAuto; // 버튼 활성화 비활성화 static메소드 만들기 위해
	public static RoundedButton btnSAuto; // lotto3에서 사용을 위해 수정, private > public static
	public static RoundedButton btnEnter; // lotto3에서 수정, 구매취소 후 완료 시 구매버튼 비활성화를 위해 public으로 수정 7/6 대수
	private static JLabel moneyLbl; // 소지금 업데이트 하는 static메소드 만들기 위해
	private Lotto3 lt3 = new Lotto3();
	private int gameNum;
	private int selectState = 0; // 0수동 1자동 2반자동
	private RoundedButton moneyBtn; // lotto23창에서 action주려고
	private JLabel helplbl;// 핼프라벨

	public Lotto3 getLt3() {
		return lt3;
	}

	public RoundedButton getMoneybtn() {
		return moneyBtn;
	}

	public JLabel getHelplbl() {
		return helplbl;
	}

	// 해당 숫자가 oneGame에 있는지 없는지 t/f
	private boolean isDupli(int num) {
		for (int i = 0; i < 6; i++) {
			if (Lotto_info.oneGame[i] == num) {
				return true;
			}
		}
		return false;
	}

	// int값 받아서 1~45에서 비활성화
	public static void disable(int num) {
		for (RoundedButton btn : btnlist) { // 그 난수 1~45에서 찾아 비활성화 시킴
			if (btn.getText().equals(String.valueOf(num))) {
				btn.setEnabled(false);
			}
		}
	}

	// 들어갈 자리 파라미터로 받아서 난수 1~45 중 하나 중복체크 후 oneGame에 넣고 1~45 비활성화
	private void autoGetNum(int index) {
		Random random = new Random();
		int randomNum;
		do { // ★중복이면 또 한번 난수 받아야함~!!
			randomNum = ((random.nextInt(45)) + 1);
		} while (isDupli(randomNum));
		Lotto_info.oneGame[index] = randomNum; // 무조건 새로운 수로 난수 받아서 넣음
		disable(randomNum);
	}

	// 라벨에 상태 출력
	private void setLbl(int index) {
		JLabel lbl = lt3.getlblByIndex(index);
		if (selectState == 0) {
			lbl.setText("수동");
		} else if (selectState == 1) {
			lbl.setText("자동");
		} else if (selectState == 2) {
			lbl.setText("반자동");
		}
	}

	// lotto2의 버튼들 true로 초기화 (효)
	public static void trueBtns() {
		for (RoundedButton btn : btnlist) {
			btn.setEnabled(true);
		}
		btnEnter.setEnabled(true);
		btnAuto.setEnabled(true);
		btnSAuto.setEnabled(true);
	}

	// lotto2의 버튼들 false로 초기화 (효)
	public static void falseBtns() {
		for (RoundedButton btn : btnlist) {
			btn.setEnabled(false);
		}
		btnEnter.setEnabled(false);
		btnAuto.setEnabled(false);
		btnSAuto.setEnabled(false);
	}

	// moneylbl 업뎃하는 메소드
	public static void updateMoneyLbl() {
		moneyLbl.setText("소지금 : " + Lotto_info.money + "원");
	}

	// 해당 파라미터 배열에 값이 없을 경우 false를 리턴 시키며 마지막 값 까지 다 차있을 경우는 true를 리턴시킴 7/5 대수
	public boolean checkInNum(int[] arr) {
//		!Lotto_info.isArrEmpty로 바꿀려고 하였으나, regNum과 pushNum 등에 문제가 생겨 해당 메소드 따로 유지 7/6 대수
		for (int a : arr) {
			if (a == 0) {
				return false;
			}
		}
		return true;
	}

	public Lotto2() {
		JPanel pnl2 = new JPanel();// 로또 입력 패널
		pnl2.setBounds(0, 0, 500, 129);
		JPanel pnl3 = new JPanel();// 1~45 패널
		pnl3.setBounds(0, 129, 500, 183);
		JPanel pnl4 = new JPanel();// 자동,반자동,등록 패널
		pnl4.setBounds(0, 310, 500, 72);
		JPanel pnl5 = new JPanel();// 소지금, 돈벌러가기, 도움말 패널
		pnl5.setBounds(0, 410, 500, 80);

		RoundedButton regNum1 = new RoundedButton(); // 뽑은 로또 번호 보여주기1
		regNum1.setBounds(45, 39, 50, 50);
		RoundedButton regNum2 = new RoundedButton(); // 뽑은 로또 번호 보여주기2
		regNum2.setBounds(112, 39, 50, 50);
		RoundedButton regNum3 = new RoundedButton(); // 뽑은 로또 번호 보여주기3
		regNum3.setBounds(179, 39, 50, 50);
		RoundedButton regNum4 = new RoundedButton(); // 뽑은 로또 번호 보여주기4
		regNum4.setBounds(246, 39, 50, 50);
		RoundedButton regNum5 = new RoundedButton(); // 뽑은 로또 번호 보여주기5
		regNum5.setBounds(313, 39, 50, 50);
		RoundedButton regNum6 = new RoundedButton(); // 뽑은 로또 번호 보여주기6
		regNum6.setBounds(380, 39, 50, 50);
		JLabel clearLbl = new JLabel("초기화"); // 숫자 다 비워주는 라벨
		clearLbl.setHorizontalAlignment(SwingConstants.CENTER);
		clearLbl.setFont(new Font("휴먼엑스포", Font.PLAIN, 13));
		clearLbl.setBounds(442, 55, 46, 18);

		regNums[0] = regNum1; // 뽑은 로또 번호 보여주는 버튼을 배열에 담아놓기
		regNums[1] = regNum2;
		regNums[2] = regNum3;
		regNums[3] = regNum4;
		regNums[4] = regNum5;
		regNums[5] = regNum6;

		regNum1.setActionCommand("0"); // regNum.getText()는 들어있는 숫자
		regNum2.setActionCommand("1"); // regNum.getActionCommand()는 해당 인덱스
		regNum3.setActionCommand("2");
		regNum4.setActionCommand("3");
		regNum5.setActionCommand("4");
		regNum6.setActionCommand("5");
		
		// 모든 번호가 찰 경우 출력 시킬 라벨 생성 (대수)
		JLabel fullText = new JLabel("모든 번호가 선택되었습니다.");
		fullText.setHorizontalAlignment(SwingConstants.CENTER);
		fullText.setFont(new Font("굴림", Font.BOLD, 12));
		fullText.setForeground(Color.RED);
		fullText.setBounds(146, 104, 194, 15);
		fullText.setVisible(false);
		pnl2.add(fullText);

		// 1~45누르면 regNum으로 보내는 action (효)
		ActionListener pushNum = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int indexNum = Lotto_info.findIndexNum(); // 이거 돌려서 indexNum 원하는 값으로 집어넣은 후에
				if (indexNum != -1) { // 6칸 꽉차서 -1이 반환되지 않을 때
					((AbstractButton) e.getSource()).setEnabled(false); // 버튼 비활성화 만들고
					Lotto_info.oneGame[indexNum] = Integer.valueOf(((AbstractButton) e.getSource()).getText()); // 버튼에적힌숫자를
																												// oneGame[indexNum]에넣음
					regNums[indexNum].setText(((AbstractButton) e.getSource()).getText()); // 버튼에 적힌 숫자를
																							// regNums[indexNum]에 넣음
				} else { // 6칸이 꽉차서 -1이 반환될 때
					fullText.setVisible(true); // 꽉 찼을 때 fulltext 출력
				}
				btnEnter.setEnabled(checkInNum(Lotto_info.oneGame)); // oneGame에 모든 값이 차 있을 경우 구매버튼 활성화 7/5 대수
				btnSAuto.setEnabled(!Lotto_info.isArrEmpty(Lotto_info.oneGame)); // 값이 전체 0일 경우 반자동 버튼 비활성
			}
		};

		// 1~45버튼만들고 action달기 (소)
		for (int i = 1; i <= 45; i++) {
			RoundedButton numBox = new RoundedButton(String.valueOf(i));
//			RoundedButton a = new RoundedButton(String.valueOf(i));
			numBox.bgSetter(new Color(255, 182, 53));
			numBox.fSetter(new Color(0, 0, 0));
//			numBox = a;
			pnl3.add(numBox); // 1~45번 번호
			btnlist.add(numBox);
			numBox.addActionListener(pushNum);
		}

		// regNum을 누르면 수정하는 action (효)
		ActionListener pushRegNum = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (RoundedButton a : btnlist) { // 공란 만들기 전에 regNum에 있던 숫자찾아서 1~45에서 비활성화 풀기
					if (((AbstractButton) e.getSource()).getText().equals(a.getText())) {
						a.setEnabled(true);
						break;
					}
				}
				((AbstractButton) e.getSource()).setText(""); // 누른 regNum 공란처리
				int index = Integer.valueOf(e.getActionCommand()); // regNum의 인덱스 찾아서
				Lotto_info.oneGame[index] = 0; // oneGame에 0으로 처리
				fullText.setVisible(false); // lotto2 등록 숫자 클릭 시 꽉찼음 문구 사라짐 (대수 7/5)
				btnEnter.setEnabled(checkInNum(Lotto_info.oneGame)); // oneGame에 모든 값이 차 있을 경우 구매버튼 활성화 7/5 대수
				btnSAuto.setEnabled(!Lotto_info.isArrEmpty(Lotto_info.oneGame)); // 값이 전체 0일 경우 반자동 버튼 비활성
			}
		};

		// regNum에 action달기 (효)
		regNum1.addActionListener(pushRegNum);
		regNum2.addActionListener(pushRegNum);
		regNum3.addActionListener(pushRegNum);
		regNum4.addActionListener(pushRegNum);
		regNum5.addActionListener(pushRegNum);
		regNum6.addActionListener(pushRegNum);

//		초기화 버튼 클릭 시 action 빠가사린가 너무어렵네
		clearLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (Lotto_info.money != 0) { // 소지금이 0이 아닐때만 초기화 실행 7/6
					if (lt3.changeOnOff && !lt3.cancleOnOff) {
						if (editState) {
							fullText.setVisible(false);
							Lotto_info.resetOneGame();
							Lotto_info.arrToButton(Lotto_info.oneGame, regNums);
							trueBtns();
							selectState = 0; // 자동 반자동 수동도 수동으로 초기화
						}
					} else if (!lt3.changeOnOff && !lt3.cancleOnOff) {
						fullText.setVisible(false);
						Lotto_info.resetOneGame();
						Lotto_info.arrToButton(Lotto_info.oneGame, regNums);
						trueBtns();
						selectState = 0; // 자동 반자동 수동도 수동으로 초기화
					}
					btnEnter.setEnabled(checkInNum(Lotto_info.oneGame)); // oneGame에 모든 값이 차 있을 경우 구매버튼 활성화 7/5 대수
					btnSAuto.setEnabled(false);
				}
			}
		});

		// RoundedButton 위치, 크기조절 (소)
		btnAuto = new RoundedButton("자동");
		btnAuto.setFont(new Font("휴먼엑스포", Font.PLAIN, 18));
		btnAuto.bgSetter(new Color(255, 255, 224));
		btnAuto.fSetter(new Color(0, 0, 0));
		btnAuto.setBounds(82, 5, 81, 36);

		btnSAuto = new RoundedButton("반자동");
		btnSAuto.setFont(new Font("휴먼엑스포", Font.PLAIN, 18));
		btnSAuto.bgSetter(new Color(255, 255, 224));
		btnSAuto.fSetter(new Color(0, 0, 0));
		btnSAuto.setEnabled(false);
		btnSAuto.setBounds(194, 5, 87, 36);

		btnEnter = new RoundedButton("구매");
		btnEnter.setFont(new Font("휴먼엑스포", Font.PLAIN, 18));
		btnEnter.bgSetter(new Color(255, 255, 224));
		btnEnter.fSetter(new Color(0, 0, 0));
		btnEnter.setBounds(315, 5, 95, 36);
		btnEnter.setEnabled(false);

		moneyLbl = new JLabel("소지금 : " + Lotto_info.money + "원");
		moneyLbl.setBounds(12, 30, 103, 15);
		pnl5.add(moneyLbl);

		moneyBtn = new RoundedButton("돈벌러가기");
		moneyBtn.setBounds(183, 10, 126, 39);
		moneyBtn.bgSetter(new Color(30, 182, 53));
		moneyBtn.fSetter(new Color(0, 0, 0));
		moneyBtn.setFont(new Font("휴먼엑스포", Font.PLAIN, 18));
		pnl5.add(moneyBtn);

		helplbl = new JLabel("※ 도움말 보기");
		helplbl.setBounds(396, 30, 92, 15);

		// 자동btn에 action달기 (효)
		btnAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int runOrNot = JOptionPane.YES_OPTION;
				if (!Lotto_info.isArrEmpty(Lotto_info.oneGame)) { // regNum(oneGame)있는 상태에서 자동으로 돌리면 안내창
					runOrNot = JOptionPane.showConfirmDialog(Lotto2.this,
							"이미 입력한 번호가 지워지고 모든 번호가 자동으로 부여됩니다\n진행하시겠습니까?", "자동확인", JOptionPane.YES_NO_OPTION);
				}
				if (runOrNot == JOptionPane.YES_OPTION) {
					// 초기화진행
					fullText.setVisible(false);
					Lotto_info.resetOneGame();
					Lotto_info.arrToButton(Lotto_info.oneGame, regNums);
					trueBtns();
					// 난수넣기
					for (int i = 0; i < 6; i++) {
						autoGetNum(i); // oneGame 1~6까지 중복없이 난수생성 후,해당 1~45 비활성화
					}
					Arrays.sort(Lotto_info.oneGame); // 자동돌리면 정렬된게 기본
					Lotto_info.arrToButton(Lotto_info.oneGame, regNums);// oneGame을 regNum에다 출력
					// 등록시 자동버튼 누른 애라는거 전달하기
					if (editState) { // 수정중인 패널이었으면
						gameNum = lt3.editIndex; // 수정중인 세트 인덱스
					} else {
						gameNum = Lotto_info.findGameNum(); // 제일 빠른 순서인 빈칸 세트 인덱스
					}
					selectState = 1; // 자동출신
				}
				btnEnter.setEnabled(checkInNum(Lotto_info.oneGame)); // oneGame에 모든 값이 차 있을 경우 구매버튼 활성화 7/5 대수
				btnSAuto.setEnabled(!Lotto_info.isArrEmpty(Lotto_info.oneGame)); // 값이 전체 0일 경우 반자동 버튼 비활성
			}
		});

		// 반자동btn에 action달기 (효)
		btnSAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 난수넣기
				int index = Lotto_info.findIndexNum(); // for문의 시작점를 findIndexNum()로 찾기
				if (index != -1) { // 빈공간 존재
					do {
						autoGetNum(index); // index를 파라미터로 받아서 중복없는 난수를 oneGame에 넣고, 해당 번호 비활성화
						index = Lotto_info.findIndexNum();
					} while (index != -1);
					selectState = 2; // 반자동 출신
				} else { // -1일때(빈공간 없는데 반자동 돌릴 때)
					fullText.setVisible(true);
				}
				Lotto_info.arrToButton(Lotto_info.oneGame, regNums);// oneGame을 regNum에다 출력 등록시 반자동버튼 누른 애라는거 전달하기
				if (editState) { // 수정중인 패널이었으면
					gameNum = lt3.editIndex; // 수정중인 세트 인덱스
				} else {
					gameNum = Lotto_info.findGameNum(); // 제일 빠른 순서인 빈칸 세트 인덱스
				}
				btnEnter.setEnabled(checkInNum(Lotto_info.oneGame)); // oneGame에 모든 값이 차 있을 경우 구매버튼 활성화 7/5 대수
			}
		});

		// 구매하기 btn에 action달기 (효)
		btnEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 등록과정
				lt3.changeBtn.setEnabled(true);
				lt3.cancelBtn.setEnabled(true);
				lt3.resultBtn.setEnabled(true);
					if (editState) { // 수정중인 패널이 있는 경우
						gameNum = lt3.editIndex; // 몇번째 게임인지 인덱스 구하기
						lt3.getPnlByIndex(gameNum).setBackground(new Color(240, 240, 240));// pnl색상 원상복귀
						editState = false; // 등록했으니 수정모드에서 빠져나옴
						lt3.editIndex = -1;
						Arrays.sort(Lotto_info.oneGame); // 정렬하고
						Lotto_info.oneGameToAllGame(gameNum); // allGame 인덱스에 oneGame넣기
						Lotto_info.arrToButton(Lotto_info.oneGame, lt3.getBtnsByIndex(gameNum));// oneGame을 btns에 넣기
						setLbl(gameNum); // 자동 반자동 수동 세팅
						fullText.setVisible(false); // 수정 후 구매 클릭 시 꽉찼음 안내 사라짐 (대수 7/5)
					} else { // 수정중 아니고 걍 등록중인 경우
						gameNum = Lotto_info.findGameNum(); // 몇번째 게임인지 인덱스 구하기
						Lotto_info.money -= 1000; // 돈깎고
						Arrays.sort(Lotto_info.oneGame); // 정렬하고
						Lotto_info.oneGameToAllGame(gameNum); // allGame 인덱스에 oneGame넣고
						Lotto_info.arrToButton(Lotto_info.oneGame, lt3.getBtnsByIndex(gameNum));// oneGame을 btns에 넣고
						setLbl(gameNum);
						fullText.setVisible(false); // 구매 완료 시 꽉 찼음 안내 사라짐 (대수 7/5)
					}
					updateMoneyLbl();// 돌아와서 돈필드 값 수정
					// 초기화과정
					Lotto_info.resetOneGame(); // oneGame 초기화
					Lotto_info.arrToButton(Lotto_info.oneGame, regNums); // regNum도 초기화
					if (Lotto_info.findGameNum() == -1 || lt3.changeOnOff) { // 만약 추가한 후에 allgame이 꽉차있으면(-1) 버튼 다 비활성화~~
						falseBtns();
					} else {
						trueBtns();
					}
					gameNum = -1; // -1(기본값)으로 복귀
					selectState = 0; // 자동 반자동 수동도 수동으로 초기화
					btnEnter.setEnabled(false); // 구매 완료를 누를 시 oneGame은 초기화되기에 비활성화 시킴
					btnSAuto.setEnabled(!Lotto_info.isArrEmpty(Lotto_info.oneGame)); // 값이 전체 0일 경우 반자동 버튼 비활성
					if (Lotto_info.money < 1000) {
						falseBtns();
					}
				
			}
		});

		pnl2.setLayout(null);
		pnl2.add(regNum1);
		pnl2.add(regNum2);
		pnl2.add(regNum3);
		pnl2.add(regNum4);
		pnl2.add(regNum5);
		pnl2.add(regNum6);
		pnl4.setLayout(null);
		pnl4.add(btnAuto);
		pnl4.add(btnSAuto);
		pnl4.add(btnEnter);
		pnl5.setLayout(null);
		pnl5.add(helplbl);
		pnl2.add(clearLbl);
		setLayout(null);
		add(pnl2);
		add(pnl3);
		add(pnl4);
		add(pnl5);
		setSize(500, 500);
	}
}
