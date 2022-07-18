import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.co.greenart.dbutil.DBUtil;

/*
 *  my_db.book
 * 
 *  도서관리프로그램
 *  
 *  추가
 *  전체목록
 *  (아이디나 제목, 가격 등으로 검색가능)
 * 	삭제
 *  수정
 * 
 *  데이터베이스와 연동시켜주세요
 */
//class book {
//	private int id;
//	private String title;
//	private int price;
//
//	public book(int id, String title, int price) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.price = price;
//	}
//
//	@Override
//	public String toString() {
//		return "[id: " + id + ", 제목: " + title + ", 가격: " + price + "]";
//	}
//
//}

public class BookManager {

	private int menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("도서관리프로그램");
		System.out.println("1. 목록보기");
		System.out.println("2. 도서추가");
		System.out.println("3. 도서정보수정");
		System.out.println("4. 도서삭제");
		System.out.println("5. 도서검색");
		System.out.println("9. 프로그램 종료");
		int push = scan.nextInt();
		scan.nextLine();
		return push;
	}

	private void pushTomethod(int push) {
		Scanner scan = new Scanner(System.in);
		if (push == 1) {
			showAllBook();
		} else if (push == 2) {
			System.out.println("책제목?");
			String title = scan.nextLine();
			System.out.println("가격?");
			int price = scan.nextInt();
			scan.nextLine();
			addBook(title, price);
		} else if (push == 3) {
			System.out.println("수정할 도서의 id?");
			int id = scan.nextInt();
			scan.nextLine();
			System.out.println("수정할 항목?");
			System.out.println("1. 책제목수정");
			System.out.println("2. 가격수정");
			int select = scan.nextInt();
			scan.nextLine();
			System.out.println("수정할 내용?");
			String s = scan.nextLine();
			editBook(id, select, s);
		} else if (push == 4) {
			System.out.println("삭제할 도서의 id?");
			int id = scan.nextInt();
			scan.nextLine();
			deleteBook(id);
		} else if (push == 5) {
			// 도서검색
			System.out.println("검색할 항목?");
			System.out.println("1. id로 찾기");
			System.out.println("2. 제목으로 찾기");
			System.out.println("3. 가격으로 찾기");
			int select = scan.nextInt();
			scan.nextLine();
			System.out.println("검색 내용?");
			String s = scan.nextLine();
			searchBook(select, s);
		} else if (push == 9) {
			System.out.println("프로그램 종료");
		} else {
			System.out.println("없는 번호를 선택하셨습니다");
		}
	}

	private void showAllBook() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from book;"); // select는 executQuery를 쓴다!!
			while (rs.next()) {
				int id = rs.getInt("bookid"); // get을 해서 뽑아내야 다음 행으로 넘어감
				String title = rs.getString("title");
				int price = rs.getInt("price");

				System.out.println(id + ", " + title + ", " + price);
			}
		} catch (SQLException e) {
			System.out.println("목록보기 중 에러발생");
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	private void addBook(String title, int price) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into book (title, price) values ('" + title + "', " + price + ");"); // 실행한 행의 값이
																											// 출력이 된다!
			System.out.println(title + " 추가되었습니다");
		} catch (SQLException e) {
			System.out.println("책 추가 중 에러발생");
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	private void editBook(int id, int select, String s) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			if (select == 1) {
				stmt.executeUpdate("update book set title = '" + s + "' where bookid = " + id + ";");
				System.out.println(id + "번 도서의 제목이 변경되었습니다");
			} else if (select == 2) {
				stmt.executeUpdate("update book set price = " + Integer.valueOf(s) + " where bookid = " + id + ";");
				System.out.println(id + "번 도서의 가격이 변경되었습니다");
			} else {
				System.out.println("없는 항목을 수정 할 수는 없습니다");
			}

		} catch (SQLException e) {
			System.out.println("수정중 에러발생");
			e.printStackTrace();
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	private void deleteBook(int id) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("delet from book where bookId = " + id + ");"); // 실행한 행의 값이 출력이 된다!
			System.out.println(id + "번 도서가 삭제되었습니다");
		} catch (SQLException e) {
			System.out.println("삭제중 에러발생");
		} finally {
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	private void searchBook(int select, String s) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			if (select == 1) {
				// id로찾기
				rs = stmt.executeQuery("select * from book where id = " + Integer.valueOf(s) + ";");
				while (rs.next()) {
					int id = rs.getInt("bookid");
					String title = rs.getString("title");
					int price = rs.getInt("price");
					System.out.println(id + ", " + title + ", " + price);
				}
			} else if (select == 2) {
				// title로 찾기
				rs = stmt.executeQuery("select * from book where title = like '%" + s + "%';");
				while (rs.next()) {
					int id = rs.getInt("bookid");
					String title = rs.getString("title");
					int price = rs.getInt("price");
					System.out.println(id + ", " + title + ", " + price);
				}
			} else if (select == 3) {
				// price로 찾기
				rs = stmt.executeQuery("select * from book where price = " + Integer.valueOf(s) + ";");
				while (rs.next()) {
					int id = rs.getInt("bookid"); // get을 해서 뽑아내야 다음 행으로 넘어감
					String title = rs.getString("title");
					int price = rs.getInt("price");
					System.out.println(id + ", " + title + ", " + price);
				}
			} else {
				System.out.println("없는 항목입니다");
			}

		} catch (SQLException e) {
			System.out.println("검색과정중 에러발생");
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeStmt(stmt);
			DBUtil.closeConn(conn);
		}
	}

	public static void main(String args[]) {
		BookManager bm = new BookManager();
		int push = 0;
		while (push != 9) {
			try {
				push = bm.menu();
				bm.pushTomethod(push);
			} catch (Exception e) {
				System.out.println("바른 입력을 하세요");
			}
		}
	}
}
