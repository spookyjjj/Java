
public class Main3 {
	public static void main(String arg[]) {
		try {
			System.out.println("try 블록 안");
			System.out.println("문장1");
			System.out.println("문장2");
			
			Object o = new Object(); //예외발생! downcasting안되서
			String s =  (String) o;
			
			System.out.println("문장3");
			
		} catch (NullPointerException e) {
			System.out.println("catch 블록 안");
		} finally { //★예외가 발생하든지 말든지 맨마지막에 항상 실행되는 문장 +catch없이 try-finally만 있을수도있음!
			System.out.println("finally 블록 안");
		}
		System.out.println("프로그램 종료");
	}
}
