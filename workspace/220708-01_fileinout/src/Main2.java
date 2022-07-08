import java.io.File;
import java.io.IOException;

public class Main2 { 
	public static void main(String[] args) {
		File file = new File(".\\"); // "." 하나는 현재경로를 의미함 (내 기준!->상대경로)
		//Main2가 아닌 이유?? 이클립스에서는 작업중인 파일이 아니라 작업중인 프로젝트를 현재경로로 데려온다
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath()); // 상대경로를 절대경로로 만들어 달라~ \.으로 끝남
		// D:\kimhj\workspace\220708-01_fileinout\.
		try {
			System.out.println(file.getCanonicalPath()); // \.빼고 순수 경로만 알려줌. 에러나면 IOException임.
			// D:\kimhj\workspace\220708-01_fileinout
		} catch (IOException e) { // checked예외이기 때문에 무조건 예외처리 필요. 이 예외인지 아닌지는 툴팁으로 확인
			e.printStackTrace();
		}

		File fileParent = new File("..\\"); // ".." 두개는 상위경로를 의미함 (내 기준!->상대경로)
		System.out.println(fileParent.getAbsolutePath()); // \..으로 끝남 (해석필요)
		// D:\kimhj\workspace\220708-01_fileinout\..
		try {
			System.out.println(fileParent.getCanonicalPath()); // \..을 빼고 순수 경로만 알려줌 (해석 지가 해줌)
			// D:\kimhj\workspace
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File file3 = file.getCanonicalFile().getParentFile(); // file3는 "D:\kimhj\workspace"
			System.out.println(file3.getAbsolutePath());
			System.out.println(file3.getCanonicalPath());
			System.out.println(fileParent.equals(file3)); // fileParent는 "D:\kimhj\workspace\220708-01_fileinout\.."라서 다름
			System.out.println(fileParent.compareTo(file3)); 
			System.out.println(fileParent.getCanonicalFile().equals(file3)); //fileParent.getCanonicalFile()이 "D:\kimhj\workspace"라서 같음
			System.out.println(fileParent.getCanonicalFile().compareTo(file3));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
