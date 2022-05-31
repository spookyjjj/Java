class Time {
	private int time; 
	private int minute; 
	private int second; 
	
	public Time(int t, int m, int s) {
		time = t;
		minute = m;
		second = s;
	}
	
	public int getSecond() {
		return second;
	}
}

class AlarmClock {
	private Time currentTime; 
	private Time alarmTime; 
	
	public AlarmClock(Time a, Time c) {
		alarmTime = a;
		currentTime = c;
	}
	
	public Time getCurrentTime() {
		return currentTime;
	}
}

public class AlarmClockTest{ 
	public static void main(String args[]) {
		Time alarm = new Time(6, 0, 0);
		Time current = new Time(12, 56, 34);
		AlarmClock c = new AlarmClock(alarm, current);
		System.out.println(c); //AlarmClock type의 값
		System.out.println(c.getCurrentTime()); //Time type으로 값 받아냄
		//AlarmClock 안에 Time type의 값 2개, currentTime와 alarmTime가 있는데 그중에서 currentTime를 get하는 메소드
		System.out.println(c.getCurrentTime().getSecond());//Int type으로 값 받아냄
		//Time 안에 Int type의 값 3개, time,minute,second가 있는데 그 중에서 second를 get하는 메소드
	}
}