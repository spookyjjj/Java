package lotto;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Lotto1 extends JFrame {
	public Lotto1() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("시작하기");
		lblNewLabel.setFont(new Font("궁서체", Font.BOLD, 25));
		lblNewLabel.setBounds(187, 270, 100, 69);
		getContentPane().add(lblNewLabel);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		URL url = this.getClass().getClassLoader().getResource("05.png"); 
		Image img = kit.getImage(url);
		JLabel lbl = new JLabel(new ImageIcon(img));
		lbl.setBounds(0, 0, 484, 461);
		getContentPane().add(lbl);
		
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Lotto1().setVisible(true);
	}
}
