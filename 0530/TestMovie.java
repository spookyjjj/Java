class Movie {
	String title;
	String director;
	double star;
	int year;
	
	//2. 생성자를 인위적으로 만들기!! -> ★기본생성자는 없어짐
	public Movie(String t, String d, double s, int y) {
		//필드 초기화
		title = t;
		director = d;
		star = s;
		year = y;
	}
	
	void printAll() {
		System.out.println("영화 제목: " + title);
		System.out.println("감독: " + director);
		System.out.println("평점: " + star);
		System.out.println("발표된 연도: " + year);
	}
}

public class TestMovie {
	public static void main(String arg[]) {
		// Movie m = new Movie(); //1. 생성자(constructor) 중 기본생성자 -> 생성자가 하나도 만들지 않은 경우엔 자동으로 이걸로 적용
		// m.printAll(); //기본값으로 초기화 (정수형->0, 실수형->0.0, 논리형->false, 참조형->null)
		
		//3. 인위적으로 만든 생성자를 이용!!
		//Movie m = new Movie(); ->★더이상 기본생성자 이용은 못함
		Movie m2 = new Movie ("새영화", "새감독", 7.5, 2022);
		m2.printAll();
	}
}