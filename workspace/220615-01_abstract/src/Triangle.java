
public class Triangle extends Shape { //추상클래스는 부모가 되기 위해서 존재한것
	private int base;
	private int height;
	
	public Triangle(int x, int y, int base, int height) {
		super(x, y);
		this.base = base;
		this.height = height;
	}
	
	@Override //★부모의 추상메소드를 자식이 구체화 해줘야만함! "구현한다"
	public int getArea() { //abstract 빼고, body만들어주기
		return base * height / 2;
	}
	public int getBase() {
		return base;
	}
	public int getHeight() {
		return height;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	
}
