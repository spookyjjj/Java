import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {
	public static void main(String[] args) {
		
		DataOutputStream dos = null; //문자단위로 데이터를 다루는게 아니라 걍 그 type단위로 다루자~ 
		//int면 int형 자체로 저장, double이면 double형 자체로 저장
		try {
			dos = new DataOutputStream(new FileOutputStream("d:\\filetest\\mydate.dat"));
			
			dos.writeInt(50);
			dos.writeDouble(123.123);
			dos.writeUTF("문자열");
			dos.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("d:\\filetest\\mydate.dat"));
			
			int valInt = dis.readInt(); //걍 date에 저장된 그대로 읽으면 됨
			double valDouble = dis.readDouble();
			String valString = dis.readUTF();
			
			System.out.println(valInt); 
			System.out.println(valDouble);
			System.out.println(valString);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) { //★DataInputStream에서 마지막 read()는 0도 아니고 0.0도 아니고 null도 아니고 EOFException!!
			System.out.println("파일 끝까지 다 읽음");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
