import java.util.ArrayList;
import java.util.List;

public class Character {
	private int hp;
	private int mental;
	private int party;
	private List<Item> inventory = new ArrayList<>();
	//item_id에 따라서 durability, count를 개별로 관리할 수 있게 정보 처리 -> 저장필요한 정보 inventory: list<Item>
	
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
	
	
}
