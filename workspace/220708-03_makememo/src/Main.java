import java.io.File;

import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
//		chooser.showOpenDialog(null); //int로 반환! 열기는 1, 나머지동작은 0
		int result = chooser.showSaveDialog(null); //마찬가지로 int값으로 반환
		if (result == JFileChooser.APPROVE_OPTION) { //저장은  1, 나머지동작은 0
			System.out.println("저장버튼을 눌렀을 때"); //★★실제로 저장된건 아니고 누른 행위까지만 있는거임!!!!!
			
			File file = chooser.getSelectedFile();
			System.out.println("사용자가 선택한 파일 : " + file.getAbsolutePath());
		} 
	}

}
