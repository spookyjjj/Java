import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Lotto3 extends JPanel {
	private RoundedButton[] btns1 = new RoundedButton[6];
	private RoundedButton[] btns2 = new RoundedButton[6];
	private RoundedButton[] btns3 = new RoundedButton[6];
	private RoundedButton[] btns4 = new RoundedButton[6];
	private RoundedButton[] btns5 = new RoundedButton[6];
	private JLabel[] lbls = new JLabel[5];
	private JPanel[] pnls = new JPanel[5];
	// lotto23에서 쓰려고 필드로 생성
	public RoundedButton changeBtn; // allGame에 값이 들어갔을 경우 활성화를 위해 public 필드로 수정 7/6 대수
	public RoundedButton resultBtn; // allGame에 값이 들어갔을 경우 활성화를 위해 public 필드로 수정 7/6 대수
	public RoundedButton cancelBtn; // allGame에 값이 들어갔을 경우 활성화를 위해 public 필드로 수정 7/6 대수
	public int editIndex;
	public boolean changeOnOff = false;
	public boolean cancleOnOff = false;

	public RoundedButton getResultBtn() {
		return resultBtn;
	}

	// index를 파라미터로 받아서, 해당 게임의 pnl로 반환하는 메소드
	public JPanel getPnlByIndex(int index) {
		return pnls[index];
	}

	// index를 파라미터로 받아서, 해당 게임의 lbl로 반환하는 메소드
	public JLabel getlblByIndex(int index) {
		return lbls[index];
	}

	// index를 파라미터로 받아서, 해당 게임의 btns[]로 반환하는 메소드
	public RoundedButton[] getBtnsByIndex(int index) {
		if (index == 0) {
			return btns1;
		} else if (index == 1) {
			return btns2;
		} else if (index == 2) {
			return btns3;
		} else if (index == 3) {
			return btns4;
		} else {
			return btns5;
		}
	}

	// 선택한 패널의 allGame인덱스 알아내기 <- 패널끼리의 동일이 뭔지 알 수가 없어서 pnls에 담아놓고도 못씀,,,
	public int getIndexByPnl(JPanel pnl) {
		if (pnl.getName().equals("pnl1")) {
			return 0;
		} else if (pnl.getName().equals("pnl2")) {
			return 1;
		} else if (pnl.getName().equals("pnl3")) {
			return 2;
		} else if (pnl.getName().equals("pnl4")) {
			return 3;
		} else {
			return 4;
		}
	}

	public Lotto3() {
		setLayout(null);

		JLabel lbl = new JLabel("내가 뽑은 번호");
		lbl.setFont(new Font("휴먼엑스포", Font.BOLD, 18));
		lbl.setBounds(170, 10, 143, 23);
		add(lbl);

		// 패널 5개 생성
		for (int i = 0; i < 5; i++) {
			JPanel pnl = new JPanel();
			add(pnl);
			pnl.setLayout(null);
			pnls[i] = pnl;
		}
		pnls[0].setBounds(12, 54, 421, 60);
		pnls[1].setBounds(12, 124, 421, 60);
		pnls[2].setBounds(12, 194, 421, 60);
		pnls[3].setBounds(12, 264, 421, 60);
		pnls[4].setBounds(12, 334, 421, 60);

		// 패널에 이름붙이기 <-인덱스 알아낼때 씀
		pnls[0].setName("pnl1");
		pnls[1].setName("pnl2");
		pnls[2].setName("pnl3");
		pnls[3].setName("pnl4");
		pnls[4].setName("pnl5");

		JLabel lbl1 = new JLabel("세트1");
		lbl1.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		lbl1.setBounds(12, 22, 46, 15);
		pnls[0].add(lbl1);

		for (int i = 0; i < 6; i++) {
			RoundedButton btn = new RoundedButton("");
			btns1[i] = btn;
			btn.setMargin(new Insets(2, 2, 2, 2));
			pnls[0].add(btn);
		}

		btns1[0].setBounds(109, 10, 40, 40);
		btns1[1].setBounds(161, 10, 40, 40);
		btns1[2].setBounds(213, 10, 40, 40);
		btns1[3].setBounds(265, 10, 40, 40);
		btns1[4].setBounds(317, 10, 40, 40);
		btns1[5].setBounds(369, 10, 40, 40);

		JLabel lbl1_1 = new JLabel();
		lbl1_1.setFont(new Font("휴먼엑스포", Font.PLAIN, 11));
		lbl1_1.setBounds(60, 22, 37, 15);
		pnls[0].add(lbl1_1);
		lbls[0] = lbl1_1;
		// 여기까지 게임1==============================

		JLabel lbl2 = new JLabel("세트2");
		lbl2.setBounds(12, 23, 36, 15);
		lbl2.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		pnls[1].add(lbl2);

		for (int i = 0; i < 6; i++) {
			RoundedButton btn = new RoundedButton("");
			btns2[i] = btn;
			btn.setMargin(new Insets(2, 2, 2, 2));
			pnls[1].add(btn);
		}

		btns2[0].setBounds(109, 10, 40, 40);
		btns2[1].setBounds(161, 10, 40, 40);
		btns2[2].setBounds(213, 10, 40, 40);
		btns2[3].setBounds(265, 10, 40, 40);
		btns2[4].setBounds(317, 10, 40, 40);
		btns2[5].setBounds(369, 10, 40, 40);

		JLabel lbl2_1 = new JLabel();
		lbl2_1.setFont(new Font("휴먼엑스포", Font.PLAIN, 11));
		lbl2_1.setBounds(60, 23, 37, 15);
		pnls[1].add(lbl2_1);
		lbls[1] = lbl2_1;
		// 여기까지 게임2===============================

		JLabel lbl3 = new JLabel("세트3");
		lbl3.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		lbl3.setBounds(12, 20, 36, 15);
		pnls[2].add(lbl3);

		for (int i = 0; i < 6; i++) {
			RoundedButton btn = new RoundedButton("");
			btns3[i] = btn;
			btn.setMargin(new Insets(2, 2, 2, 2));
			pnls[2].add(btn);
		}

		btns3[0].setBounds(109, 10, 40, 40);
		btns3[1].setBounds(161, 10, 40, 40);
		btns3[2].setBounds(213, 10, 40, 40);
		btns3[3].setBounds(265, 10, 40, 40);
		btns3[4].setBounds(317, 10, 40, 40);
		btns3[5].setBounds(369, 10, 40, 40);

		JLabel lbl3_1 = new JLabel();
		lbl3_1.setFont(new Font("휴먼엑스포", Font.PLAIN, 11));
		lbl3_1.setBounds(60, 20, 37, 15);
		pnls[2].add(lbl3_1);
		lbls[2] = lbl3_1;
		// 여기까지 게임3==============================

		JLabel lbl4 = new JLabel("세트4");
		lbl4.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		lbl4.setBounds(12, 20, 36, 15);
		pnls[3].add(lbl4);

		for (int i = 0; i < 6; i++) {
			RoundedButton btn = new RoundedButton("");
			btns4[i] = btn;
			btn.setMargin(new Insets(2, 2, 2, 2));
			pnls[3].add(btn);
		}

		btns4[0].setBounds(109, 10, 40, 40);
		btns4[1].setBounds(161, 10, 40, 40);
		btns4[2].setBounds(213, 10, 40, 40);
		btns4[3].setBounds(265, 10, 40, 40);
		btns4[4].setBounds(317, 10, 40, 40);
		btns4[5].setBounds(369, 10, 40, 40);

		JLabel lbl4_1 = new JLabel();
		lbl4_1.setFont(new Font("휴먼엑스포", Font.PLAIN, 11));
		lbl4_1.setBounds(60, 20, 37, 15);
		pnls[3].add(lbl4_1);
		lbls[3] = lbl4_1;
		// 여기까지 게임4==============================

		JLabel lbl5 = new JLabel("세트5");
		lbl5.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		lbl5.setBounds(12, 20, 36, 15);
		pnls[4].add(lbl5);

		for (int i = 0; i < 6; i++) {
			RoundedButton btn = new RoundedButton("");
			btns5[i] = btn;
			btn.setMargin(new Insets(2, 2, 2, 2));
			pnls[4].add(btn);
		}

		btns5[0].setBounds(109, 10, 40, 40);
		btns5[1].setBounds(161, 10, 40, 40);
		btns5[2].setBounds(213, 10, 40, 40);
		btns5[3].setBounds(265, 10, 40, 40);
		btns5[4].setBounds(317, 10, 40, 40);
		btns5[5].setBounds(369, 10, 40, 40);

		JLabel lbl5_1 = new JLabel();
		lbl5_1.setFont(new Font("휴먼엑스포", Font.PLAIN, 11));
		lbl5_1.setBounds(60, 20, 37, 15);
		pnls[4].add(lbl5_1);
		lbls[4] = lbl5_1;
		// 여기까지 게임5==============================

		// 수정, 구매취소버튼 추가(0705)
		changeBtn = new RoundedButton("수정");
		changeBtn.setFont(new Font("휴먼엑스포", Font.PLAIN, 13));
		changeBtn.bgSetter(new Color(255, 255, 224));
		changeBtn.fSetter(new Color(0, 0, 0));
		changeBtn.setBounds(55, 408, 97, 23);
		changeBtn.setEnabled(false);
		add(changeBtn);

		resultBtn = new RoundedButton("결과확인");
		resultBtn.setFont(new Font("휴먼엑스포", Font.PLAIN, 13));
		resultBtn.bgSetter(new Color(255, 255, 224));
		resultBtn.fSetter(new Color(0, 0, 0));
		resultBtn.setBounds(200, 408, 97, 23);
		resultBtn.setEnabled(false);
		add(resultBtn);

		cancelBtn = new RoundedButton("구매취소");
		cancelBtn.setFont(new Font("휴먼엑스포", Font.PLAIN, 13));
		cancelBtn.bgSetter(new Color(255, 255, 224));
		cancelBtn.fSetter(new Color(0, 0, 0));
		cancelBtn.setBounds(345, 408, 97, 23);
		cancelBtn.setEnabled(false);
		add(cancelBtn);

		MouseListener edit = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (changeOnOff) { // 수정on일때만 패널선택 먹음
					JPanel editedPnl = (JPanel) e.getSource();
					if (!Lotto2.editState) { // 수정모드가 아닌 상태였다면~
						editIndex = getIndexByPnl(editedPnl);
						RoundedButton[] editedBtns = getBtnsByIndex(editIndex);
						Lotto_info.buttonToArr(editedBtns, Lotto_info.oneGame); // 해당btns의 값들을 oneGame에 넣고
						if (!Lotto_info.isArrEmpty(Lotto_info.oneGame)) { // 빈패널이 아니여야 중괄호 안으로 들어갈거임
							editedPnl.setBackground(new Color(255, 182, 53)); // 해당패널 하이라이트
							Lotto2.editState = true; // lotto2로 수정상태라는거 넘김
							Lotto2.trueBtns();// 1~45버튼 다 활성화
							Lotto_info.arrToButton(Lotto_info.oneGame, Lotto2.regNums); // oneGame을 regNum에 출력
							for (int i = 0; i < 6; i++) { // 해당버튼 비활성화
								Lotto2.disable(Lotto_info.oneGame[i]);
							}
						}
					} else { // 수정모드 상태였다면~
						JOptionPane.showMessageDialog(Lotto3.this, "이미 수정중인 세트가 있습니다");
					}
				}

			}
		};
		MouseListener cancle = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (cancleOnOff) { // 취소 on일때만 패널선택 먹음
					JPanel editedPnl = (JPanel) e.getSource();
					editIndex = getIndexByPnl(editedPnl);
					RoundedButton[] editedBtns = getBtnsByIndex(editIndex);
					Lotto_info.buttonToArr(editedBtns, Lotto_info.oneGame); // 해당btns의 값들을 arr(oneGame보호를 위해)에 넣고
					if (!Lotto_info.isArrEmpty(Lotto_info.oneGame)) { // 빈패널이 아니여야 중괄호 안으로 들어갈거임
						getPnlByIndex(editIndex).setBackground(new Color(255, 182, 53));
						int result = JOptionPane.showConfirmDialog(Lotto3.this, "취소하고 환불받으시겠습니까?", "한불?",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							Lotto_info.money += 1000; // 돈 더하고
							Lotto2.updateMoneyLbl();// 소지금 업뎃
							getPnlByIndex(editIndex).setBackground(new Color(240, 240, 240)); // 패널색 복귀
							Lotto_info.resetOneGame();// onegame도 초기화
							Lotto_info.oneGameToAllGame(editIndex); // 해당 인덱스의 allgame찾아서 초기화
							Lotto_info.arrToButton(Lotto_info.oneGame, editedBtns);// 해당 인덱스의 btn도 초기화
							Lotto_info.arrToButton(Lotto_info.oneGame, Lotto2.regNums);// regNum도 초기화
//									Lotto2.resetBtns();// 1~45버튼 다 활성화
							getlblByIndex(editIndex).setText(""); // 자동 반자동 수동도 수동으로 초기화
							editedPnl.setBackground(new Color(240, 240, 240)); // 패널 색 되돌리기
						} else {
							getPnlByIndex(editIndex).setBackground(new Color(240, 240, 240)); // 패널색 복귀
							Lotto_info.resetOneGame();// onegame 초기화
							Lotto_info.arrToButton(Lotto_info.oneGame, Lotto2.regNums);// regNums도 초기화
						}
					}
				}
			}
		};

		changeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!changeOnOff) { // 수정모드 아닐 때
					int runOrNot = JOptionPane.YES_OPTION;
					if (!Lotto_info.isArrEmpty(Lotto_info.oneGame)) { // regNum(oneGame)이 비워져있지 않으면
						runOrNot = JOptionPane.showConfirmDialog(Lotto3.this, "수정모드로 진입하면 작성중이던 번호를 잃게 됩니다\n진행하시겠습니까?",
								"확인", JOptionPane.YES_NO_OPTION);
					}
					if (runOrNot == JOptionPane.YES_OPTION) {
						changeOnOff = true;
						resultBtn.setEnabled(false); // 수정 누르면 결과,구매취소 비활성화
						cancelBtn.setEnabled(false);
						changeBtn.setText("완료"); //
						for (JPanel pnl : pnls) { // 패널에 마우스 액션 더하기
							pnl.addMouseListener(edit);
						}
						Lotto_info.resetOneGame();// onegame 초기화
						Lotto_info.arrToButton(Lotto_info.oneGame, Lotto2.regNums);// oneGame을 btns에 넣기
						Lotto2.falseBtns();
					}
				} else { // 수정모드였다면
					if (Lotto2.editState) { // 이미 패널에 불들어온 상태(수정중)이었다면
						getPnlByIndex(editIndex).setBackground(new Color(240, 240, 240));// pnl색상 원상복귀
						Lotto_info.resetOneGame();// onegame도 초기화
						Lotto_info.arrToButton(Lotto_info.oneGame, Lotto2.regNums);// oneGame을 btns에 넣기
						Lotto2.trueBtns();
						Lotto2.editState = false;
						editIndex = -1;
					}
					changeOnOff = false;
					resultBtn.setEnabled(true); // 수정 누르면 결과,구매취소 비활성화
					cancelBtn.setEnabled(true);
					changeBtn.setText("수정"); //
					for (JPanel pnl : pnls) { // 패널에 마우스 액션 빼기
						pnl.removeMouseListener(edit);
					}
					if (Lotto_info.findGameNum() == -1) { // 수정 후 allGame이 꽉 차 있다면
						Lotto2.falseBtns(); // Lotto2의 전체 버튼 false
					} else { // 수정 후 allGame이 1개라도 비어있다면
						Lotto2.trueBtns(); // Lotto2의 전체 버튼 true
					}
				}
				Lotto2.btnEnter.setEnabled(!Lotto_info.isArrEmpty(Lotto_info.oneGame));
