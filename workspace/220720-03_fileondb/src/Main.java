import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.greenart.dbutil.DBUtil;

public class Main {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("")) { // 오토클로저블 구현체를 try 괄호 안에 넣어주면, 영역이 끝나면 자동으로 close!

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select ");) { // 여러개도 가능
			// 단, 오토클로저블을 구현하고 있어야 하며, 선언과 초기화만 됨
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
