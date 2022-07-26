import java.util.ArrayList;
import java.util.List;

public class SaveInfo {
	final int FULL_HP = 5; 
	final int FULL_MENTAL = 5; 
	private int hp;
	private int mental;
	private int party;
	private int npc_likability;
	private List<Item> inventory = new ArrayList<>();
	//item_id에 따라서 durability, count를 개별로 관리할 수 있게 정보 처리 -> 저장필요한 정보 inventory: list<Item>
//	private map<진행상황, 선택사항>
	
	public int getHp() {
		return hp;
	}
	public int getMental() {
		return mental;
	}
	public int getParty() {
		return party;
	}
	public List<Item> getInventory() {
		return inventory;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setMental(int mental) {
		this.mental = mental;
	}
	public void setParty(int party) {
		this.party = party;
	}
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}
	
	
}
 //사용예) SaveInfo user1 = new SaveInfo();
