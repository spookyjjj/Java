import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.co.greenart.dbutil.DBUtil;
//DBUtil을 자르파일 만들어서 데리고 온게 아니라 걍 프로젝트 자체를 데려와서 씀!
//소스코드에 변화가 있을 때 마다 자르파일 만들어서 변경해주는 절차가 필요없이 바로 변경된 소스코드를 받아옴
public class TestConn {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select 1;");
			
			if (rs.next()) {
				int result = rs.getInt(1); //여기에서의 1은 칼럼이름 '1'이 아니라 1번째 칼럼이라는 뜻!!
				System.out.println("확인: " + result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

}
