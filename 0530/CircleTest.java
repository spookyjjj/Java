class Point {
	private int x, y; 
	
	public Point(int a, int b) {
		x = a;
		y = b;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}

class Circle {
	private int radius = 0; 
	private Point center; //center라는 이름의 Point타입 박스 생성
	
	//생성자
	public Circle(Point p, int r) { //파라미터 자체가 Point타입
		center = p;
		radius = r;
	}
	
	//★★다른 클래스(객체)를 이 클래스(객체)와 연결시키기~!!
	public Point getCenter() {
		return center; //center가 Point타입이니깐 void(X), int(X), Point(O)
	}
	public void setPoint(Point p) {
		center = p;
	}
}

public class CircleTest{ 
	public static void main(String args[]) {
		//Circle객체를 생성하고 초기화한다
		Point p = new Point(25, 78);
		Circle c = new Circle(p, 10); //Circle객체를 생성할 때, Point객체 참조값을 넘긴다
		
		System.out.println(c.getCenter()); //참조형들은 내용을 지네만의 문자열화시켜서 기억하고있음
		
		System.out.println(c.getX()); //c는 Circle타입이라서 getX()할 수 없다
		System.out.println(c.getCenter().getX()); //c.getCenter()해서 Point타입으로 받아낸 후에 getX()을 함
		System.out.println(c.getCenter().getY());
	}
}