import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy2 {
	public static void main(String[] args) {
		FileReader inputStream = null;
		FileWriter outputStream = null;
		
		try {
			inputStream = new FileReader("input.txt");
			outputStream = new FileWriter("output.txt"); //일단 FileWriter는 없으면 만드는것까지 한다!
			
			int c;
			while ( (c = inputStream.read()) != -1 ) { //.read()의 반환값 역시 int! (유니코드(아스키같은) UTF-8에 맞춰서)
				//FileInputStream과는 달리 FileReader는 byte단위가 아니라 문자단위라서 2byte를 데려올때도 있다
				System.out.println("읽은 문자 확인 : + " + (char) c); //줄바꿈도 문자다~!
				
				outputStream.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
