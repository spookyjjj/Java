class Score {
	private String name; 
	private int kor; 
	private int eng; 
	private int math; 
	// private int aver; 
	
	public Score(String n, int k, int e, int m) {
		name = n;
		kor = k;
		eng = e;
		math = m;
	}
	public void setName(String n) {
		name = n;
	}
	public void setKor(int k) {
		kor = k;
	}
	public void setEng(int e) {
		eng = e;
	}
	public void setMath(int m) {
		math = m;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	
	//방법1
	// public int aver() {
		// aver = (kor + eng + math) / 3;
		// return aver;
	// }
}

//방법2
class Aver {
	private int aver;
	public int aver(Score s) {
		aver = (s.getKor() + s.getEng() + s.getMath()) / 3;
		return aver;
	}
}

public class T0530{ 
	public static void main(String args[]) {
		Score s1 = new Score("김방구", 50, 80, 20);
		Score s2 = new Score("박똥", 65, 65, 65);
		Score s3 = new Score("윤솔아", 80, 90, 95);
		//방법1
		// System.out.println(s1.aver()); 
		// System.out.println(s2.aver());
		// System.out.println(s3.aver());
		//방법2
		Aver a = new Aver();
		System.out.println(a.aver(s1));
		System.out.println(a.aver(s2));
		System.out.println(a.aver(s3));
	}
}