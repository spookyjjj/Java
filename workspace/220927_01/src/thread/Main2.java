package thread;

public class Main2 {
	public static void printNumbers() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " -> 현재 쓰레드");
		
		Thread t1 = new Thread(new Runnable() { //새로운 Thread를 생성하고 싶다면 생성자안에 Runnable인터페이스를 구현한 클래스 넘겨줘야함
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " -> 현재 쓰레드");
				for (int i = 0; i > -100; i--) {
					System.out.println(i);
				}
			}
		});
		t1.start();
		System.out.println("작업 1 시작");
		printNumbers();
		System.out.println("작업 1 종료");
		
		System.out.println("작업 2 시작");
		printNumbers();
		System.out.println("작업 2 종료");
		
		System.out.println("작업 3 시작");
		printNumbers();
		System.out.println("작업 3 종료");

	}
}