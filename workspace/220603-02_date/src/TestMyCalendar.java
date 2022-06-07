import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class MyCalendar {
	Scanner scan = new Scanner(System.in);
	LocalDate today;
	
	public void makeToday() {
		today = LocalDate.of(yearInput(), monthInput(), dayInput());
	}
	private int yearInput() {
		System.out.println("년도를 입력하십시오");
		return scan.nextInt();
	}
	private int monthInput() {
		System.out.println("월을 입력하십시오");
		return scan.nextInt();
	}
	private int dayInput() {
		System.out.println("날짜를 입력하십시오");
		return scan.nextInt();
	}
	public void showCalendar() {
		line1();
		line2();
		line3();
	}
	
	private void line1() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd E");
		System.out.println("오늘: " + dateFormat.format(today));
	}
	private void line2() {
		System.out.println("일   "+ "월   "+ " 화   "+ " 수   " +" 목   " + " 금   " + " 토   ");
	}
	private int get1st() {
		return LocalDate.of(today.getYear(), today.getMonthValue(), 1).getDayOfWeek().getValue();
	}
	//---------선생님 답안---------
	//LocalDate firstDay = LocalDate.of(today.getYear(), today.getMonthValue(), 1);
	//int dayOfWeek = firstDay.getDayOfWeek().getValue();

	private int getLast() {
		int l;
		int m = today.getMonthValue();
		switch (m) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			l = 31;
			break;
			case 2: case 4: case 6: case 9: case 11:
			l = 30;
			break;
			default:
			l = 0;
		}
		return l;
	}
	//---------선생님 답안---------
	//int lastDay = today.lengthOfMonth();
	
	private void line3() {
		//line3나온값+1만큼 공란
		for (int i = 0; i < get1st(); i++) {
			System.out.print("   ");			
		}
		int day = 1;
		for (int i = get1st(); i < get1st() + getLast() ; i++) { 
			if (i % 7 == 0) {
				System.out.println();
			}
			System.out.printf("%02d ", day);
			day++;
		}
	}
}
//---------선생님 답안---------
//	for (int i = 0; i < dayOfWeek; i++) {
//			System.out.print("   ");
//	}
//	for (int i = 1; i <= length; i++) {
//			System.out.printf("%02d ", i);
//			dayOfWeek++;
//			if (dayOfWeek % 7 == 0) {
//				System.out.println();
//			}
//	}

//6월은 1일이 수요일(3)이니, 4일 11일 18일 25일에 줄바꿈! 즉, 7로 나눈 나머지가 4일때~!! dayOfWeek+1이랑 동일!!
//또는 dayOfWeek를 ++해줘서, dayOfWeek % 7 == 0 일때 줄바꿈 하라~!!

public class TestMyCalendar {
	public static void main(String args[]) {
		MyCalendar c = new MyCalendar();
		c.makeToday();
		c.showCalendar();
		
	}
}