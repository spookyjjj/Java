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
		} catch (Exception e) { //★나머지 예외들은 여기서
			System.out.println("모든 예외는 여기서 처리됩니다");
		} 
		
//		catch (Exception e) { //★catch의 순서가 중요! 위에서 부터 읽기 때문에 else역활은 젤 밑에서!
//			System.out.println("모든 예외는 여기서 처리됩니다");
//		} catch (NullPointerException e) {
//			System.out.println("널 포인트 익셉션 처리");
//		} catch (ArithmeticException e) {
//			System.out.println("수 익셉션 처리");
//		} 
		
		System.out.println("프로그램 종료");
	}

}
