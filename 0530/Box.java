class Box {
	int width;
	int length;
	int height;
	
	//생성자 만들기
	public Box(int w, int l, int h) {
		width = w;
		length = l;
		height = h;
	}
	//생성자 하나라도 만든 후에는 자동생성자 역할 할 것을 따로 만들어줘야함
	public Box() { //기본값 0 0 0 
	}
	// public Box() { //기본값 1 1 1 
		// width = 1;
		// length = 1;
		// height = 1;
	// }
	
	public static void main(String arg[]) {
		Box b = new Box(50, 60, 70);
		System.out.println(b.width);
		System.out.println(b.length);
		System.out.println(b.height);
		
		Box b2 = new Box(90, 100, 110);
		
		Box b3 = new Box();
		System.out.println(b3.width);
		System.out.println(b3.length);
		System.out.println(b3.height);
	}
}

