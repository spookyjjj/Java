
public class ColorBox extends Box {
	String color;
	
	public ColorBox(int width, int length, int height, String color) {
		super(width, length, height);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}
