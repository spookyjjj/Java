public class TestString2 {
	public static void main(String args[]) {
		String hello = "Hello"; //내부에 index를 가지며, 0부터 시작한다~!!
		
		char h = hello.charAt(0); //String안에 charAt이라는 메소드 (Scanner의 nextInt와 마찬가지) 
		System.out.println(h);
		System.out.println(hello.charAt(1));
		System.out.println(hello.charAt(2));
		System.out.println(hello.charAt(3));
		System.out.println(hello.charAt(4)); //음수나 index를 초과하는 값을 입력하면 컴파일 에러
		
		int length = hello.length();
		System.out.println(length); //String안에 length이라는 메소드
		
		String hello1 = "H l o";
		System.out.println(hello1.length()); //=5, 띄어쓰기도 하나의 index가짐
		String hello2 = "H \n o";
		System.out.println(hello2.length()); //=5, \n은 두글자지만 하나의 index가짐
	}
}