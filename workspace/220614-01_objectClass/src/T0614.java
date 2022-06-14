import java.util.Scanner;

//회원관리 프로그램
//콘솔로 입렵받아 등록할 수 있게. 최대 10명
//중복등록되면 안됨 (이름, 키, 몸무게가 동일하면 중복)
//BMI기준에 따라 집계해서 목록을 보여줘야 합니다

//회원[이름, 키, 몸무게]
//BMI지수 = 몸무게(Kg) / 키^2(m)
//고도 :35이상 중도비만: 30이상 35미만 경도비만:25이상 30미만 과체중: 23이상 25미만 정상: 18.5이상 23미만 저체중:18.5미만

class Member {
	private String name;
	private double weight;
	private double height;
	
	
	public Member(String name, double weight, double height) {
		this.name = name;
		this.weight = weight;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override //Member class에서의 동일은 이름, 키, 몸무게가 다 똑같을 경우에~!
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (!(obj instanceof Member))
			return false;
		Member other = (Member) obj;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override //회원의 개인정보 보기
	public String toString() {
		return "[회원이름=" + name + ", 몸무게(kg)=" + weight + ", height(m)=" + height + "]\n";
	}
	
}

class Manager {
	private Member[] m = new Member[10];
	private double[] m_BMI = new double[10];
	
	private void calBMI() { //BMI계산해서 BMI배열에다가 넣는 메소드
		for(int i = 0; i < 10; i++) {
			if (m[i] == null) {
				m_BMI[i] = 0;
			} else {
				m_BMI[i] = m[i].getWeight() / (m[i].getHeight() * m[i].getHeight());
			}
		}
	}
	
	private int blank() { //빈 회원 번호 알려주는 메소드 (작은 수 먼저)
		for (int i = 0; i < 10; i++) {
			if (m[i] == null) {
				return i;
			}
		} return 777; //10번까지 꽉찬경우에 리턴할 정수
	}
	
	private void inputMember() { //회원정보 등록 메소드
		int i = blank();
		if ((i) == 777) {
			System.out.println("회원수가 꽉 찼습니다");
		} else {
			Scanner scan = new Scanner(System.in);
			System.out.print("회원이름? ");
			String s = scan.nextLine();
			System.out.print("몸무게? ");
			int w = scan.nextInt();
			System.out.print("키? ");
			double h = scan.nextDouble();
			m[i] = new Member(s, w, h);
			for (int j = 0; j < i; j++) {
				if (m[i].equals(m[j])) {
					System.out.println("이미 등록된 회원입니다");
					m[i] = null;
				}
			}
		}
	}
	private void printMember() { //등록된 회원 전부 출력하는 메소드
		for(int i = 0; i < 10; i++) {
			if (m[i] == null) {
				continue;
			}
			System.out.print(m[i].toString());
		}
	}
	private void printBMIList() {//BMI별로 출력하는 메소드
		calBMI();
		String[] printBMI = new String[6];
		for (int i = 0; i < 6; i++) {
			printBMI[i] = "";
		}
		for (int i = 0 ; i < 10; i++) {
			if (m_BMI[i] >= 35) {
				printBMI[0] += m[i].toString();
			} else if (m_BMI[i] >= 30) {
				printBMI[1] += m[i].toString();
			} else if (m_BMI[i] >= 25) {
				printBMI[2] += m[i].toString();
			} else if (m_BMI[i] >= 23) {
				printBMI[3] += m[i].toString();
			} else if (m_BMI[i] >= 18.5) {
				printBMI[4] += m[i].toString();
			} else if (m_BMI[i] > 0) { 
			//★else라고 하거나, else if (m_BMI[i] >= 0)라고 하면 m_BMI[i]가 0일때! 즉, m[i]가 null일때도 if중괄호 안으로 들어가게됨!!
			//★null은 toString이 안되니까 NullPointerException에러가 뜸 -> m_BMI[i]가 0일때는 toString안걸리게 해줘야함
				printBMI[5] += m[i].toString();
			}
		}
		System.out.println("===고도비만===");
		System.out.println(printBMI[0]);
		System.out.println("===중도비만===");
		System.out.println(printBMI[1]);
		System.out.println("===경도비만===");
		System.out.println(printBMI[2]);
		System.out.println("===과체중===");
		System.out.println(printBMI[3]);
		System.out.println("===정상===");
		System.out.println(printBMI[4]);
		System.out.println("===저체중===");
		System.out.println(printBMI[5]);
	}
	private void menu() { //메뉴 출력 메소드
		System.out.println("=========회원관리프로그램=========");
		System.out.println("1. 회원등록");
		System.out.println("2. 회원목록");
		System.out.println("3. BMI별 회원목록");
		System.out.println("4. 종료");
	}
	public void programStrat() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			menu();
			int num = scan.nextInt();
			if (num == 1) {
				inputMember();
			} else if (num == 2) {
				printMember();
			} else if (num ==3) {
				printBMIList();
			} else if (num ==4) {
				break;
			} else {
				System.out.println("없는 메뉴입니다");
			}
		}
	}
	
}
public class T0614 {

	public static void main(String[] args) {
		Manager m = new Manager();
		m.programStrat();

	}

}
