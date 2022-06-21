import java.time.LocalDate;

public class TestManage {
	public static void main(String[] args) {
		DiaryManage m = new DiaryManageImpl();
		
		m.add(new DiaryT(LocalDate.now(), "6월21일 일기", "맑음", "적을 말이 없네"));
		
		m.add(new DiaryT(LocalDate.of(2022, 6, 20), "6월20일 일기", "맑음", "내용 내용2"));
		
		m.add(new DiaryT(LocalDate.of(2022, 6, 19), "6월19일 일기", "흐림", "내용 내용3"));
		
		System.out.println(m.list());
		
		m.edit(LocalDate.now(), "수정된 내용");
		
		System.out.println(m.list().get(0).getContent());
		
		m.deleteFirst();
		
		System.out.println(m.list().size());
	}
}
