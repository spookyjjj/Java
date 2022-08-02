package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import kr.co.green.BusanUtil;
import main2.ShopPnl;
import main2.StoryPnl2;

//class TSPanel extends JPanel {
//	   TSPanel() {
//	      this.setOpaque(false);
//	   }
//	}

public class Trade extends JPanel {
	private List<JLabel> storeItemCount;
	private List<JLabel> storeItem;
	private List<JLabel> myItemCount;
	private List<JLabel> myItem;
	private List<JLabel> storePickCount;
	private List<JLabel> storePick;
	private List<JLabel> myPickCount;
	private List<JLabel> myPick;
	private JLabel npcImg;
	private List<Item> ontableM = new ArrayList<>();
	private List<Item> ontableS = new ArrayList<>();
	private JButton tradeBtn;
	private int btnEnabled; // 거래하기 버튼: 활성화 = 1, 비활성화 = 0

	private ItemDao dao;
	private UserInfo user;
	private ItemConsole console;
	private JPanel container;

	public List<JLabel> getStoreItemCount() {
		return storeItemCount;
	}

	public List<JLabel> getStoreItem() {
		return storeItem;
	}

	public List<JLabel> getMyItemCount() {
		return myItemCount;
	}

	public List<JLabel> getMyItem() {
		return myItem;
	}

	public JLabel getNpcImg() {
		return npcImg;
	}

	// 상점캐 랜덤세팅 통합본!!
	public void setStoreItem(int rcv, int wpn, int evt) {
		List<Integer> list = noDupleNpcItem(rcv, wpn, evt);
		List<Item> items = integerToItem(list);
		console.lblImg(storeItem, items);
		console.lblCount(storeItem, storeItemCount);
	}

	// 인벤토리를 내 아이템으로 세팅 통합본!!
	public void setMyItem() {
		List<Item> items = console.pickDealItem(); // 인벤에서 거래가능만 가져옴
		console.lblImg(myItem, items);
		console.lblCount(myItem, myItemCount);
	}

