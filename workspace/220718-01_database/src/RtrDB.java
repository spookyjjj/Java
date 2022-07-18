import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.dbutil.DBUtil;

public class RtrDB {
	public int add(Restaurant r) throws SQLException{
		String query = "insert into restaurant (id, name, tel, address) values ('" + r.getId() + "', '" + r.getName() + "', '" + r.getTel() + "', '" + r.getAddress() + "')";

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			return stmt.executeUpdate(query); // 되면 1 안되면 0
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}
	public int add(String name, String tel, String address) throws SQLException{
		String query = "insert into restaurant (name, tel, address) values ('" + name + "', '" + tel + "', '" + address + "')";

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			return stmt.executeUpdate(query); // 되면 1 안되면 0
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}
	public int add(List<Restaurant> l) throws SQLException{
		String query;
		int count = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			for (Restaurant r : l) {
				query = "insert into restaurant (id, name, tel, address) values ('" + r.getId() + "', '" + r.getName() + "', '" + r.getTel() + "', '" + r.getAddress() + "')";
				count += stmt.executeUpdate(query); // 되면 1 안되면 0
			}
			return count;
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}
	
	public List<Restaurant> list() throws SQLException {
		String query = "select * from restaurant";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Restaurant> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				
				list.add(new Restaurant(id, name, tel, address));
			}
			return list;

		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}
	
	public Restaurant searchById(int id) throws SQLException { //해당 id가진거 오직 단 하나
		String query = "select * from restaurant where id = " + id;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			if (rs.next()) {
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				
				return new Restaurant(id, name, tel, address);
			} else {
				return null;
			}


		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}
	
	public int updateById(Restaurant r) throws SQLException {
		String query = "update restaurant set name = '" + r.getName() + "', tel = '" + r.getTel() + "', address = '" + r.getAddress() + "' where id = " + r.getId();
	
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			return stmt.executeUpdate(query); // 되면 1 안되면 0
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}
	
	public int delete(int id) throws SQLException {
		String query = "delete from restaurant where id = " + id;
		
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			return stmt.executeUpdate(query); // 되면 1 안되면 0
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	} 
}
