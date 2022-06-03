import java.time.LocalDate;
import java.util.Calendar;
public class Main {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance(); //Calendar클래스 안에 getInstance()라는 static메소드(이탤릭체)존재 -> new 그거를 해서 반환해주는역할.
		
		System.out.println("상수값 확인" + Calendar.YEAR); //1 //YEAR를 static하고 final한 상수값으로 설정해놔서 그냥 YEAR부르면 1임
		System.out.println("상수값 확인" + Calendar.MONTH); //2
		System.out.println("상수값 확인" + Calendar.DAY_OF_MONTH); //5
		
		System.out.println(now.get(1)); //Calendar.YEAR 이게 들어간거임~!
		System.out.println(now.get(Calendar.MONTH) + 1);
		System.out.println(now.get(Calendar.DAY_OF_MONTH));
		System.out.println(now.get(Calendar.DAY_OF_WEEK)); //6은 금요일 7은 일요일~
		
		LocalDate now2 = LocalDate.now(); //LocalDate클래스 안에now()라는 static메소드(이탤릭체) 존재.
		System.out.println(now2.getYear());
		
		System.out.println(now2.getMonth());
		System.out.println(now2.getMonthValue());
		
		System.out.println(now2.getDayOfMonth());
		
		System.out.println(now2.getDayOfWeek());
		System.out.println(now2.getDayOfWeek().getValue()); //5는 금요일 6은 토요일~
	}

}
