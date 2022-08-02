package run;

import javax.swing.UIManager;

import loginUser.Login;

public class run {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			
		}
		Login l = new Login();
		l.setVisible(true);
	}
	

}
