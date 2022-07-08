import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile1 {

	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("input.txt"); // 문자열로 알려줄 수도 있고
//			in = new FileInputStream(new File ("input.txt")); // 파일 객체를 이용해서 알려줄 수도 있다
			out = new FileOutputStream("output.txt"); //일단 FileOutputStream은 없으면 만드는것까지 한다!
			
			int c;
			while ((c = in.read()) != -1) { //.read() 하면 in의 문자를 byte(8bit)값으로 읽어서(16진법으로 표현) int로 데려온다!
				// 예시! 10101010 (8비트의 2진수표현) aa (8비트의 16진수 표현) 170 (8비트의 10진수표현)
				// int에 담는거는,, 자료의 끝에서 -1을 가져오는것도 추가되어야하니깐 더 넓은 공간으로 불러옴
				System.out.println(c);
				out.write(c); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { //자원을 닫지 않으면 심각한 자원 누출이 발생
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
