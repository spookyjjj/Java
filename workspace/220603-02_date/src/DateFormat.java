import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {

	public static void main(String[] args) {

//		Calendar cal = Calendar.getInstance();
//		Date date = cal.getTime();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //분은 소문자 달은 대문자
//		String result = dateFormat.format(date);
//		System.out.println(result);
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String result = dateFormat.format(date);
		System.out.println(result);
		
	}

}
