import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable { //Serializable는 추상메소드도 없어서 override할 필요도 없음!
	//걍 "직렬화가능"이라는 표시만 달아준다고 생각하면 됨 
	private String name;
	private int age;
	private transient double score; //transient 넣으면 직렬화 대상에서 제외됨
	public Student(String name, int age, double score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
}


public class Main {
	public static void main(String[] args) {
		//학생
		//이름(문자열)
		//나이(int)
		//학점(double)
		
		//List -> file로 정보 옮기기
		//데이터포멧) 홍길동222.5(X) 홍길동.22.2.5(X) 홍길동/22/2.5(O) 홍길동\n22\n2.5\n(O)
//		List<Student> list = new ArrayList<>(Arrays.asList(new Student("홍길동", 22, 2.5), new Student("둘리", 23, 3.3), new Student("도우너", 44, 4.4)));
//	
//		PrintWriter pw = null;
//		try {
//			pw = new PrintWriter(new File("d:\\filetest\\students.txt"));
//			for (int i = 0; i < list.size(); i++) {
//				Student s = list.get(i);
//				pw.println(s.getName());
//				pw.println(s.getAge());
//				pw.println(s.getScore());
//			}
//			pw.flush(); //PrintWriter도 버퍼공간을 가지고 있다 -> 언제 버퍼공간이 가득찰지 모르기 때문에 걍 해주는게 맘편함
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			pw.close();
//		}
		
		//file -> list 정보 옮기기
		BufferedReader br = null;
		List<Student> list = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(new File("d:\\filetest\\students.txt")));
			
			while (true) {
				String name = br.readLine();
				int age = Integer.valueOf(br.readLine()); //학생객체로 만들기 위해 int로 형변환
				double score = Double.valueOf(br.readLine()); //학생객체로 만들기 위해 double로 형변환
				//위의 형변환 과정이 번잡스러우니 걍 그 형 그대로 data로 저장하는 DataOutputStream/DataInputStream사용
			
				Student s = new Student(name, age, score);
				list.add(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(list);
		
	}

}
