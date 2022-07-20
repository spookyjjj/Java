import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.greenart.dbutil.DBUtil;
//public void 로직1() {
//		//로직 안에서 커넥션을 열고 닫고 하면서 트렌젝션도 제어하는게 베스트!!
//		커넥션 열고
//		트렌젝션 제어
//		dao.add(커넥션)
//		dao.delete(커넥션)
//		dao.update(커넥션)
//		커밋
//		--예외면 롤백
//		커넥션 닫기
//	}
public class BookDaoParamConn {
	public int update(Connection conn, String title, int price) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("update book set price = ? where title like ?");
			pstmt.setInt(1, price);
			pstmt.setString(2, title);
			return pstmt.executeUpdate();
		} finally {
			DBUtil.closeStmt(pstmt);
		}
	}
	
	public int insert(Connection conn, String title, int price) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into book (title, price) values (?, ?)");
			pstmt.setString(1, title);
			pstmt.setInt(2, price);
			return pstmt.executeUpdate();
		} finally {
			DBUtil.closeStmt(pstmt);
		}
	}
	
	public int delete(Connection conn, int bookid) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("delete from book where bookid = ?");
			pstmt.setInt(1, bookid);
			return pstmt.executeUpdate();
		} finally {
			DBUtil.closeStmt(pstmt);
		}
	}
}
