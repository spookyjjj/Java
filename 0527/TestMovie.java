//3. 클래스 이름 영화 //필드: 제목 평점 감독 발표된 연도 //메소드: 모든 값을 출력하는 기능
class Movie {
	String title;
	String director;
	double star;
	int year;
	
	void printAll() {
		System.out.println("영화 제목: " + title);
		System.out.println("감독: " + director);
		System.out.println("평점: " + star);
		System.out.println("발표된 연도: " + year);
	}
}

public class TestMovie {
	public static void main(String arg[]) {
		Movie m = new Movie();
		m.title = "폰부스";
		m.director = "조엘 슈매커";
		m.star = 8.46;
		m.year = 2003;
		m.printAll();
	}
}