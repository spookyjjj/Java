import java.sql.SQLException;
import java.util.Arrays;

public class TestRestaurantDao {

	public static void main(String[] args) {
		RestaurantDao dao = new RestaurantDaoImpl();
		
		try {
//			int result = dao.create("테스트중", "1234-5678", "부산 어쩌구");
//			System.out.println(result == 1);
			
//			System.out.println(dao.read(5));
			
//			int result = dao.update(50, "qw", "er", "ty");
//			System.out.println(result == 1);
			
//			int result = dao.delete(52);
//			System.out.println(result == 1);
			
			RestaurantDaoImpl impl = (RestaurantDaoImpl) dao; //다운캐스팅해야 인터페이스꺼가 아닌 이 클래스만의 메소드 쓸 수 있음
			int[] result = impl.create(Arrays.asList(
					new Restaurant(0, "배치1", "0101-0202", "배치주소1"),  //안쓰는 값이라서 0으로 걍 처리해줌
					new Restaurant(0, "배치2", "0101-0203", "배치주소2"), 
					new Restaurant(0, "배치3", "0101-0204", "배치주소3"), 
					new Restaurant(0, "배치4", "0101-0205", "배치주소4")
					));
			System.out.println(Arrays.toString(result));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
