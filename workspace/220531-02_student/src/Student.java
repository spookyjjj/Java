
public class Student {
		private String name; 
		private int kor; 
		private int eng; 
		private int math; 
				
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getKor() {
			return kor;
		}

		public void setKor(int kor) {
			this.kor = kor;
		}

		public int getEng() {
			return eng;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			this.math = math;
		}

		
		public int getAver() {
			return (kor + eng + math) / 3;
		}
		
		public void showDetail() {
			System.out.printf("이름: %s\n국어점수: %d\n영어점수: %d\n수학점수: %d\n평균: %d\n", getName(), getKor(), getEng(), getMath(), getAver());
		}
}

