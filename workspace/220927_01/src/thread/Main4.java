package thread;

public class Main4 {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("잘게요");
				try {
					Thread.sleep(4000); //스레드 4초동안 block됨
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("작업종료~");
			}
		});
//		t.setDaemon(true); //이거 해주면 메인스레드가 죽으면서 같이 죽어서 "작업종료~"가 안뜸 
		
		System.out.println("프로그램 시작");
		t.start();
//		t.interrupt(); //main스레드가 t스레드를 깨움 -> 둘다 runnable되니 지맘대로 나옴
		System.out.println("프로그램 종료?"); 
	}
}
