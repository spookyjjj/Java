package statistics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import loginUser.BusanUser;

public class AchvPnl extends JFrame {
	private BusanUser user;
	private String id;
	private String name;
	
	public AchvPnl(BusanUser busanUser) {
		super();
		this.user = busanUser;
		id = user.getId();
		name = user.getName();
		
		AchievementsTest ac = new AchievementsTest();
		Map<Integer, Achv> achvMap = ac.haveAchvMap(id);
		
		JPanel AchvAllPnl = new JPanel();
		JPanel AchvCenterPnl = new JPanel();
		JPanel AchvTitleUpPnl = new JPanel();
		JPanel[] AchvPnl = new JPanel[8];
		
		JLabel AchvTitle = new JLabel(name + "님의 업적");
		AchvTitle.setFont(new Font("한컴산뜻돋움", Font.BOLD, 16));
		
		JLabel[] achvName = new JLabel[8];
		JLabel[] achvText = new JLabel[8];
		
		BoxLayout box = new BoxLayout(AchvCenterPnl, BoxLayout.Y_AXIS);
		AchvCenterPnl.setLayout(box);
		BoxLayout[] achvTextbox = new BoxLayout[8];
		
		AchvCenterPnl.add(AchvTitleUpPnl);
		AchvCenterPnl.add(AchvTitle);
		
		for (int i = 0; i < achvMap.size() - 1; i++) {
			AchvPnl[i] = new JPanel();
			AchvPnl[i].setBounds(150, 0, 700, 80);
			
			achvTextbox[i] = new BoxLayout(AchvPnl[i], BoxLayout.Y_AXIS);
			AchvPnl[i].setLayout(achvTextbox[i]);
			
			achvName[i] = new JLabel(achvMap.get(i + 1).getAchvName());
			achvText[i] = new JLabel(achvMap.get(i + 1).getAchvText());
			achvName[i].setFont(new Font("한컴산뜻돋움", Font.BOLD, 14));
			achvText[i].setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
			
			AchvPnl[i].add(achvName[i]);
			AchvPnl[i].add(achvText[i]);
			
			AchvCenterPnl.add(AchvPnl[i]);
		}
		AchvCenterPnl.setBounds(50, 0, 700, 600);
		
		AchvAllPnl.add(AchvCenterPnl);
		
		add(AchvAllPnl);
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		BusanUser user = new BusanUser("gggg", "mmm");
		
		new AchvPnl(user).setVisible(true);
	}
}
