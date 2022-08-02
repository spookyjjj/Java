package statistics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import loginUser.BusanUser;

public class EndStaPnl extends JFrame {
	private BusanUser user;
	private String id;
	private int endingNum = 0;
	
	double angle;
	String graphicFont1;
	String graphicFont2;
	String graphicFont3;
	String graphicFont4;
	String graphicFont5;
	String graphicFont6;
	
	public void setEndingNum(int endingNum) {
		this.endingNum = endingNum;
	}

	public EndStaPnl(BusanUser busanUser) {
		super();
		this.user = busanUser;
		
		id = user.getId();
		
		JPanel ststisAllPnl = new JPanel();
		
		getContentPane().add(ststisAllPnl);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 650);
		setResizable(false);
		
		Statistics st = new Statistics();
		AchievementsTest ac = new AchievementsTest();
		
		if(endingNum > 0) { // 엔딩 봤을 때 통계 내보내기
			double ending = st.EndingStatistics(id, endingNum);
			double endingPersent = persent(ending);
			double crossrode = ac.countCrossrode(id);
			
			angle = getAngle(endingPersent);
			
			String party = ac.thisRoundParty(id);
			graphicFont1 = "당신과 같은 선택지를 고른 사람들은 " + headcount(crossrode) + "명이 있습니다.";
			graphicFont2 = "동료 ";
			graphicFont3 = party;
			graphicFont4 = "와 함께했습니다.";
			graphicFont5 = "이 엔딩은 " + headcount(ending) + "명의 사람들이 봤습니다.";
			graphicFont6 = persent(ending) + "%의 사람들이 이 엔딩을 봤습니다.";
		} else { // death 엔딩일 때 통계 내보내기
			double ending = 0;
			double endingPersent = 0;
			double crossrode = ac.countCrossrode(id);
			
			angle = 360;
			
			String party = ac.thisRoundParty(id);
			graphicFont1 = "당신과 같은 선택지를 고른 사람들은 " + headcount(crossrode) + "명이 있습니다.";
			graphicFont2 = "동료";
			graphicFont3 = party;
			graphicFont4 = "와 함께했습니다.";
			graphicFont5 = "";
			graphicFont6 = "DEATH 엔딩";
		}
	}
	
	public int headcount(double result) { // 인원수 반환
		int headCount = (int)(result / 10000);
		
		return headCount;
	}
	
	public double persent(double result) { // 통계낸 퍼센트 반환
		double persent = result % 10000 / 100;
		
		return persent;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE); // 지금 본 엔딩
	    g.fillArc(140, 100, 200, 200, 0, (int) Math.floor(angle)); //(x축,y축,반지름,반지름,시작각,끝각) - 원호를 그림
	    g.setColor(Color.LIGHT_GRAY); // 나머지 엔딩
	    g.fillArc(140, 100, 200, 200, (int) angle, (int) (361 - angle));

		g.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		g.setColor(Color.BLACK);
		g.drawString(graphicFont1, 100, 400);
		g.drawString(graphicFont2, 100, 450);
		
		g.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		g.setColor(new Color(005666));
		g.drawString(graphicFont3, 100, 468);
		
		g.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 13));
		g.setColor(Color.BLACK);
		g.drawString(graphicFont4, 100, 486);
		g.drawString(graphicFont5, 100, 536);
		g.drawString(graphicFont6, 100, 554);
	}

	public double getAngle(double ratio) { // 중심각 구하기
	    double angle = 3.6 * ratio;
	    
	    return angle;
	}

	class ChartPanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
		}
	}
	
	public static void main(String[] args) {
		BusanUser user = new BusanUser("magic22x", "mmm");
		
		new EndStaPnl(user).setVisible(true);
	}
}
