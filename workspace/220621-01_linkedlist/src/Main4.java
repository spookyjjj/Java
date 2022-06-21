import java.util.ArrayList;
import java.util.List;

class Point2D {
	private int x;
	private int y;
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}


public class Main4 {

	public static void main(String[] args) {
		List<Point2D> list = new ArrayList<>();
		//0,0좌표 추가~
		list.add(new Point2D(0, 0));
		//5,5좌표 추가~
		list.add(new Point2D(5, 5));
		
		System.out.println(list);
		
		//좌표출력?
		Point2D p = list.get(0);
		System.out.println(p);
		Point2D p2 = list.get(1);
		System.out.println(p2);
		
		//리스트에 0.0좌표객체가 있는지??
		System.out.println(list.contains(new Point2D(0, 0))); //contains는 equals를 따짐!-> x,y값이 같을때를 equals하다고 재정의 해줘야 원하는 결과~
		//리스트에 0.0좌표객체의 인덱스는??
		System.out.println(list.indexOf(new Point2D(0, 0))); //indexOf도 equals따짐!-> 원하는 대로 equals재정의 필요!
		
		//찾아서 지우기??
		System.out.println(list.remove(new Point2D(5, 5))); //지울게 있을 때 true, 지울거 없으면 false
		System.out.println(list);
	}

}
