package thread;

class IntHolder {
	private int number;
	
	public void increse() {
		number++;
	}
	public int getNumber() {
		return number;
	}
}

public class Main5 {
	public static void main(String[] args) throws InterruptedException {
		IntHolder sharedObject = new IntHolder();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				int a = 0;
				for (int i = 0; i < 10000; i++) {
					//a++;
					sharedObject.increse();
				}
				//System.out.println("작업 완료, a값: " + a); //작업 완료, a값: 10000
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				int a = 0;
				for (int i = 0; i < 10000; i++) {
					//a++;
					sharedObject.increse();
				}
				//System.out.println("작업 완료, a값: " + a);  //작업 완료, a값: 10000 -> 스레드가 다르니 각각 진행
			}
		});
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		System.out.println(sharedObject.getNumber()); //20000이 나오지 않는다!
		//이유? 연산작업은 대상 값을 register로 보내 연산하고, 그 결과값을 다시 불러오는 흐름으로 이루어지는데
		//작업자가 두명이면 쟤가 가져가 작업중인걸 모르고 얘도 가져가고 그래서 이런 결과가 나온것
		//해결? 공유 자체를 없애거나, 공유해야한다그러면 읽기만 가능하고 변경은 불가능하게 해야함, 근데 둘다 변경해야하면 순서를 줄 수 밖에! (시간이 늘어남)
		//맨 마지막 방법을 쓰는 프로그래밍법이 스레스안전프로그래밍 <- 멀티스레드 상황에서도 정확하게 동작하게 하는거
	}
}