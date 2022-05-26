import java.util.Scanner;
public class TestMethod4 {
	//정수 하나를 전달받아 1~ 100 사이의 수이면 true를 반환하고, 그렇지 않으면 false를 반환하는 메소드 작성
	public static boolean between(int a) {
		return (a >= 1 && a <= 100) ? true : false;
	}
	
	// between(값)이 참일 때까지 계속 숫자를 입력받는 메소드
	public static int util() {
		Scanner scan = new Scanner(System.in);
		int score;
		do {
			score = scan.nextInt();
			if (between(score)) {
				return score; //if에 return넣으면 else에도 return이 필요하다~!!
			} else {
				System.out.println("점수는 1과 100 사이의 값이어야 합니다");
				return score;
			}	
		} while (!between(score));
		
		// return score;
	}
	
	//메인메소드
	public static void main(String args[]) {
		System.out.println(between(102));
		
		//사용자가 국어 영어 수학 점수 입력 (1~100사이여야함) 점수 합 출력
				
		System.out.println("국어?");
		int kor = util();
		
		System.out.println("영어?");
		int eng = util();
		
		System.out.println("수학?");
		int math = util();
		
		System.out.println("국어점수: " + kor);
		System.out.println("영어점수: " + eng);
		System.out.println("수학점수: " + math);
		System.out.println("점수의 총합: " + (kor + eng + math));
		
		// int sum = 0;
		// int kor;
		// int eng;
		// int math;
		
		// System.out.println("국어?");
		// do {
			// kor = scan.nextInt();
			// if (between(kor)) {
				// sum += kor;
			// } else {
				// System.out.println("점수는 1과 100 사이의 값이어야 합니다");
			// }	
		// } while (!between(kor));
		
		// System.out.println("영어?");
		// do {
			// eng = scan.nextInt();
			// if (between(eng)) {
				// sum += eng;
			// } else {
				// System.out.println("점수는 1과 100 사이의 값이어야 합니다");
			// }	
		// } while (!between(eng));
		
		// System.out.println("수학?");
		// do {
			// math = scan.nextInt();
			// if (between(math)) {
				// sum += math;
			// } else {
				// System.out.println("점수는 1과 100 사이의 값이어야 합니다");
			// }	
		// } while (!between(math));
		
		// System.out.println("점수의 총합: " + sum);
	}
}