	// 상점 랜덤뽑기
	// 호감도 0: 5개 (3개 회복/1개 무기/1개 이벤트) -> 3, 1, 1
	// 호감도 3: 8개 (4개 회복/1개 무기/2개 이벤트) -> 4, 1, 2
	// 근데 모든 무기나 이벤트 아이템을 인벤토리에 가지고 있다면 무한루프를 돌기때문에 수정이...필요할수도
	private List<Integer> noDupleNpcItem(int rcv, int wpn, int evt) {
		List<Integer> npcItems = new ArrayList<>();
		try (Connection conn = BusanUtil.getConnection()) {
			List<Integer> rcvIds = new ArrayList<>(); // 소비용아이템은 상점 내에서 중복 안됨
			for (int i = 0; i < rcv; i++) {
				int rcvId = console.trade_npcItem(conn, "rcv");
				if (rcvIds.contains(rcvId)) {
					i--;
				} else {
					rcvIds.add(rcvId);
					npcItems.add(rcvId);
				}
			}
			for (int i = 0; i < wpn; i++) { // 무기는 내 인벤에 있는건 안뜸
				int wpnId = console.trade_npcItem(conn, "wpn");
				if (console.checkDuple(wpnId) != -1) {
					i--;
				} else {
					npcItems.add(wpnId);
				}
			}
			for (int i = 0; i < evt; i++) { // 이벤용 아이템도 내 인벤에 있는건 안뜸
				int evtId = console.trade_npcItem(conn, "evt");
				if (console.checkDuple(evtId) != -1) {
					i--;
				} else {
					npcItems.add(evtId);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return npcItems;
	}

	// list<integer> -> list<item>메소드
	private List<Item> integerToItem(List<Integer> list) {
		List<Item> list2 = new ArrayList<>();
		try (Connection conn = BusanUtil.getConnection()) {
			for (int i : list) {
				list2.add(console.setItemInfo(conn, i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list2;
	}

	// 상점or유저 테이블에 올라온 list들의 레어도 합
	private int ontableItemRare(List<Item> list) {
		Connection conn = null;
		int sumItemRare = 0;
		try {
			conn = BusanUtil.getConnection();
			for (int i = 0; i < list.size(); i++) {
				sumItemRare = sumItemRare
						+ (dao.getItemRare(conn, list.get(i).getItem_id()) * list.get(i).getItem_count());
				// 개수 추가해야함
			}
		} catch (Exception e) {
			System.out.println("에러");
		} finally {
			BusanUtil.closeConn(conn);
		}
		return sumItemRare;
	}

	// 아이템들을 실시간으로 계산하여 상점npc의 표정이 변화하는 메소드
	public void tradeItem_npcFaceImg(int compare) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		String npcFaceUrl = "";
		switch (compare) {
		case 1: // 매우좋음 : 거래가능
			npcFaceUrl = "501.png";
			btnEnabled = 1;
			break;
		case 2: // 적당함 : 거래가능
			npcFaceUrl = "502.png";
			btnEnabled = 1;
			break;
		case 3: // 싫음 : 거래 불가능
			npcFaceUrl = "503.png";
			btnEnabled = 0;
			break;
		case 0:
			npcFaceUrl = "500.png";
			btnEnabled = 0;
			break;
		default: // 기본얼굴
			npcFaceUrl = "500.png";
			btnEnabled = 0;
			break;
		}
		URL url = Trade.class.getClassLoader().getResource(npcFaceUrl);
		Image img = kit.getImage(url);
		npcImg.setIcon(new ImageIcon(img));
		tradeBtnOnOff();
	}

	// 유저와 상점에서 받아온 list들의 합을 비교하는 메소드
	private int tradeItem_rareCompare(List<Item> storeItem_list, List<Item> userItem_list) {
		int sumStoreItem = ontableItemRare(storeItem_list);
		int sumUserItem = ontableItemRare(userItem_list);
		int compare = 0;
		if (sumStoreItem == 0 && sumUserItem == 0) {
			return 0;
		}
		// double > int 변환시 값 내림 효과 0.7 -> 0, 1.05 -> 1
		sumStoreItem -= (int) (user.getNpc_likability() * 0.35);
		if (sumStoreItem < sumUserItem) {
			compare = 1;
		} else if (sumStoreItem == sumUserItem) {
			compare = 2;
		} else {
			compare = 3;
		}
		return compare;
	}

	// 패널의 id값을 받아오는 메소드 item_durability -> 정보없는 공란lbl이면 -1반환
	public int lbl_searchDurability(JLabel lbl) {
		String lblstr = lbl.getText();
		if (!lblstr.equals("")) {
			String[] idstr = lblstr.split("/", 3);
			int durability = Integer.parseInt(idstr[1]);
			return durability;
		} else {
			return -1;
		}
	}

	// lbl에 저장된 text에서 durability값만 수정하기
	public boolean lbl_setDurability(JLabel lbl, int durability) {
		String lblstr = lbl.getText();
		if (!lblstr.equals("")) {
			int lastslash = lblstr.lastIndexOf("/");
			String newstr = lblstr.substring(0, lastslash) + "/" + durability;
			lbl.setText(newstr);
			return true;
		} else {
			return false;
		}
	}

	// lbl에 저장된 text에서 count값만 수정하기
	public boolean lbl_setCount(JLabel lbl, int count) {
		String lblstr = lbl.getText();
		if (!lblstr.equals("")) {
			int lastslash = lblstr.lastIndexOf("/");
			String newstr = lblstr.substring(0, lastslash) + "/" + count;
			lbl.setText(newstr);
			return true;
		} else {
			return false;
		}
	}

	// lbl 선택시, 해당하는 count lbl반환
	public JLabel getCountLbl(JLabel lbl, List<JLabel> lbls, List<JLabel> count) { // 찾을 애, count list
		return count.get(lbls.indexOf(lbl));
	}

	// count-1하고 table은 +1 반영하기
	public boolean clickToTable(JLabel lbl, List<JLabel> lbls, List<JLabel> counts) {
		int count = console.lbl_searchCount(lbl);
		if (count > 0) { // count보다 작을 때는 작동 안함~ 1개 이상일때 작동
			count--;
			lbl_setCount(lbl, count); // count -1한거 text에 설정
			getCountLbl(lbl, lbls, counts).setText(String.valueOf(count));
//			if0gray(lbl);
			return true;
		} else {
			return false;
		}
	}

	// 상점or유저의 교환아이템 list > 아이템 클릭시 list에 담기도록 클릭이벤트 실행
	private void backtableM(JLabel lbl) {
		int index = myPick.indexOf(lbl); // 3
		int item_id = console.lbl_searchID(lbl); // 1
		int count = console.lbl_searchCount(lbl); // 2

		if (index != -1) { // lbl이 다 비어져 있는경우
			if (count > 1) {
				count--;
				ontableM.get(index).setItem_count(count);
				lbl_setCount(myPick.get(index), count);
				myPickCount.get(index).setText(String.valueOf(count));
			} else if (count == 1) {
				ontableM.remove(index);
				for (JLabel lbll : myPick) {
					lbll.setText("");
					lbll.setIcon(null);
				}
				for (JLabel lbll : myPickCount) {
					lbll.setText("");
				}
				console.lblImg(myPick, ontableM);
				console.lblCount(myPick, myPickCount);
			} else {
				System.out.println("뭔데 이건");
			}
			// 여기까지가 테이블에서 빼는 동작
			for (int i = 0; i < myItem.size(); i++) {
				if (console.lbl_searchID(myItem.get(i)) == item_id) {
					index = i;
				}
			}
			count = console.lbl_searchCount(myItem.get(index));
			lbl_setCount(myItem.get(index), count + 1);
//			storeItem.get(index).setBackground(new Color(0, 0, 0, 0));
			myItemCount.get(index).setText(String.valueOf(count + 1));
			// 여기까지가 테이블에서 뺀거 넣는 동작
		}
	}

	private void backtableS(JLabel lbl) {
		int index = storePick.indexOf(lbl);
		int item_id = console.lbl_searchID(lbl);
		if (index != -1) { // lbl이 다 비어져 있는경우
			ontableS.remove(index);
			for (JLabel lbll : storePick) {
				lbll.setText("");
				lbll.setIcon(null);
			}
			for (JLabel lbll : storePickCount) {
				lbll.setText("");
			}
			console.lblImg(storePick, ontableS);
			console.lblCount(storePick, storePickCount);
			// 여기까지가 테이블에서 빼는 동작
			for (int i = 0; i < storeItem.size(); i++) {
				if (console.lbl_searchID(storeItem.get(i)) == item_id) {
					index = i;
				}
			}
			int count = console.lbl_searchCount(storeItem.get(index));
			lbl_setCount(storeItem.get(index), count + 1);
//			storeItem.get(index).setBackground(new Color(0, 0, 0, 0));
			storeItemCount.get(index).setText(String.valueOf(count + 1));
			// 여기까지가 테이블에서 뺀거 넣는 동작
		}
	}

	// 이게 통합본
	private void ontableM(JLabel lbl) {
		int item_id = console.lbl_searchID(lbl);
		int index = checkDupleItems(ontableM, item_id);
		if (index != -1) { // 중복이면
			if (clickToTable(lbl, myItem, myItemCount)) {
				ontableM.get(index).setItem_count(ontableM.get(index).getItem_count() + 1);
				console.lblImg(myPick, ontableM);
				console.lblCount(myPick, myPickCount);
			}
		} else { // 중복이 아니면
			if (ontableM.size() < 4) {
				if (clickToTable(lbl, myItem, myItemCount)) {
					int nullIndex;
					if ((nullIndex = ontableM.indexOf(null)) != -1) {
						ontableM.add(nullIndex, new Item(item_id, lbl_searchDurability(lbl), 1));
					} else {
						ontableM.add(new Item(item_id, lbl_searchDurability(lbl), 1));
					}
					console.lblImg(myPick, ontableM);
					console.lblCount(myPick, myPickCount);
				}
			} else {
				JOptionPane.showMessageDialog(Trade.this, "테이블이 꽉 찼습니다");
			}
		}
	}

	// 이게 통합본
	private void ontableS(JLabel lbl) { // 중복이면 진행 ㄱㄱ 중복 아니면개수 4개 꽉찼는지 확인 안찼으면 ㄱㄱ 개수 충분한지
		int item_id = console.lbl_searchID(lbl);
		int index = checkDupleItems(ontableS, item_id);
		if (ontableS.size() < 4) {
			if (clickToTable(lbl, storeItem, storeItemCount)) {
				ontableS.add(new Item(item_id, lbl_searchDurability(lbl), 1));
				console.lblImg(storePick, ontableS);
				console.lblCount(storePick, storePickCount);
			}
		} else {
			JOptionPane.showMessageDialog(Trade.this, "테이블이 꽉 찼습니다");
		}
	}

	// 중복인지 체크
	// 중복이면 인벤토리에서의 index반환, 중복 아니라면 -1반환
	private int checkDupleItems(List<Item> items, int item_id) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getItem_id() == item_id) {
				return i;
			}
		}
		return -1;
	}

	// 아이템id값으로 item_code 가져오기
	public String IdToCode(int item_id) {
		Connection conn = null;
		String code = "";
		try {
			conn = BusanUtil.getConnection();
			String type = dao.getItemCode(conn, item_id);
			if (type.equals("wpn")) {
				code = "무기";
			} else if (type.equals("rcv")) {
				code = "회복";
			} else if (type.equals("evt")) {
				code = "이벤트";
			} else {
				code = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BusanUtil.closeConn(conn);
		}
		return code;
	}

	public void tradeBtnOnOff() {
		if (btnEnabled == 1) {
			tradeBtn.setEnabled(true);
		} else {
			tradeBtn.setEnabled(false);
		}
	}

	// 생성자!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public Trade(ItemConsole console, ShopPnl container, StoryPnl2 StoryPnl2) { // 객체 의존성
		super();
		this.console = console;
		dao = this.console.getDao();
		user = this.console.getUser();
		this.container = container; // 이 컨테이너가 ShopPnl

		container.getBtnPnl().setVisible(false);
		container.add(Trade.this);

		setBackground(new Color(112, 128, 144));
		setLayout(null);

		JPanel storePnl = new JPanel();
		storePnl.setBackground(new Color(112, 128, 144));
		storePnl.setBounds(240, 10, 532, 90);
		add(storePnl);
		storePnl.setLayout(null);

		// 상점아이템 목록 5개~7개 count용
		storeItemCount = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			JLabel lbl = new JLabel("");
//			lbl.setOpaque(true);
			lbl.setFont(new Font("휴먼굴림체", Font.BOLD, 14));
			lbl.setForeground(Color.RED);
			storeItemCount.add(lbl);
			storePnl.add(lbl);
		}
		storeItemCount.get(0).setBounds(50, 64, 26, 26);
		storeItemCount.get(1).setBounds(126, 64, 26, 26);
		storeItemCount.get(2).setBounds(202, 64, 26, 26);
		storeItemCount.get(3).setBounds(278, 64, 26, 26);
		storeItemCount.get(4).setBounds(354, 64, 26, 26);
		storeItemCount.get(5).setBounds(430, 64, 26, 26);
		storeItemCount.get(6).setBounds(506, 64, 26, 26);

		// 상점아이템 목록 5개~7개 img용
		storeItem = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			JLabel lbl = new JLabel("");
//			lbl.setOpaque(true);
			storeItem.add(lbl);
			storePnl.add(lbl);
			lbl.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					JLabel lbl = (JLabel) e.getSource();
					ontableS(lbl);
//					System.out.println(lbl.getText());
					tradeItem_npcFaceImg(tradeItem_rareCompare(ontableS, ontableM));
				};

			});
		}
		storeItem.get(0).setBounds(0, 0, 76, 90);
		storeItem.get(1).setBounds(76, 0, 76, 90);
		storeItem.get(2).setBounds(152, 0, 76, 90);
		storeItem.get(3).setBounds(228, 0, 76, 90);
		storeItem.get(4).setBounds(304, 0, 76, 90);
		storeItem.get(5).setBounds(380, 0, 76, 90);
		storeItem.get(6).setBounds(456, 0, 76, 90);

		JPanel myPnl = new JPanel();
		myPnl.setBounds(12, 370, 760, 180);
		myPnl.setBackground(new Color(112, 128, 144));
		add(myPnl);
		myPnl.setLayout(new GridLayout(2, 10, 0, 0));

		JPanel myPnlTop = new JPanel();
		myPnlTop.setBackground(new Color(112, 128, 144));
		myPnl.add(myPnlTop);
		myPnlTop.setLayout(null);

		JPanel myPnlBottom = new JPanel();
		myPnlBottom.setBackground(new Color(112, 128, 144));
		myPnl.add(myPnlBottom);
		myPnlBottom.setLayout(null);

		// 내아이템 목록 10개 count용
		myItemCount = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JLabel lbl = new JLabel("");
