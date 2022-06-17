//은행계좌
//필드 잔고(int)
//메소드: 입금(int) : void
//		출금(int)	 : void >> 출금액이 보유 잔고 이상일 때 예외(부족한 금액이 얼마?)를 발생시켜서 throws..
//		getter() : int
class BankWithdrawException extends RuntimeException {
	int lack;
	public BankWithdrawException(String message, int lack) {
		super(message); //super생성자 중 String만 넣으면 되는거 부른것
		this.lack = lack;
	}
	public int getLack() {
		return lack;
	}
}

public class Account {
	int money = 0;

	void deposit(int a) {
		money += a;
	}
	void withdraw(int a) throws BankWithdrawException {
		if (a > money) {
			throw new BankWithdrawException("잔액이 부족합니다", a - money);
		} else {
			money -= a;
		}
	}
	int getter() {
		return money;
	}
	
	public static void main(String[] args) {
		// 은행계좌 객체 생성
		//입금 / 출금 / 게터 테으스
		//출금 / 예외처리
		try {
			Account a = new Account();
			a.deposit(40000);
			a.withdraw(30000);
			a.getter();
			a.withdraw(15000);
		} catch (BankWithdrawException e) {
			System.out.println(e.getMessage()); //super에 있는 메소드
			System.out.println(e.getLack() + "원"); //내가 만든 메소드
		}
		System.out.println("시스템종료");
	}

}
