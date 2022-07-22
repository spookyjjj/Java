import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		//접속할 준비를 위한 문자열들
		String url = "jdbc:mysql://localhost:3306/world"; //mySQL의 주소~
		String id = "root";
		String password = "root";
		
		//드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //패키지와 클래스를 나타낸 문자열 -> 해당 클래스 로드를 위해서
			System.out.println("드라이버 적재 성공");
		} catch (ClassNotFoundException e) { //checked예외라서 try catch 해줘야 함
			System.out.println("드라이버를 찾을 수 없습니다");
			System.out.println(e.getMessage());
		}
		
		//데이터베이스에 접속
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) { //checked예외라서 try catch 해줘야 함
			System.out.println("데이터베이스 연결에 실패하였습니다");
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close(); //로그인 했으면 로그아웃 해줘야한다~ 그게 close임
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
