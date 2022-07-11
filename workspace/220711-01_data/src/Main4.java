import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main4 {
	public static void main(String[] args) {
		DataInputStream dis = null;
		List<Student> list = new ArrayList<>();
		try {
			dis = new DataInputStream(new FileInputStream(new File("d:\\filetest\\student.dat")));
			while (true) { // 다 읽으면 EOF예외로 이동~
				String name = dis.readUTF(); //변환할 필요 없이 걍 출력하면 됨
				int age = dis.readInt();
				double score = dis.readDouble();
			
				Student s = new Student(name, age, score);
				list.add(s);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("학생 정보를 파일 끝까지 다 읽었습니다");
		} catch (IOException e) { //부모클래스가 밑으로 가면 됨
			e.printStackTrace();
		}
//		catch (IOException e) { //이렇게 하나로 퉁쳐도 됨~
//			System.out.println(e.getClass());
//		} 
		finally {
			try {
				if (dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
