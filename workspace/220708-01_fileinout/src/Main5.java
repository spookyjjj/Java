import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		File diary = new File("d:\\filetest\\pompom.txt");
//		System.out.println(diary.exists()); //경로 잘 쳤는지 확인과정

		Scanner scan = null;
		try {
			scan = new Scanner(diary); // Scanner(System.in) 대신에 넘겨줄 파일을 적어줌
			while (scan.hasNext()) { // 다음줄 있냐?
				System.out.println(scan.nextLine()); // 있으면 가져와라
			}
		} catch (FileNotFoundException e) { //Scanner(리소스파일)의 경우에는 checked예외발생. 상위인 IOException해도됨
			System.out.println("파일을 찾지 못했습니다");
		} finally { // 자원해제는 무조건 실행되어야 함
			if (scan != null) { 
				scan.close();
			}
		}
	}

}
