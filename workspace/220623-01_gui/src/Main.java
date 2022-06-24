import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// CLI
		
// GUI
	//AWT 
	//SWING -> Swing을 배워볼거임~~
	//JavaFX : 화면 레이아웃(FXML파일)과 애플리케이션 코드(자바코드)를 분리할 수 있음
		
// Android
public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("제목입니다"); //생성자로 title에 값 넣기
//		frame.setTitle("제목입니다2"); //setter로 title에 값 넣기
		
		frame.getContentPane().add(new JLabel("Hello World")); //component는 내용을 이루는 요소 하나하나
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //int값 3이 여기서 정의된 끄는 작동스위치인데, 당연히 final상수로 되어있으니 숫자 외울 필요없이 이름불러 데려오면됨 
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
