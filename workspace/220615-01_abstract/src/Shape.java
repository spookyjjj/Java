//삼각형
//중심점(x,y)
//밑변
//높이
//넓이 구해서 알려줄 수 있다

//직사각형
//중심점(x,y)
//가로
//세로
//넓이 구해서 알려줄 수 있다

//원
//중심점(x,y)
//반지름
//넓이 구해서 알려줄 수 있다
public abstract class Shape { //추상클래스 -> 상하구조를 위해서만 존재
	private int x;
	private int y;
	
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//추상메소드 -> body가 없다!
	public abstract int getArea();
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Shape [x=" + x + ", y=" + y + "]";
	}
}
