import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		FileOutputStream fos = null; // try안에 들어갈 수도, 안 들어갈 수도 있으니 밖에서 일단 초기화를 해줘야함
		String line = "Hello";
		try {
			fos = new FileOutputStream(new File("d:\\filetest\\practice.txt"));
			
			fos.write(line.getBytes()); //FileOutputStream에서 write해서 가져올거는 byte형태여야한다 -> String의 Byte변환필요
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) { //초기화를 null로 해줬으니 이걸 끼워줘야 nullPointException이 안뜸
					fos.close(); //닫아주기 위해서는 fos를 전역변수로 설정하는게 필요
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
