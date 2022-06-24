import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main5 extends JFrame {
	public Main5() {
		JPanel pnl = new JPanel();
		
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		
		//패널에다가 layout먹이기
//		FlowLayout flow = new FlowLayout(FlowLayout.LEFT); //생성자에다가 정렬기준 적어줌 (FlowLayout.LEFT, RIGHT, CENTER)
//		pnl.setLayout(flow); //일정 거리를 두고 가로로 차곡차곡 배열 <- 패널의 기본꼴
		
//		BorderLayout border = new BorderLayout();
//		pnl.setLayout(border); //자기의 영역(동서남북)에 컴포넌트를 가득!! 채움 <-JFrame의 기본꼴
		
//		BoxLayout box = new BoxLayout(pnl, BoxLayout.Y_AXIS); //기본생성자 없음. 파라미터 꼭 넣어야해 (대상, 방향:X_AXIS,Y_AXIS등등)
//		pnl.setLayout(box); //박스처럼 붙여가지고 옆으로 혹은 세로로 차곡차곡 쌓음
		
//		GridLayout grid = new GridLayout(2, 2); //바둑판처럼 쪼개서 배치 
//		pnl.setLayout(grid); 
		
		pnl.setLayout(null); //pnl에 컴포넌트가 있어도 안보임->버튼의 위치와 크기를 하나도 안 정해줬으니깐
		btn1.setLocation(10, 30); //따라서 이렇게 하나하나 다 위치설정해줘야함
		btn1.setSize(200, 300);
		btn2.setBounds(250, 50, 90, 40);
		
//		btn1.setSize(300, 300); //레이아웃 매니저가 null이 아닌한, size는 하라는대로 안먹힌다~ 지네가 쓰는 크기 고집함
//		btn1.setPreferredSize(new Dimension(300, 300)); //★제안하기를 이용해야 한다!!! -> 적용해주려고 노력함,,ㅎㅎ
		//borderlayout에서는 상중하->높이만 먹음... 좌중우->너비만 먹음...
		
		pnl.add(btn1);
		pnl.add(btn2);
		pnl.add(btn3);
		
		//★BorderLayout을 적용할 때는 add할때 5방위 중 하나를 선택하므로써 처리 가능
//		pnl.add(btn1, "North"); //String으로 적어도 되고
//		pnl.add(btn2, BorderLayout.CENTER); //(Center는 기본값이라 생략해도됨)
//		pnl.add(btn3, BorderLayout.SOUTH); //final상수를 넣어도 되고
		//======
//		pnl.add(btn1, "West");
//		pnl.add(btn2);
//		pnl.add(btn3, "East");
		
		add(pnl);
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Main5 m = new Main5();
		m.setVisible(true);
		

	}

}
