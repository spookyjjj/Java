import java.sql.Connection;
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
public class BookService {
	private BookDaoParamConn dao;

	public BookService() {
	}

	public void setDao(BookDaoParamConn dao) {
		this.dao = dao;
	}
	
	//신간이 추가되면 비슷한 이름을 가진 책 할인
	public void insertAndUpdate(String title, int price) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			dao.update(conn, "%" + title + "%", price);
			dao.insert(conn, title, price);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.closeConn(conn);
		}
		
	}
}
