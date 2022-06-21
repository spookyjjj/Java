import java.time.LocalDate;

interface LeafletHandler {
	String give();
}
//위의 인터페이스를 구현하는 클래스를 작성하세요. 추상메소드를 오버라이드 해야합니다. 구현 바디는 (전화번호 문자열 반환)
//일수 광고 전단지 제공자
//전화번호가 포함되어야함.

//선거 광고 전단지 제공자
//선거 날짜가 포함되어야함.

//------------
//광고대행사
//일수광고/선거광고

class LoanAD implements LeafletHandler{
	private String tel;
	
	public LoanAD(String tel) {
		super();
		this.tel = tel;
	}

	@Override
	public String give() {
		return "전화번호: " + tel;
	}
}

class VoteAD implements LeafletHandler {
	private LocalDate VoteDay;
	
	public VoteAD(LocalDate VoteDay) {
		super();
		this.VoteDay = VoteDay;
	}

	@Override
	public String give() {
		return "투표날짜: " + VoteDay.toString();
	}
	
}

class AdCompany {
	private LeafletHandler ad; //★인터페이스도 필드 타입처럼 사용 가능! 

	public AdCompany(LeafletHandler ad) { //호출할 때, 인터페이스가 LeafletHandler이면됨!
		super();
		this.ad = ad;
	}

	public LeafletHandler getAd() {
		return ad;
	}

	public void setAd(LeafletHandler ad) {
		this.ad = ad;
	}
	
	public void consoleAD() {
		System.out.println(ad.give());
	}
}

public class T0621_3 {
	public static void main(String[] args) {
//		LeafletHandler h1 = new 일수광고();
//		String 전화번호가포함된일수광고문자열 = h1.give();
//		
//		LeafletHandler h2 = new 선거광고();
//		String 선거날짜가포함된광고문자열 = h2.give();
//		
//		광고대행사 p = new 광고대행사(일수광고);
//		p.광고() <<< 일수광고
//		
//		p.set고객(선거광고);
//		p.광고() <<< 선거광고
		
		
		AdCompany company = new AdCompany(new LoanAD("010-1234-1234")); //★LoanAD객체는 LeafletHandler의 구현체이니 이게 가능함,, 
		company.consoleAD();
		
		company.setAd(new VoteAD(LocalDate.now())); //★VoteAD객체는 LeafletHandler의 구현체이니 이게 가능함,,

	}

}
