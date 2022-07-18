
public class Restaurant {
	private int id;
	private String name;
	private String tel;
	private String address;
	
	public Restaurant (String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	public Restaurant (int id, String name, String tel, String address) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", tel=" + tel + ", address=" + address + "]";
	}
}
