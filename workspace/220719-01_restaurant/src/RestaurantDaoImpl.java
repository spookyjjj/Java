import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.dbutil.DBUtil;

public class RestaurantDaoImpl implements RestaurantDao {
	private Restaurant resultMapping(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String tel = rs.getString("tel");
		String address = rs.getString("address");
		
		return new Restaurant(id, name, tel, address);
	}
	
	@Override
	public int create(String name, String tel, String address) throws SQLException {
		String query = "INSERT INTO restaurant (name, tel, address) VALUES (?, ?, ?)"; //for PreparedStatement
		//'?'를 쓰면 문자열이라도 홑따옴표조차 필요없다
		
		Connection conn = null;
		PreparedStatement pstmt = null; //'?' 채울수 있는 애
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query); //connection에서 .prepareStatement(★query문장);으로 가져옴!
			//걍 statement는 connection에서 .createStatement();
			
			pstmt.setString(1, name); //1번째 물음표에 String값인 name들어간다
			pstmt.setString(2, tel); //2번째 물음표에 String값인 tel들어간다
			pstmt.setString(3, address); //3번째 물음표에 String값인 address들어간다
		
			return pstmt.executeUpdate(); //실행시에 파라미터로 전해줄 게 없음. 앞에서 다 준비해놨으니깐
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		
	}
	
	public int[] create(List<Restaurant> list) throws SQLException { //배치작업을 통해 해결하기!
		String query = "insert into restaurant (name, tel, address) values (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			
			for (Restaurant r : list) {
				pstmt.setString(1, r.getName());
				pstmt.setString(2, r.getTel());
				pstmt.setString(3, r.getAddress());
				pstmt.addBatch(); 
			}
			
			return pstmt.executeBatch(); //완료되면 배열의 형태로 리턴한다! ex) {1,1,1,1}
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
	}

	@ Override
	public List<Restaurant> read() throws SQLException {
		String query = "SELECT * FROM restaurants";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Restaurant> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(resultMapping(rs));
			}
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return list;
	}

	@Override
	public Restaurant read(int id) throws SQLException {
		String query = "select * from restaurant where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null; //'?' 채울수 있는 애
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query); //connection에서 .prepareStatement(★query문장);으로 가져옴!
			//걍 statement는 connection에서 .createStatement();
			pstmt.setInt(1, id); //1번째 물음표에 String값인 name들어간다
			rs = pstmt.executeQuery(); //실행시에 파라미터로 전해줄 게 없음. 앞에서 다 준비해놨으니깐
			if (rs.next()) {
				return resultMapping(rs);
			}
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return null;
	}

	@Override
	public int update(int id, String name, String tel, String address) throws SQLException {
		String query = "update restaurant set name = ?, tel = ?, address = ? where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  name);
			pstmt.setString(2,  tel);
			pstmt.setString(3,  address);
			pstmt.setInt(4, id);
			
			return pstmt.executeUpdate();
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
	}

	@Override
	public int delete(int id) throws SQLException {
		String query = "delete from restaurant where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  id);
			
			return pstmt.executeUpdate();
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
	}

}
