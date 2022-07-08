import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main3 {

	public static void main(String[] args) {
		File file = new File("d:\\filetest\\lineio.txt");
		
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new FileWriter(file)); //PrintWriter는 내가 소스에서 입력하는걸 파라미터로 받은 파일안에 출력함

			pw.println("문자열 한 줄을 출력합니다");
			pw.println(10);
			pw.println(15.15);
			pw.flush(); //작업끝났으면 임시공간 비워우기
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null ) {
				pw.close();
			}
		}
	}

}