//			lbl.setOpaque(true);
			lbl.setFont(new Font("휴먼굴림체", Font.BOLD, 14));
			lbl.setForeground(Color.red);
			myItemCount.add(lbl);
			myPnlTop.add(lbl);
		}
		for (int i = 0; i < 10; i++) {
			JLabel lbl = new JLabel("");
//			lbl.setOpaque(true);
			lbl.setFont(new Font("휴먼굴림체", Font.BOLD, 14));
			lbl.setForeground(Color.red);
			myItemCount.add(lbl);
			myPnlBottom.add(lbl);
		}
		myItemCount.get(0).setBounds(50, 64, 26, 26);
		myItemCount.get(1).setBounds(126, 64, 26, 26);
		myItemCount.get(2).setBounds(202, 64, 26, 26);
		myItemCount.get(3).setBounds(278, 64, 26, 26);
		myItemCount.get(4).setBounds(354, 64, 26, 26);
		myItemCount.get(5).setBounds(430, 64, 26, 26);
		myItemCount.get(6).setBounds(506, 64, 26, 26);
		myItemCount.get(7).setBounds(582, 64, 26, 26);
		myItemCount.get(8).setBounds(658, 64, 26, 26);
		myItemCount.get(9).setBounds(734, 64, 26, 26);
		// bottom
		myItemCount.get(10).setBounds(50, 64, 26, 26);
		myItemCount.get(11).setBounds(126, 64, 26, 26);
		myItemCount.get(12).setBounds(202, 64, 26, 26);
		myItemCount.get(13).setBounds(278, 64, 26, 26);
		myItemCount.get(14).setBounds(354, 64, 26, 26);
		myItemCount.get(15).setBounds(430, 64, 26, 26);
		myItemCount.get(16).setBounds(506, 64, 26, 26);
		myItemCount.get(17).setBounds(582, 64, 26, 26);
		myItemCount.get(18).setBounds(658, 64, 26, 26);
		myItemCount.get(19).setBounds(734, 64, 26, 26);

		// 내아이템 목록 10개 img용
		myItem = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JLabel lbl = new JLabel("");
