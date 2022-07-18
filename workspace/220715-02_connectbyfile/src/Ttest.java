import java.sql.SQLException;
import java.util.List;

public class Ttest {
	public static void main(String[] args) {
		BookManagerT bmt = new BookManagerT();
		int result;
		try {
//			result = bmt.add(new BookT("테스트용 책123", 55000));
//			System.out.println("추가 확인 : " + (result == 1));
			
//			List<BookT> list = bmt.list();
//			System.out.println(list);
			
//			BookT book = bmt.selectByTitle("잘가");
//			System.out.println(book);
			
//			List<BookT> list = bmt.selectByPrice(4500);
//			System.out.println(list);
			
//			result = bmt.delete(20);
//			System.out.println("삭제 확인 : " + (result == 1));
			
			result = bmt.update(new BookT(5, "선생님풀이로 수정한 책이름", 55000));
			System.out.println("수정확인: " + (result == 1));
			BookT book = bmt.selectByTitle("선생님풀이로 수정한 책이름");
			System.out.println(book);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
