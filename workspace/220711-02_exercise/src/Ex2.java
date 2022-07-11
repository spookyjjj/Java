import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Ex2 {
	public static void main(String[] args) {
		//암호화 (ex2_1 -> ex2_2)
		Map<Character, Character> map = new HashMap<>();
		for (int i = 97; i <= 119; i++) {
			map.put((char)i, (char)(i - 29));
		}
		map.put((char)120, (char)65); //x - A
		map.put((char)121, (char)66);
		map.put((char)122, (char)67);
		map.put(' ', ' ');
		map.put('\n', '\n'); //10
		map.put('\r', '\r'); //13 캐리지리턴 <-window에서는 줄바꿈에 얘도 같이 들어감
		
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(new File("d:\\filetest\\ex2_1.txt"));
			fw = new FileWriter(new File("d:\\filetest\\ex2_2.txt"));
			int i;
			while ((i = fr.read()) != -1) {
				char o = map.get((char)i);
				fw.write(o);
//				System.out.println(i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//복호화 (ex2_2 -> ex2_3)
		Map<Character, Character> map2 = new HashMap<>();
		for (int i = 97; i <= 119; i++) {
			map2.put((char)(i - 29), (char)(i));
		}
		map2.put((char)65, (char)120); //A - x
		map2.put((char)66, (char)121);
		map2.put((char)67, (char)122);
		map2.put(' ', ' ');
		map2.put('\n', '\n');
		map2.put('\r', '\r');
		
		FileReader fr2 = null;
		FileWriter fw2 = null;
		try {
			fr2 = new FileReader(new File("d:\\filetest\\ex2_2.txt"));
			fw2 = new FileWriter(new File("d:\\filetest\\ex2_3.txt"));
			int i;
			while ((i = fr2.read()) != -1) {
				int o = map2.get((char)i);
				fw2.write((char)o);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr2 != null) {
					fr2.close();
				}
				if (fw2 != null) {
					fw2.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
