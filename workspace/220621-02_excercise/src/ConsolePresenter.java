import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsolePresenter {
	private DiaryManage manager;
	
	public ConsolePresenter() {
		manager = new DiaryManageImpl(); //업캐스팅~!
	}
	public void start() {
		while (true) {
			menu();
			Scanner scan = new Scanner(System.in);
			int number = scan.nextInt();
	
			switch (number) {
			case 1:
				add();
				break;
			case 2:
				list();
				break;
			case 3:
				edit();
				break;
			case 4:
				delete();
				break;
			default:
				System.out.println("없는 메뉴");
			}
		}
	}
	public void menu() {
		System.out.println("메뉴");
		System.out.println("1번. 추가, 2번. 목록, 3번. 수정, 4번. 삭제(오래된 거)");
	}
	
	public void add() {
		Scanner scan = new Scanner(System.in);
		System.out.println("날짜? yyyy-mm-dd 예)2022-06-21");
		String date = scan.nextLine();
		System.out.println("제목?");
		String title = scan.nextLine();
		System.out.println("날씨?");
		String weather = scan.nextLine();
		System.out.println("내용?");
		String content = scan.nextLine();
		
		LocalDate day = LocalDate.parse(date); //String으로 받은거 localdate로 변환~!
		
		manager.add(new DiaryT(day, title, weather, content));
	}
	
	public void list() {
		System.out.println("-일기 목록-");
		List<DiaryT> list = manager.list();
		for (DiaryT d : list) {
			System.out.println(d);
		}
	}
	
	public void edit() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 날짜?");
		String date = scan.nextLine();
		LocalDate day = LocalDate.parse(date);
		
		System.out.println("내용?");
		String content = scan.nextLine();
		
		manager.edit(day, content);
	}
	
	public void delete() {
		manager.deleteFirst();
		System.out.println("삭제 되었습니다");
	}
}
