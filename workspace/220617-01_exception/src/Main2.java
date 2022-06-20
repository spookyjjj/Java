//2개의 예외처리
public class Main2 {

	public static void main(String[] args) {
		String s = null;
		try {
			int div = 10 / 0;
			s.equals("asdf");
		} catch (NullPointerException e) {
			System.out.println("널 포인트 익셉션 처리");
		} catch (ArithmeticException e) {
			System.out.println("수 익셉션 처리");
		} catch (Exception e) { //★나머지 예외들은 여기서 upcasting임~!
			System.out.println("모든 예외는 여기서 처리됩니다");
		} 
		
//		catch (Exception e) { //★catch의 순서가 중요! 위에서 부터 읽기 때문에 다 잡아내는 super Exception은 밑에서,,
//			System.out.println("모든 예외는 여기서 처리됩니다");
//		} catch (NullPointerException e) { //순서 이딴식이면,,,밑에 예외처리는 도달하지 못하게 되므로 컴파일 에러
//			System.out.println("널 포인트 익셉션 처리");
//		} catch (ArithmeticException e) { 
//			System.out.println("수 익셉션 처리");
//		} 
		
		System.out.println("프로그램 종료");
	}

}
