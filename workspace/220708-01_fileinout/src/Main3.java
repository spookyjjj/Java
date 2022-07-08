import java.io.File;
import java.io.IOException;

public class Main3 {
	public static void main(String args[]) {
		File file = new File("d:\\filetest");
		System.out.println("있냐? " + file.exists());
		System.out.println("폴더냐? " + file.isDirectory());
		System.out.println("파일이냐? " + file.isFile());

		boolean result = file.mkdir(); // file 경로에 해당하는 디렉토리 만들고 결과를 boolean으로 알려줌
		System.out.println("디렉토리 생성여부: " + result); // 이미 있어서 make못했으면 false

		// d드라이브에 filetest경로안에 abc폴더를 생성해보게쇼
		File f2 = new File("d:\\filetest\\abc");
		f2.mkdir();

		// f2의 상위폴더를 찾아가기
		File f3 = new File("d:\\filetest\\abc\\..\\def");
		f3.mkdir();
		try {
			System.out.println(f3.getAbsolutePath()); // d:\filetest\abc\..\def
			System.out.println(f3.getCanonicalPath()); // D:\filetest\def
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 폴더말고 파일 만들어보기
		File textFile = new File("d:\\filetest\\mytext.txt");
		try {
			boolean result2 = textFile.createNewFile(); // 경로에 해당하는 파일 만들고 결과를 boolean으로 알려줌
			System.out.println("생성됨? " + result2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
