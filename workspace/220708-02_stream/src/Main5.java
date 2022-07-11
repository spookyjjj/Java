import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main5 {

	public static void main(String[] args) {
		Map<Integer,Set<Integer>> lotto = new LinkedHashMap<>();
		
		lotto.put(1000, new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		lotto.put(1001, new HashSet<Integer>(Arrays.asList(7, 8, 9, 10, 11, 12)));
		lotto.put(1002, new HashSet<Integer>(Arrays.asList(13, 14, 15, 16, 17, 18)));
		
		//lotto.txt에다가 정보를 출력하고싶다 아래의 형식으로
		//1000: [1, 2, 3, 4, 5, 6] <-entrySet을 toString하면 이 모양
		//1001: [7, 8, 9, 10, 11, 12]
		//1002: [13, 14, 15, 16, 17, 18]
		File file = new File("d:\\filetest\\lotto.txt");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(file)); //한 줄씩 출력하기 편해서 씀
			
			//1번 방법
			Set<Integer> key = lotto.keySet();
			for (int i : key) {
//				System.out.println(i + ": " + lotto.get(i));
				pw.println(i + ": " + lotto.get(i));
			}
			//2번 방법
			Set<Entry<Integer, Set<Integer>>> entrySet = lotto.entrySet(); //★entrySet()이라는 메소드는 Entry를 반환함
			for (Entry<Integer,Set<Integer>> e : entrySet) {
				System.out.println(e.getKey() + ": " + e.getValue());
//				pw.println(e.getKey() + ": " + e.getValue());
			}
			
//			pw.println("시간이 흐른 뒤,,추가된 내용");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
					pw.close();
			}
		}
		
		try {
//			pw = new PrintWriter(new FileWriter(file)); //다른 PrintWriter로(new 생성함) 동일 파일 적용하면, 덮어쓰기가 되어버림~!
//			pw.println("시간이 흐른 뒤,,추가된 내용");
			pw = new PrintWriter(new FileWriter(file, true)); //★★append true면 기존에 있던 file 밑에 추가하겠다~
			pw.println("시간이 흐른 뒤,,추가된 내용");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
					pw.close();
			}
		}
	}

}
