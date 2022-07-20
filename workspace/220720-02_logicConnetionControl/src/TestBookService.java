
public class TestBookService {

	public static void main(String[] args) {
		BookService service = new BookService();
		service.setDao(new BookDaoParamConn());
		
//		service.insertAndUpdate("책", 9999);
		service.insertAndUpdate("중복이름", 8888); //오류 생기면 롤백하라고 해놨으니, 인서트 뿐만 아니라 업데이트까지도 적용 안됨
	}

}
