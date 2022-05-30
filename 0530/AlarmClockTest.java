class Time {
	private int time; 
	private int minute; 
	private int second; 
	
	public Time(int t, int m, int s) {
		time = t;
		minute = m;
		second = s;
	}
}

class AlarmClock {
	private Time currentTime; 
	private Time alarmTime; 
	
	public AlarmClock(Time a, Time c) {
		alarmTime = a;
		currentTime = c;
	}
}

public class AlarmClockTest{ 
	public static void main(String args[]) {
		Time alarm = new Time(6, 0, 0);
		Time current = new Time(12, 56, 34);
		AlarmClock c = new AlarmClock(alarm, current);
		System.out.println(c);
	}
}