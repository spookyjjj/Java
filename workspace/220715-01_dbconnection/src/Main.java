import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		Connection conn = null; //애는 연결만하고, 명령어 날려주는건 Statement에서~
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //패키지와 클래스 이름을 써넣으면 된다. 이건 드라이버마다 다르다 -> 회사마다 다르다
			// 이게 DriverManager에서는 com.mysql.cj.jdbc.Driver을 인식해서 내가 하는 짓을 알아서 mysql것으로 연결해줌
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
			
			//table a : 칼럼 b varchar(10) pk
			String query = "create table a (b varchar(10) primary key);";
			stmt = conn.createStatement(); // statement객체는 connection객체에서 얻어낸다
//			stmt.executeUpdate(query); // select 빼고는 얘가 다 한다고 think
			//table a drop하기
			String query2 = "drop table a";
			stmt.executeUpdate(query2);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //닫는 순서는 반대!! connection부터 열었으니 나중에 닫아줘야함
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
