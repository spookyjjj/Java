public class MethodRefparam {
	
	public static String concat(String left, String right) {
		return left + right; 
	}
	
	public static void main(String args[]) {
		String h = "Hello";
		String w = "World";
		String result = concat(h, w); //참조형의 경우, h와 w가 가진 화살표(값의 주소)가 복사가 되어 concat메소드로 들어간다
		System.out.println(result);
	}
}