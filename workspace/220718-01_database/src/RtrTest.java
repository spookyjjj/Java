import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * restaurants 테이블에 대한 db access를 수행하는 객체를 작성해 보세요. 작성 후 테스트!
 * 
 * 메소드(입력값) : 반환값							throws 예외
 * 
 * C(상호명, 전화번호, 주소) or C(음식점) : 행 개수 		throws SQLException
 * R() : List<음식점>						 		throws SQLException //read
 * R(id) : 음식점						 			throws SQLException
 * U(id, 새상호, 새전번, 새주소) or U(음식점) : 행개수	throws SQLException
 * D(id) : 행 개수								 	throws SQLException
 * 
 * -------
 * 여러행의 음식점 추가
 */


public class RtrTest {
	public static void main(String args[]) {
		RtrDB a = new RtrDB();
		try {
			//list test
//			List<Restaurant> list = a.list();
//			for (Restaurant r : list) {
//				System.out.println(r);
//			}
			
			//add(name, tel, address) test
			System.out.println(a.add("새음식점", "또새전번", "또새주소") == 1);
			
			//add(Restaurant) test
//			Restaurant r = new Restaurant(100, "여기가자", "전번은?", "주소는?");
//			System.out.println(a.add(r) == 1);
			
			//add(list) test
//			List<Restaurant> list = new ArrayList<>(Arrays.asList(new Restaurant(50, "h", "g", "o"), new Restaurant(51, "j", "i", "y"), new Restaurant(52, "r", "w", "g")));
//			System.out.println(a.add(list) == 3);
			
			//delete(id) test
//			System.out.println(a.delete(101) == 1);
//			System.out.println(a.delete(102) == 1);
//			System.out.println(a.delete(103) == 1);
		} catch(SQLException e) {
			System.out.println("에러발생");
			System.out.println(e.getMessage());
		}
	}
}
