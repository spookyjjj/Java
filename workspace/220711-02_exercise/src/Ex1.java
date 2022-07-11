// 문자열 형태의 정수 파일 -> 오름차순 정렬한 파일
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex1 {

	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		List<Integer> list = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(new File("d:\\filetest\\ex1_1.txt")));
			String s;
			while ((s = br.readLine()) != null) {
				Integer i = Integer.valueOf(s);
				list.add(i);
			}
			Collections.sort(list);
			
			pw = new PrintWriter(new File("d:\\filetest\\ex1_2.txt"));
			for(Integer i : list) {
				pw.println(i);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (pw != null) {
				pw.close();
			}
		}
		
	}

}