//				oneGame에 모든 값이 차 있을 경우 구매버튼 활성화 7/5 대수 | Lotto2.checkInNum > !Lotto_info.isArrEmpty로 변경 7/6 대수
				Lotto2.btnSAuto.setEnabled(!Lotto_info.isArrEmpty(Lotto_info.oneGame)); // 값이 전체 0일 경우 반자동 버튼 비활성
			}
		});

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!cancleOnOff) { // 삭제off일때
					int runOrNot = JOptionPane.YES_OPTION;
					if (!Lotto_info.isArrEmpty(Lotto_info.oneGame)) { // regNum(oneGame)이 비워져있지 않으면
						runOrNot = JOptionPane.showConfirmDialog(Lotto3.this, "삭제모드로 진입하면 작성중이던 번호를 잃게 됩니다\n진행하시겠습니까?",
								"확인", JOptionPane.YES_NO_OPTION);
					}
					if (runOrNot == JOptionPane.YES_OPTION) {
						cancleOnOff = true;
						resultBtn.setEnabled(false);
						changeBtn.setEnabled(false);
						cancelBtn.setText("완료");
						for (JPanel pnl : pnls) {
							pnl.addMouseListener(cancle);
						}
						Lotto_info.resetOneGame();// onegame 초기화
						Lotto_info.arrToButton(Lotto_info.oneGame, Lotto2.regNums);// oneGame을 btns에 넣기
						Lotto2.falseBtns();
					}
				} else { // 삭제on일때
					cancleOnOff = false;
					resultBtn.setEnabled(true);
					changeBtn.setEnabled(true);
					cancelBtn.setText("구매취소");
					for (JPanel pnl : pnls) {
						pnl.removeMouseListener(cancle);
					}
					if (Lotto_info.findGameNum() == -1) {
						Lotto2.falseBtns();
					} else {
						Lotto2.trueBtns();
					}
					if (Lotto_info.isArrsEmpty(Lotto_info.allGame)) { // 전체 삭제 시 lotto3 버튼들 비활성화
						changeBtn.setEnabled(false);
						resultBtn.setEnabled(false);
						cancelBtn.setEnabled(false);
					} else {
						changeBtn.setEnabled(true);
						resultBtn.setEnabled(true);
						cancelBtn.setEnabled(true);
					}
				}
				Lotto2.btnEnter.setEnabled(!Lotto_info.isArrEmpty(Lotto_info.oneGame));
//				oneGame에 모든 값이 차 있을 경우 구매버튼 활성화 7/5 대수 Lotto2.checkInNum을 !Lotto_info.isArrEmpty로 변경 7/6 값이 전체 0일 경우 반자동 버튼 비활성
			}
		});
	}
}
