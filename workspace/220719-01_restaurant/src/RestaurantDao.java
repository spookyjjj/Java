import java.sql.SQLException;
import java.util.List;

public interface RestaurantDao {
	int create(String name, String tel, String address) throws SQLException;
	
	List<Restaurant> read() throws SQLException;
	Restaurant read(int id) throws SQLException;
	
	int update(int id, String name, String tel, String address) throws SQLException;
	
	int delete(int id) throws SQLException;
}
