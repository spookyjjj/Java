//2. 날짜 클래스 //필드: 연도 월 일 //메소드: "2022-05-27"와 "05/27/22"형태로 출력
class Date {
	int year;
	int month;
	int day;
	void dashfomat() {
		System.out.printf("%d-%d-%d\n", year, month, day);
	}
	String getYearTwoDigit() {
		return String.format("%02d", year % 100);
	}
	void slashfomat() {
		System.out.printf("%d/%d/%s\n", month, day, getYearTwoDigit());
	} //★메소드 안에서 자기가 만든 메소드 호출이 가능
}

public class TestDate {
	public static void main(String arg[]) {
		Date today = new Date();
		today.year = 2022;
		today.month = 05;
		today.day = 27;
		
		String year = today.getYearTwoDigit();
		System.out.println(year);
		
		today.dashfomat();
		today.slashfomat();
	}
}