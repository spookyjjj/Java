import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			File file = new File("d:\\filetest\\practice.txt");
			long llength = file.length(); //파일 객체의 크기를 구하는 메소드 length() -> long으로 반환함 (해당파일은 속성가보면 5byte짜리임)
			int ilength = (int)llength;//배열 만들기 위해 int로 변환
			byte[] buf = new byte[ilength];
			
			fis = new FileInputStream(file);
//			fis.read(); // FileInputStream의 read()는 1byte씩 읽는다. 파라미터에 넣은 byte데려오려고 위에서 난리침
			fis.read(buf); //byte[]도 파라미터로 받음 -> 자동으로 배열 길이만큼만 읽음
//			fis.read(buf, 0, buf.length); //자동으로 다 넣기 싫으면 지정도 가능
			
			String result = new String(buf); //String()은 파라미터로 ""도 받고, byte[]도 받음
			
			System.out.println(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
				fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
