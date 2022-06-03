import java.time.LocalDate;
import java.util.Calendar;
public class TestDateMethods {
	public static void main(String args[]) {
		LocalDate now = LocalDate.now();
		System.out.println(now);
		//내일의 날짜 객체
		LocalDate tomorrow = LocalDate.of(2022, 6, 4);
		LocalDate nowPlusOne = now.plusDays(1);
		System.out.println(tomorrow);
		
		Calendar now2 = Calendar.getInstance();
		now2.set(2022, Calendar.JUNE, 4);
		now2.add(Calendar.DAY_OF_MONTH, 1);
	}
}
