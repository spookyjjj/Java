
public class Item {
	private int item_id;
	private int item_durability;
	private int item_count;
//	private String item_code;
//	private String item_name;
//	private int item_rare;
//	private double item_victory;
//	private boolean item_nodeal;
//	private int item_hp;
//	private int item_mental;
//	private String item_img;
//	private String item_memo;
	
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public void setItem_durability(int item_durability) {
		this.item_durability = item_durability;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
//	public void setItem_code(String item_code) {
//		this.item_code = item_code;
//	}
//	public void setItem_name(String item_name) {
//		this.item_name = item_name;
//	}
//	public void setItem_rare(int item_rare) {
//		this.item_rare = item_rare;
//	}
//	public void setItem_victory(double item_victory) {
//		this.item_victory = item_victory;
//	}
//	public void setItem_nodeal(boolean item_nodeal) {
//		this.item_nodeal = item_nodeal;
//	}
//	public void setItem_hp(int item_hp) {
//		this.item_hp = item_hp;
//	}
//	public void setItem_mental(int item_mental) {
//		this.item_mental = item_mental;
//	}
//	public void setItem_img(String item_img) {
//		this.item_img = item_img;
//	}
//	public void setItem_memo(String item_memo) {
//		this.item_memo = item_memo;
//	}
	
	@Override
	public String toString() {
		return "MyItem [item_id=" + item_id + ", item_count=" + item_count + ", item_durability=" + item_durability
				+ "]";
	}
	
}
