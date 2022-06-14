//컵라면 클래스 [제조사, 이름, 가격] 생성자 게터세터
//override - toString equals(제조사와 이름이 같으면~ 가격은 달라도됨)
class CupNoodle {
	private String brand;
	private String name;
	private int price;
	
	public CupNoodle(String brand, String name, int price) {
		this.brand = brand;
		this.name = name;
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "CupNoodle [brand=" + brand + ", name=" + name + ", price=" + price + "]";
	}
	
//	@Override
//	public boolean equals(Object obj) { //빠른 생성으로 완성한 equals! -> return은 break도 내재하고 있으니, else if를 안쓴거임~
//		if (this == obj) //자기자신이 비교대상일 경우도 상정
//			return true;
//		if (!(obj instanceof CupNoodle))
//			return false;
//		CupNoodle other = (CupNoodle) obj;
//		if (brand == null) { //null값이 있는 경우도 상정
//			if (other.brand != null) 
//				return false;
//		} else if (!brand.equals(other.brand))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true; //false case들 다 걸러냈는데도 여기까지 왔으면, true임
//	}
	
	@Override
	public boolean equals(Object obj) { //a.equals(b)형태의 메소드
		if (obj instanceof CupNoodle) { //b는 호출시 외부에서 가져온 객체인데 getBrand안쓰고도 private한 brand에 접근할 수 있는 이유?
										//->b도 결국 CupNoodle객체가 되었고, 전부 CupNoodle클래스 안에서 일어나는 일이니깐,, 주체가 a든 b든 내부의 일
			return (brand.equals(((CupNoodle) obj).brand)) && (name.equals(((CupNoodle) obj).name)); 
		} else {
			return false;
		}
	}
	
	
}

public class Main {
	public static void main(String args[]) {
		CupNoodle p1 = new CupNoodle("삼양", "불닭볶음면", 1700);
		CupNoodle p2 = new CupNoodle("삼양", "로제불닭볶음면", 1700);
		CupNoodle p3 = new CupNoodle("농심", "신라면", 900);
		CupNoodle p4 = new CupNoodle("농심", "너구리", 1000);
		CupNoodle p5 = new CupNoodle("농심", "신라면", 1800);
		CupNoodle p6 = new CupNoodle("농심", "불닭볶음면", 1700);
		
		System.out.println(p3.toString());
		System.out.println(p5.toString());
		System.out.println(p3.equals(p5));
		System.out.println(p1.equals(p6));
		
	}
}
