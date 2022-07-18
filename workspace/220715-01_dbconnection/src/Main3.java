import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3 {
	public static Connection makeConnection() { // 매번 반복되니깐 걍 static 메소드로 만듬
		String url = "jdbc:mysql://localhost:3306/my_db";
		String id = "root";
		String password = "root";

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static int insertBook(String title, int price) { // main2에서 책추가 했던 내용 자체를 메소드로 만듬
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			result = stmt.executeUpdate("insert into book (title, price) " 
			 + "values ('" + title + "', " + price + ");"); // 실행한 행의  값이 출력이 된다!
			System.out.println(result + "행이 추가되었습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void selectAllBook() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // select명령으로 받아온걸 여기에 담음
		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from book;"); //select는 executQuery를 쓴다!!
			// rs.next(); -> ★한번 호출 할 때 마다 한 행씩 선택하는 거임!! 다음줄 있으면 t / 없으면 f
			// 즉, rs.next();rs.next();rs.next();하고 getInt("bookid");하면 바로 3번째 행의 id가 나옴 
			while (rs.next()) {
				int id = rs.getInt("bookid"); //get을 해서 뽑아내야 다음 행으로 넘어감
				String title = rs.getString("title");
				int price = rs.getInt("price");
				
				System.out.println(id + ", " + title + ", " + price);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {

				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
//		insertBook("메소드로 추가한 새책", 20000);
		selectAllBook();
	}

}
