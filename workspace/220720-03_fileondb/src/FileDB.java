import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.greenart.dbutil.DBUtil;

public class FileDB { //DB에서는 모든게 테이블의 row로 존재한다! -> 파일 담을 테이블 준비 필요 type은 blob
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//파일 db에서 가져오기
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from files where id = ?");
			pstmt.setInt(1, 1000);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Blob file = rs.getBlob("file"); //010101..형태로 담겨있다
				//Blob을 읽어낼 inputStream 필요 -> inpurStream을 출력할 outPutStream필요
				
				InputStream inputStream = file.getBinaryStream();
				FileOutputStream fos = new FileOutputStream(new File("다운로드받은거.png"));
				
				int b = 0; //int데이터로 받는다
				while ((b = inputStream.read()) != -1) { //b의 값이 -1이면 없는거니깐 그만함
					fos.write(b);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		
		//파일 db에 올리기
//		try {
//			conn = DBUtil.getConnection();
//			pstmt = conn.prepareStatement("insert into files (id, name, file) values(?, ?, ?)");
//			pstmt.setInt(1, 1000);
//			pstmt.setString(2, "파일이름");
//			pstmt.setBlob(3, new FileInputStream(new File("너무귀여움.png"))); //★★db에 보낼 때, inputStream을 쓴다는것!!
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.closeStmt(pstmt);
//			DBUtil.closeConn(conn);
//		}
	}
}
