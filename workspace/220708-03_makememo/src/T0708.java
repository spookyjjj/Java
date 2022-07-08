import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class T0708 extends JFrame{
	public T0708() {
		getContentPane().setLayout(null);
		
		JButton openBtn = new JButton("열기");
		openBtn.setBounds(66, 43, 97, 23);
		getContentPane().add(openBtn);
		
		JButton saveBtn = new JButton("저장");
		saveBtn.setBounds(276, 43, 97, 23);
		getContentPane().add(saveBtn);
		
		JTextArea ta = new JTextArea();
		JScrollPane scrl = new JScrollPane(ta);
		scrl.setBounds(30, 83, 374, 246);
		getContentPane().add(scrl);
		
		
		JLabel lbl = new JLabel("Memo");
		lbl.setBounds(188, 10, 57, 15);
		getContentPane().add(lbl);
		
		JFileChooser chooser = new JFileChooser();
		
		FileFilter filter = new FileFilter() { //io패키지꺼 말고 swing패키지꺼 써야한다~~
			
			@Override
			public boolean accept(File pathname) { //true인 애들만 보여줄거임
				if (pathname.isDirectory()) { //파일 중 폴더들은 ok
					return true;
				}
				return pathname.getName().endsWith(".txt"); //파일 중 .txt로 끝나는 애들만 ok
			}

			@Override
			public String getDescription() { //콤포창에 나타낼 문자열
				return "텍스트파일";
			}
		};
		chooser.setFileFilter(filter);
		
		openBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = chooser.showOpenDialog(null); //int로 반환! 열기는 1, 나머지동작은 0
				if (result == JFileChooser.APPROVE_OPTION) { 
					File opfile = chooser.getSelectedFile(); //열기를 선택한 그 파일을 특정할 뿐 뭔가 행동을 하는건 아님
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(opfile));
						String line; 
						while ((line = br.readLine()) != null) { //끝을 만나면 -1이 아니라 null을 반환함
							ta.append(line + "\n");
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {
							if (br != null) {
								br.close();
							}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				} 
			}
		});
		
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = chooser.showSaveDialog(null); //int로 반환! 열기는 1, 나머지동작은 0
				if (result == JFileChooser.APPROVE_OPTION) { //저장은  1, 나머지동작은 0
					File svfile = chooser.getSelectedFile(); //열기를 선택한 그 파일을 특정함
					//무조건 txt파일로 저장하기====
					String path = svfile.getAbsolutePath();
					int index = path.lastIndexOf('.');
					if (index == -1 || !path.substring(index).equals(".txt")) { 
						svfile = new File(path + ".txt");
					}
					//=====================
					PrintWriter pw = null;
					try {
						pw = new PrintWriter(new FileWriter(svfile, true)); //추가되게 하는건 FileWriter에 있다~!!
						String text = ta.getText();
						pw.println(LocalDateTime.now()); 
						pw.println(text); 
						pw.flush();
						ta.setText("");

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						if (pw != null) {
							pw.close();
						}
					}
				} 
			}
		});
		setSize(450, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new T0708().setVisible(true);
	}
}