//			lbl.setOpaque(true);
			myPnlTop.add(lbl);
			myItem.add(lbl);
			lbl.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					JLabel lbl = (JLabel) e.getSource();
					ontableM(lbl);
//					System.out.println(lbl.getText());
					tradeItem_npcFaceImg(tradeItem_rareCompare(ontableS, ontableM));
				};
			});
		}
		for (int i = 0; i < 10; i++) {
			JLabel lbl = new JLabel("");
//			lbl.setOpaque(true);
			myPnlBottom.add(lbl);
			myItem.add(lbl);
			lbl.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					JLabel lbl = (JLabel) e.getSource();
					ontableM(lbl);
//					System.out.println(lbl.getText());
					tradeItem_npcFaceImg(tradeItem_rareCompare(ontableS, ontableM));
				};
			});
		}
		myItem.get(0).setBounds(0, 0, 76, 90);
		myItem.get(1).setBounds(76, 0, 76, 90);
		myItem.get(2).setBounds(152, 0, 76, 90);
		myItem.get(3).setBounds(228, 0, 76, 90);
		myItem.get(4).setBounds(304, 0, 76, 90);
		myItem.get(5).setBounds(380, 0, 76, 90);
		myItem.get(6).setBounds(456, 0, 76, 90);
		myItem.get(7).setBounds(532, 0, 76, 90);
		myItem.get(8).setBounds(608, 0, 76, 90);
		myItem.get(9).setBounds(684, 0, 76, 90);
		// bottom
		myItem.get(10).setBounds(0, 0, 76, 90);
		myItem.get(11).setBounds(76, 0, 76, 90);
		myItem.get(12).setBounds(152, 0, 76, 90);
		myItem.get(13).setBounds(228, 0, 76, 90);
		myItem.get(14).setBounds(304, 0, 76, 90);
		myItem.get(15).setBounds(380, 0, 76, 90);
		myItem.get(16).setBounds(456, 0, 76, 90);
		myItem.get(17).setBounds(532, 0, 76, 90);
		myItem.get(18).setBounds(608, 0, 76, 90);
		myItem.get(19).setBounds(684, 0, 76, 90);

		JPanel tablePnl = new JPanel();
		tablePnl.setBorder(null);
		tablePnl.setBackground(new Color(112, 128, 144));
		tablePnl.setBounds(240, 128, 532, 205);
		add(tablePnl);

		tradeBtn = new JButton("거래하기");
		tradeBtn.setBounds(216, 87, 97, 23);
		tradeBtn.setFont(new Font("HY목각파임B", Font.PLAIN, 14));
		tradeBtn.setEnabled(false);
		tradeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 내 인벤에 넣기
				for (int i = 0; i < ontableS.size(); i++) {
					int item_id = ontableS.get(i).getItem_id();
					console.getItem(item_id);
				}

				// 내 인벤에서 빼기
				List<Item> inven = user.getInventory();
				for (int i = 0; i < ontableM.size(); i++) {
					int item_id = ontableM.get(i).getItem_id();
					int item_count = ontableM.get(i).getItem_count();
					for (int j = 0; j < inven.size(); j++) {
						if (item_id == inven.get(j).getItem_id()) {
							if (inven.get(j).getItem_count() == item_count) {
								user.getInventory().remove(j);
							} else {
								int newCount = (inven.get(j).getItem_count() - item_count);
								inven.get(j).setItem_count(newCount);
							}
						}
					}
				}

				StoryPnl2.userInven();

				//나가는 행위
			    container.getBtnPnl().setVisible(true);
	            container.remove(Trade.this);

			}
		});
		tablePnl.setLayout(null);
		tablePnl.add(tradeBtn);

		// 상점아이템픽 목록 4개 count용
		storePickCount = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JLabel lbl = new JLabel("");
