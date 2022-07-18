import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.dbutil.DBUtil;

public class BookManagerT {

	// 추가
	public int add(BookT book) throws SQLException { // ★메인메소드로 던져주면 메인메소드에서 e의 정보를 조회할 수 있다~~
		// 책추가만 하는 메소드. 결과는 무조건 int로만 알려줄거임. 따라서 모든 상황에 대한 인트가 있어야함. 1행추가 1, 추가안됨 0, 서버가
		// 안되서 안되었다 x, 중복되어서 안되었다 y...
		// 이걸 모두 일일이 다 설정해 줄 수 없다!!! 따라서!! 1, 0 외에는 그냥 모든 예외 정보를 담고있는(에러코드별로 모든 에러상황이 다
		// 있음) 예외객체를 활용~ 메소드에서 받아가게 던져주기만 하면됨
		String query = "INSERT INTO book (title, price) VALUES ('" + book.getTitle() + "', " + book.getPrice() + ")";
		System.out.println("추가: " + query);

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			return stmt.executeUpdate(query); // 되면 1 안되면 0
		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("중복되서 안됩니다"); //여기서 마무리 지어버리면, 메인메소드에서는 e의 정보를 조회할 수가 없음!! -> throws ㄱㄱ
//		}
		finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	// 목록 전체
	public List<BookT> list() throws SQLException {
		String query = "SELECT * FROM book";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BookT> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				// 밑에서 계속 반복되니깐 아예 메소드로 만들어버림
//				int bookId = rs.getInt("bookid");
//				String title = rs.getString("title");
//				int price = rs.getInt("price");
//				
//				list.add(new BookT(bookId, title, price));
				list.add(ResultMapping(rs));
			}
			return list; // finally위에 return이 있어도 finally는 무조건 일어나야하니깐, finally하고 return한다~

		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	// 검색 (제목)
	public BookT selectByTitle(String title) throws SQLException { // 제목에 unique속성 붙어있으니 검색되는 책은 단 하나
		String query = "SELECT * FROM book WHERE title = '" + title + "';";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			if (rs.next()) {
				// 이부분 위에서 부분과 계속 반복되니깐 메소드로 아예 만들어버림
//				int bookId = rs.getInt("bookid");
//				String tt = rs.getString("title");
//				int price = rs.getInt("price");
//				
//				return new BookT(bookId, tt, price);
				return ResultMapping(rs);
			}
			return null; 
			//1. 아예 null로 반환하거나
			//2. BookT인데 기본값(0, null, 0)인 애를 반환하거나
			//3. 혹은 아예 예외로 만들어서 throw하거나

		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	// 계속 반복되는 부분이라 메소드로 만들어줌
	public BookT ResultMapping(ResultSet rs) throws SQLException {
		int bookId = rs.getInt("bookid");
		String title = rs.getString("title");
		int price = rs.getInt("price");

		return new BookT(bookId, title, price);
	}

	// 검색 (가격)
	public List<BookT> selectByPrice(int price) throws SQLException { // 가격에는 unique속성 없으니 검색되는 책 여러개일 수도..
		String query = "SELECT * FROM book WHERE price = " + price + ";";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BookT> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				list.add(ResultMapping(rs));
			}
			return list;

		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	// 삭제
	public int delete(int bookId) throws SQLException {
		String query = "DELETE FROM book WHERE bookId = " + bookId;

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			return stmt.executeUpdate(query);
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	// 수정
	public int update(BookT book) throws SQLException {
		String query = "UPDATE book SET title = '" + book.getTitle()
			+ "', price = " + book.getPrice()
			+ " WHERE bookid = " + book.getBookId();
		
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			return stmt.executeUpdate(query);
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

}
