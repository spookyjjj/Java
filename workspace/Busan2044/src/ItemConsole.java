import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.co.green.BusanUtil;
//여기에는 dao에서의 기본 메소드 이용해서 만드는 복잡한 로직을 짜는거!
public class ItemConsole {
	private ItemDao dao;
	private SaveInfo user;

	public ItemConsole(ItemDao dao, SaveInfo user) { //객체의존성~ 다오랑 user는 필수
		this.dao = dao;
		this.user = user;
	}

	//상점에 상점캐가 올릴 아이템들 
	//호감도 0: 5개 (3개 회복/1개 무기/1개 이벤트) -> 3, 1, 1
	//호감도 3: 8개 (4개 회복/1개 무기/2개 이벤트) -> 4, 1, 2
	//중복 무기나 이벤트아이템은 상점에 안뜨게 해야함
	//근데 모든 무기나 이벤트 아이템을 인벤토리에 가지고 있다면 무한루프를 돌기때문에 수정이...필요할수도
	private List<Integer> noDupleNpcItem(int rcv, int wpn, int evt) {
		List<Integer> npcItems = new ArrayList<>();
		Connection conn = null;
		try {
			conn = BusanUtil.getConnection();
			for (int i = 0; i < rcv; i++) {
				npcItems.add(dao.trade_npcItem(conn, "rcv"));
			}
			for (int i = 0; i < wpn; i++) {
				int wpnId = dao.trade_npcItem(conn, "wpn");
				if (checkDuple(wpnId) != -1) { //중복이면 다시뽑기
					i--;
				} else {
					npcItems.add(wpnId);
				}
			}
			for (int i = 0; i < evt; i++) {
				int evtId = dao.trade_npcItem(conn, "evt");
				if (checkDuple(evtId) != -1) { //중복이면 다시뽑기
					i--;
				} else {
					npcItems.add(evtId);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return npcItems;
	}
	
	//list<integer> -> list<item>메소드
	private List<Item> integerToItem(List<Integer> list) {
		List<Item> list2 = new ArrayList<>();
		for (int i : list) {
			list2.add(new Item(i, 0, 0));
		}
		return list2; 
	}
	
	//중복인지 체크
	//중복이면 인벤토리에서의 index반환, 중복 아니라면 -1반환
	private int checkDuple(int item_id) {
		List<Item> inventory = user.getInventory();
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getItem_id() == item_id) {
				return i;
			}
		}
		return -1;
	}
	
	//처음에 아이템습득 -> 회복인지체크 -> hp체크 -> 사용/인벤 -> 중복이면 겹치기
	//습득했을때 hp확인해서 부족하면 회복후 어쩌구~하는 로직
	private void getItem(int item_id) {
		try (Connection conn = BusanUtil.getConnection()) {
			int amount;
			if ((amount = dao.getItemHp(conn, item_id)) != 0) { //아이템의 hp가 0이 아니면 체력회복아이템
				if (user.getHp() < user.FULL_HP) {
					int newHp = user.getHp() + amount;
					if (newHp > user.FULL_HP) {
						newHp = user.FULL_HP; 
					}
					user.setHp(newHp);
				} else {
					inputInven(item_id);
				}
			} else if ((amount = dao.getItemMental(conn, item_id)) != 0) { //아이템의 Mental이 0이 아니면 멘탈회복아이템
				if (user.getMental() < user.FULL_MENTAL) {
					int newMental = user.getMental() + amount;
					if (newMental > user.FULL_MENTAL) {
						newMental = user.FULL_MENTAL; 
					}
					user.setMental(newMental);
				} else {
					inputInven(item_id);
				}
			} else { //위의 두개가 이나면 잡템
				inputInven(item_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//중복아이템을 주으면 해당 인벤토리 인덱스의 count를 ++하는 걸로 바꾸기~
	private void inputInven(int item_id) {
		int index = checkDuple(item_id);
		if (index != -1) { //중복이면 
			user.getInventory().get(index).setItem_count(user.getInventory().get(index).getItem_count() + 1);
		} else { //중복이 아니면
			try (Connection conn = BusanUtil.getConnection()) {
				user.getInventory().add(dao.setItemInfo(conn, item_id));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 상점or유저의 교환아이템 list > 아이템 클릭시 list에 담기도록 클릭이벤트 실행
	private List ontable(Item item_id) {
		List<Item> ontable = new ArrayList<>();
		ontable.add(item_id);
		return ontable;
	}
	
	// 상점or유저 테이블에 올라온 list들의 레어도 합
	private int ontableItemRare(List<Item> list) {
		Connection conn = null;
		int sumItemRare = 0;
		try {
			conn = BusanUtil.getConnection();
			for (int i = 0; i < list.size(); i++) {
				sumItemRare += dao.getItemRare(conn, list.get(i).getItem_id());
			}
		} catch (Exception e) {
			System.out.println("에러");
		} finally {
			BusanUtil.closeConn(conn);
		}
		return sumItemRare;
	}
	
	// 유저와 상점에서 받아온 list들의 합을 비교하는 메소드
	private void tradeItem_rareCompare(List<Item> storeItem_list, List<Item> userItem_list, double store_likability) {
		int sumStoreItem = ontableItemRare(storeItem_list);
		int sumUserItem = ontableItemRare(userItem_list);
		int compare = 0;
		
		// npc호감도를 가져와서 더할 수 있도록 해야함
		// double > int 변환시 값 내림 효과 0.7 -> 0, 1.05 -> 1
		sumStoreItem -= (int)(store_likability*0.35);
		
		if (sumStoreItem < sumUserItem) {
			compare = 1;
		} else if (sumStoreItem == sumUserItem) {
			compare = 2;
		} else {
			compare = 3;
		}
		while (true) {
			switch (compare) {
				case 1 : {
					System.out.println("상점NPC가 이 거래를 매우 만족해 합니다.");
					// 인벤토리에서 교환list 삭제 메소드 추가해야함
					break;
				}
				case 2 : {
					System.out.println("상점NPC가 이 거래를 승낙 합니다.");
					// 인벤토리에서 교환list 삭제 메소드 추가해야함
					break;
				}
				default : {
					System.out.println("상점NPC가 이 거래를 맘에 들어 하지 않습니다. 믈건을 더 올려야해요");
					break;
				}
			}
			break;
		}
	}

	// 유저가 인벤토리에서 item을 버릴 시 인벤토리 List에서 item을 삭제할 수 있는 메소드 만들어야 함

	public void itemRemove(SaveInfo user, int item_id) {
		List<Item> inventory = user.getInventory();
////      유저가 패널에서 이미지를 누르면  9번 이름이 삭제되게 
//	
//		int nowid =  user.getInventory().get(0).getItem_id();
//		
		int index = -1;
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getItem_id() == item_id) {
				index = i;
			}
		}
		user.getInventory().remove(index);
		

	}
	
	
	public static void main(String[] args) {
		SaveInfo user1 = new SaveInfo();
		ItemConsole ic = new ItemConsole(new ItemDao(), user1);
		
		
		user1.setInventory(new ArrayList<Item>(Arrays.asList(new Item(9, 0, 1), new Item(15, 1, 999))));
		System.out.println(user1.getInventory());

		ic.itemRemove(user1, 15);
		System.out.println(user1.getInventory());
		
		
		
//		user1.setInventory(new ArrayList<Item>(Arrays.asList(new Item(9, 4, 1), new Item(11, 2, 4), new Item(4, 1, 1))));
		// 9번 11번 3번 = 호감도 1+1+4 = 레어도 6
//		user1.setInventory(new ArrayList<Item>(Arrays.asList(new Item(5, 1, 1), new Item(11, 1, 1), new Item(9, 1, 1))));
//		user1.setHp(3);
//		user1.setMental(4);
//		ic.getItem(11);
//		ic.getItem(11);
//		System.out.println("멘탈 : " + user1.getMental() + ", hp : " + user1.getHp());
//		System.out.println(user1.getInventory());
//		List<Item> storeInventory = new ArrayList<Item>(Arrays.asList(new Item(9, 0, 1), new Item(11, 2, 4), new Item(16, 1, 1)));
		// 9번+11번+16번 = 1+1+5 = 레어도 7
//		List<Item> storeInventory = ic.integerToItem(ic.noDupleNpcItem(3, 1, 1)); //랜덤으로 할당되었다~
//		
//		
//		System.out.println("임의로 넣은 유저 인벤토리 : " + user1.getInventory());
//		System.out.println("임의로 넣은 상점 인벤토리 : " + storeInventory);
//	
//		System.out.println("상점아이템의 총 레어도 : " + ic.ontableItemRare(storeInventory));
//		System.out.println("유저아이템의 총 레어도 : " + ic.ontableItemRare(user1.getInventory()));
//		
//		System.out.print("호감도 0 >>  ");		ic.tradeItem_rareCompare(storeInventory, user1.getInventory(), 0.0);
//		System.out.print("호감도 2 >>  ");		ic.tradeItem_rareCompare(storeInventory, user1.getInventory(), 2.0);
//		System.out.print("호감도 3 >>  ");		ic.tradeItem_rareCompare(storeInventory, user1.getInventory(), 3.0);
//		System.out.print("호감도 4 >>  ");		ic.tradeItem_rareCompare(storeInventory, user1.getInventory(), 4.0);
//		System.out.print("호감도 5 >>  ");		ic.tradeItem_rareCompare(storeInventory, user1.getInventory(), 5.0);
//		System.out.print("호감도 6 >>  ");		ic.tradeItem_rareCompare(storeInventory, user1.getInventory(), 6.0);
		

	}
}