//			lbl.setOpaque(true);
			lbl.setFont(new Font("휴먼굴림체", Font.BOLD, 14));
			lbl.setForeground(Color.red);
			storePickCount.add(lbl);
			tablePnl.add(lbl);
		}
		storePickCount.get(0).setBounds(62, 78, 26, 26);
		storePickCount.get(1).setBounds(155, 78, 26, 26);
		storePickCount.get(2).setBounds(62, 185, 26, 26);
		storePickCount.get(3).setBounds(155, 185, 26, 26);

		// 상점아이템픽 목록 4개 img용
		storePick = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JLabel lbl = new JLabel("");
//			lbl.setOpaque(true);
			tablePnl.add(lbl);
			storePick.add(lbl);
			lbl.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					JLabel lbl = (JLabel) e.getSource();
					backtableS(lbl);
					tradeItem_npcFaceImg(tradeItem_rareCompare(ontableS, ontableM));
				};
			});
		}
		storePick.get(0).setBounds(12, 14, 76, 90);
		storePick.get(1).setBounds(105, 14, 76, 90);
		storePick.get(2).setBounds(12, 121, 76, 90);
		storePick.get(3).setBounds(105, 121, 76, 90);

		// 내아이템픽 목록 4개 count용
		myPickCount = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JLabel lbl = new JLabel("");
