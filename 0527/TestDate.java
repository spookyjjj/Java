//2. 날짜 클래스 //필드: 연도 월 일 //메소드: "2022-05-27"와 "05/27/22"형태로 출력
class Date {
	int year;
	int month;
	int day;
	void dashfomat() {
		System.out.printf("%d-%d-%d\n", year, month, day);
	}
	void slashfomat() {
		System.out.printf("%d/%d/%d\n", month, day, year);
	}
}

public class TestDate {
	public static void main(String arg[]) {
		Date today = new Date();
		today.year = 2022;
		today.month = 05;
		today.day = 27;
		today.dashfomat();
		today.slashfomat();
	}
}