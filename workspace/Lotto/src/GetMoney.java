import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GetMoney extends JDialog {
	public GetMoney(JFrame owner) {
		setLocationRelativeTo(owner);
		setModal(true);
		setSize(400,122);
		setTitle("공짜 즉석 복권");
		
		JPanel pnl = new JPanel();
		RoundedButton chunsik = new RoundedButton("춘식이 찾기");
		chunsik.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		chunsik.setBounds(32, 26, 97, 23);
		chunsik.bgSetter(new Color(255,212,0));
		chunsik.fSetter(new Color(0,0,0));
		
		chunsik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Chunsik(GetMoney.this).setVisible(true);
				Lotto2.updateMoneyLbl();
			}
		});
		
		RoundedButton scratch = new RoundedButton("긁는 복권");
		scratch.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		scratch.setBounds(150, 26, 85, 23);
		scratch.bgSetter(new Color(255,212,0));
		scratch.fSetter(new Color(0,0,0));
		
		scratch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Scratch(GetMoney.this).setVisible(true);
				Lotto2.updateMoneyLbl();
			}
		});
		RoundedButton buyLotto = new RoundedButton("로또 구매하기");
		buyLotto.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		buyLotto.setBounds(249, 26, 109, 23);
		buyLotto.bgSetter(new Color(255,212,0));
		buyLotto.fSetter(new Color(0,0,0));
		pnl.setLayout(null);
		
		buyLotto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		pnl.add(chunsik);
		pnl.add(scratch);
		pnl.add(buyLotto);
		
		getContentPane().add(pnl);
		setLocationRelativeTo(owner);
	}
}
