import java.time.LocalDate;

public class DiaryT implements Comparable<DiaryT> {
	private LocalDate day;
	private String title;
	private String weather;
	private String content;
	
	public DiaryT(LocalDate day) {
		super();
		this.day = day;
	}
	public DiaryT(LocalDate day, String title, String weather, String content) {
		super();
		this.day = day;
		this.title = title;
		this.weather = weather;
		this.content = content;
	}
	public LocalDate getDay() {
		return day;
	}
	public void setDay(LocalDate day) {
		this.day = day;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "일기 [날짜=" + day + ", 제목=" + title + ", 날씨=" + weather + "]";
	}
	@Override
	public boolean equals(Object obj) { //날짜가 같아야 같다고 재설정
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiaryT other = (DiaryT) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		return true;
	}
	@Override
	public int compareTo(DiaryT o) { //비교값도 날짜를 기준으로!
		return day.compareTo(o.day);
	}
}
