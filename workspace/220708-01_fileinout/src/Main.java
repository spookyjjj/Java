import java.io.File;

public class Main { //왜...\\이거하고 /의 차이는????
	public static void main(String[] args) {
		File file = new File("d:\\Kimhj\\test.txt"); //윈도우에서는 백슬러시, ""안에선 두번써줘야 인식
		
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.exists());
		
		File f2 = new File("d:\\Kimhj\\asdf.txt"); //처음부터 경로를 차근차근 찾아감 (절대경로)
		System.out.println(f2.getName()); //실제파일이 존재하지 않아도 객체인 f2가 있으니깐 나옴
		System.out.println(f2.getPath()); //실제파일이 존재하지 않아도 객체인 f2가 있으니깐 나옴
		System.out.println(f2.exists());
		
		File dir = new File("d:\\Kimhj"); //파일이 아닌 폴더도 가능
		System.out.println(dir.getName());
		System.out.println(dir.getPath());
		System.out.println(dir.exists());
		
		System.out.println("파일인가요? " + dir.isFile()); //아예 존재하지 않으면 파일?디렉토리? 전부 false
		System.out.println("디렉토리인가요? " + dir.isDirectory());
	}
}