//			lbl.setOpaque(true);
			lbl.setFont(new Font("휴먼굴림체", Font.BOLD, 14));
			lbl.setForeground(Color.red);
			myPickCount.add(lbl);
			tablePnl.add(lbl);
		}
		myPickCount.get(0).setBounds(393, 78, 26, 26);
		myPickCount.get(1).setBounds(475, 78, 26, 26);
		myPickCount.get(2).setBounds(393, 185, 26, 26);
		myPickCount.get(3).setBounds(475, 185, 26, 26);

		// 내아이템픽 목록 4개 img용
		myPick = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			JLabel lbl = new JLabel("");
//			lbl.setOpaque(true);
			tablePnl.add(lbl);
			myPick.add(lbl);
			lbl.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					JLabel lbl = (JLabel) e.getSource();
					backtableM(lbl);
					tradeItem_npcFaceImg(tradeItem_rareCompare(ontableS, ontableM));
				};
			});
		}
		myPick.get(0).setBounds(343, 14, 76, 90);
		myPick.get(1).setBounds(425, 14, 76, 90);
		myPick.get(2).setBounds(343, 121, 76, 90);
		myPick.get(3).setBounds(425, 121, 76, 90);

		JPanel npcImgPnl = new JPanel();
		npcImgPnl.setBounds(12, 10, 216, 350);
		npcImgPnl.setBackground(new Color(112, 128, 144));
		add(npcImgPnl);
		npcImgPnl.setLayout(null);

		npcImg = new JLabel("");
		npcImg.setBounds(0, 0, 216, 350);
		npcImgPnl.add(npcImg);
		tradeItem_npcFaceImg(0);

		// 220801 3:57 수정//
		JButton outBtn = new JButton("나가기");
		outBtn.setBounds(691, 567, 97, 23);
		add(outBtn);
		setVisible(true);
		
		//나가기 버튼
		outBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				container.getBtnPnl().setVisible(true);
				container.remove(Trade.this);
				
			}
		});

		setSize(800, 600);
		setVisible(true);
	}
}
