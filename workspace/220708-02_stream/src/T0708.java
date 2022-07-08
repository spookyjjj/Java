import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class T0708 {

	public static void main(String[] args) {
		// 파일생성 (직접 손으로) person.txt
		// 1.파일 정보를 한 줄 씩 읽어서 콘솔출력
		// 2.사람 평균나이 구해서 출력
		File file = new File("d:\\filetest\\persons.txt"); //<-csv형식! (,:콤마 세퍼레잇티드 벨류)

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String line;
			int sum = 0;
			int count = 0;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				
				int index = line.indexOf(',');
				String strAge = line.substring(index + 1); //.substring(index)은 index 포함해서 다음꺼부터 다 추출해옴
				Integer age = Integer.valueOf(strAge);
				
				System.out.println("숫자변환결과: " + age);
				sum += age;
				count++;
			}
			System.out.println("평균나이: " + sum / count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
