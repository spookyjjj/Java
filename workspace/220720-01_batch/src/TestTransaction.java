import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.greenart.dbutil.DBUtil;

public class TestTransaction {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false); //★여기서 오토커밋 끌 수 있음 기본적으로 true임
			
			pstmt = conn.prepareStatement("insert into book (title, price) values (?, ?)");
			pstmt2 = conn.prepareStatement("update book set title = ?, price = ? where title = ?");
			
			for (int i = 0; i < 5; i++) {
				pstmt.setString(1,  i + "번째 책");
				pstmt.setInt(2, 1000 + i);
				pstmt.addBatch();
			}
			//이까지는 오토 커밋이라 에러 발생 안했으면 바로바로 적용됨
			
			//아래의 책2는 이미 기존에 있는 책 이름이라 unique에 위배되는 변화임~
			pstmt2.setString(1, "책2"); //에러발생되어서 여기서 부터는 또 적용 안됨 -> 뒤죽박죽임
			pstmt2.setInt(2, 50000);
			pstmt2.setString(3, "1번째 책");
			
			pstmt.executeBatch();
			pstmt2.executeUpdate();
			//★★그래서, 과정중 에러가 발생하면 그 과정 전체가 다 적용 안되게끔 오토커밋을 꺼주는게 필요하다~!
			
			conn.commit(); //★여기까지 도달했으면 오류 없었던거니 진행시켜~
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("롤백합니다");
			try {
				conn.rollback(); //★에러 발생시 롤백시키기!!
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeStmt(pstmt2);
			DBUtil.closeConn(conn);
		}
		
	}

}
