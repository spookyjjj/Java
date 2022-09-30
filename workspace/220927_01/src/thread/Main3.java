package thread;

public class Main3 {
	public static void printThreadStatus() {
		Thread current = Thread.currentThread();
		
		System.out.println(current.getName());
		System.out.println(current.getId());
		System.out.println(current.isAlive());
		System.out.println(current.getState());
		System.out.println(current.getPriority()); //선호도(중요도) 1이면 낮고 10이면 높다
		System.out.println(current.isDaemon()); //main스레드는 항상존재, daemon스레드는 메인이 죽으면 강제로 같이 죽음
	}
	public static void main(String[] args) throws InterruptedException {
		Thread another = new Thread(new Runnable() { //alive지만 start하지 않았기 때문에 runnable하지는 않음
			@Override
			public void run() {
				printThreadStatus();
			}
		});
		another.start(); //이때서야 runnable상태 -> main과 another중에 어떤게 먼저 run할지는 지 맘 -> join써서 순서 부여
		another.join(); //join메소드를 쓰면 main이 another종료 될 때 까지 기다려줌(main는 block상태) another는 작업이 끝나면 죽으면서 main을 interrupt함(깨움)!
		System.out.println("---------------------");
		printThreadStatus();
		
		System.out.println("새 쓰레드의 현재 상태 : " + another.getState());

	}

}
