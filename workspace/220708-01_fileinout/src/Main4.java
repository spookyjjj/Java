import java.io.File;
import java.io.IOException;

public class Main4 { //트라이캐치 필요한거 아닌거 뭐야
	public static void main(String[] args) {
		// d:\filetest\한글이름.txt
		
		File filekor = new File("d:\\fileTest\\한글이름.txt");
		try {
			System.out.println("생성됨? " + filekor.createNewFile());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// 이름바꾸기
		filekor.renameTo(new File("d:\\filetest\\newname.txt")); //성공하면 true 아니면 false
		
		//지우기
		File mytext = new File("d:\\filetest\\mytext.txt");
		mytext.delete(); //성공하면 true 아니면 false
		
		}
}
