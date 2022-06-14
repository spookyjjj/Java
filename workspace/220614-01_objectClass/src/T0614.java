import java.util.Scanner;

//회원관리 프로그램
//콘솔로 입렵받아 등록할 수 있게. 최대 10명
//중복등록되면 안됨 (이름, 키, 몸무게가 동일하면 중복)
//BMI기준에 따라 집계해서 목록을 보여줘야 합니다

//회원[이름, 키, 몸무게]
//BMI지수 = 몸무게(Kg) / 키^2(m)
//고도 :35이상 중도비만: 30이상 35미만 경도비만:25이상 30미만 과체중: 23이상 25미만 정상: 18.5이상 23미만 저체중:18.5미만

class Member {
	private final int NUM = 220600;
	private int num; //회원번호
	private String name;
	private double weight;
	private double height;
	
	
	public Member() {
		NUM++;
		num = NUM; //6월에 등록한 순서대로 회원번호 
	}
	
	public int getNum() {
		return num;
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
	
	public void setNum(int num) {
		this.num = num;
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
		return String.format("[%d] %s\t%.1fkg\t%.1fcm\n", num, name, weight, height); //prtinf 안 거쳐도 string에서 바로 format 쓸 수 있다!
	}
	
}

class Manager {
	private Member[] m = new Member[10];
	private double[] m_BMI = new double[10];
	
	private int blank() { //빈 회원 번호 알려주는 메소드 (작은 수 먼저)
		for (int i = 0; i < 10; i++) {
			if (m[i] == null) {
				return i;
			}
		} return 10; //10번까지 꽉찬경우에 리턴할 정수 -> 이래야 for문에 blank()로 처리가능
	}
	
	private void calBMI() { //BMI계산해서 BMI배열에다가 넣는 메소드
		for(int i = 0; i < blank(); i++) { 
			m_BMI[i] = m[i].getWeight() / ((m[i].getHeight() / 100) * (m[i].getHeight() / 100));
		} //여기서, blank 이후의 인덱스에서는 m_BMI[i]에 기본값 "0"이 들어가 있다는거 기억해놓기!
	}
	
	private void inputMember() { //회원정보 등록 메소드
		int i = blank();
		if ((i) == 10) {
			System.out.println("회원수가 꽉 찼습니다");
		} else {
			Scanner scan = new Scanner(System.in);
			m[i] = new Member(); //이게 있어야 필드값이 공란인 인스턴트가 생기고, 
			System.out.print("회원이름? ");
			m[i].setName(scan.nextLine()); //그래야 필드값을 세팅해줄 수 있다
			System.out.print("몸무게kg? ");
			m[i].setWeight(scan.nextDouble());
			System.out.print("키cm? ");
			m[i].setHeight(scan.nextDouble());
			for (int j = 0; j < i; j++) {
				if (m[i].equals(m[j])) {
					System.out.println("이미 등록된 회원입니다");
					m[i] = null; //다시 null로 등록 정보 없앰
				}
			}
		}
	}
	private void printMember() { //등록된 회원 전부 출력하는 메소드
// 		for(int i = 0; i < 10; i++) {
// 			if (m[i] == null) {
// 				continue;
// 			}
// 			System.out.print(m[i].toString());
// 		}
		for(int i = 0; i < blank(); i++) {
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
			//★null은 toString이 안되니까 NullPointerException에러가 뜸 -> m_BMI[i]가 0일때는 toString안걸리게 제외 해줘야함
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
	//삭제할 회원번호 입력받기 있음/없음->메뉴로 빠져나가기
	//선택한 회원 정보 확인하고 의사묻기 맞음/취소->메뉴로 빠져나가기
	//맞으면 해당 인덱스의 참조를 한칸씩 땡겨오고 마지막엔 null
	private int findMemberByNum() { //회원번호로 멤버찾기
		Scanner scan = new Scanner(System.in);
		int num  = scan.nextInt();
		for (i = 0; i < blank(); i++) {
			if (num == m[i].getNum()) {
				return i;
			}
		}
		return -1; //indexOf에서 찾는 값 없으면 -1주듯이
	}
	private void delMember(int a) {
		while (a != 9) {
			m[a] = m[a+1]
			a++;
		}
		m[9] = null;
	}
	private String delMemberProgram() {
		Scanner scan = new Scanner(System.in);
		System.out.print("정보를 삭제할 회원의 회원번호? ");
		int a = findMemberByNum();
		if (a == -1) {
			return "해당하는 회원을 찾을 수 없습니다";
		} else {
			System.out.println(m[a].toString());
			System.out.println("해당 회원이 맞습니까? 삭제를 진행하려면 1, 취소하려면 아무키나 누르세요");
			int button  = scan.nextInt();
			if (button == 1) {
				delMember(int a);
				return "회원정보가 삭제되었습니다";
			} else {
				return "취소되었습니다":
			}
		}
	}
	
	private void menu() { //메뉴 출력 메소드
		System.out.println("=========회원관리프로그램=========");
		System.out.println("1. 회원등록");
		System.out.println("2. 회원목록");
		System.out.println("3. BMI별 회원목록");
		System.out.println("4. 회원삭제");
		System.out.println("5. 종료");
	}
	public void programStart() {
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
				delMemberProgram();
			} else if (num ==5) {
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
		m.programStart();

	}

}
