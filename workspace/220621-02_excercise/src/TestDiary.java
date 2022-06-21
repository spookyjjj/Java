import java.time.LocalDate;

public class TestDiary {
	public static void main(String[] args) {
		DiaryT d1 = new DiaryT(LocalDate.of(2022, 6, 1), "소바를 먹었다", "흐림", "정말 늦게 나오네");
		d1.setWeather("맑음");
		System.out.println(d1.getWeather());
		
		System.out.println(d1);
		
		DiaryT d2 = new DiaryT(LocalDate.of(2022, 6, 1), "다른 제목", "맑음", "다른 내용");
		
//		System.out.println(d1.getDay().equals(d2.getDay())); //이렇게 해야할것을, DiaryT자체의 equals를 day로 해놓으면
		System.out.println(d1.equals(d2)); //이런식으로 사용가능
		System.out.println(d1.compareTo(d2)); //비교도!
	}
}
