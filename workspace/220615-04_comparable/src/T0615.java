import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//회원관리 프로그램
//콘솔로 입렵받아 등록할 수 있게. 최대 10명
//중복등록되면 안됨 (이름, 키, 몸무게가 동일하면 중복)
//BMI기준에 따라 집계해서 목록을 보여줘야 합니다

//회원[이름, 키, 몸무게]
//BMI지수 = 몸무게(Kg) / 키^2(m)
//고도 :35이상 중도비만: 30이상 35미만 경도비만:25이상 30미만 과체중: 23이상 25미만 정상: 18.5이상 23미만 저체중:18.5미만


//키 순(오름차순)으로 멤버 조회하기-> comparable쓰면 됨
//몸무게순(오름차순)으로 멤버 조회하기 -> ★기준이 두개가 되면 comparator를 사용해야함
//https://st-lab.tistory.com/243 참고자료

class Member {
	private static int standard = 220600;
	//★★-> 만약 static이 없었다면, 인트턴스마다 각각의 standard 가질 뿐.. 결국 220601짜리만 여러개 쌓인다
	private int memberID; //회원번호
	private String name;
	private double weight;
	private double height;

	public Member(int memberID, String name, double weight, double height) {
		this.memberID = memberID;
		this.name = name;
		this.weight = weight;
		this.height = height;
	}

	public Member() {
		memberID = ++standard; //6월에 등록한 순서대로 회원번호 
		//★standard++로 하면 0부터 시작한다?
		//뒤에 ++이면 연산(대입연산포함) 다 끝난 후에 1증가시키는거임! 앞에 ++이면 1증가시켜 놓고 연산진행하는거고
		/*
		int num = 7;
		int result1 = (++num) - 5; // result1는 3, num은 8
		int result2 = (num++) - 5; // result2는 2, num은 8
		 */
	}
	
	public int getMemberID() {
		return memberID;
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
	
	public void setMemberID(int memberID) {
		this.memberID = memberID;
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
		return String.format("[%d] %s\t%.1fkg\t%.1fcm", memberID, name, weight, height); //prtinf 안 거쳐도 string에서 바로 format 쓸 수 있다!
	}
	
}

//★키를 기준으로 비교하기 위해 외부에 별개의 클래스 생성 -> 
class HeightComp implements Comparator<Member> {
	@Override
	public int compare(Member o1, Member o2) {
		return (int) (o1.getHeight() - o2.getHeight());
	}
}

//class HeightComp2 extends Member implements Comparable<Member> {
//	@Override
//	public int compareTo(Member o1) {
//		return (int) (this.getHeight()- o1.getHeight()); 
//	}
//}

class Manager {
	private Member[] m = new Member[10];
	private double[] m_BMI = new double[10];

	HeightComp heightCompare = new HeightComp(); //★키 기준 비교를 위해 외부에 클래스를 따로 만들었다면, 다른 클래스에서 실행을 위해선 객체생성 필요
//	++ Comparable<Member> heightCompare = new HeightComp() 로 upcasting하는게 가능하나는점 -> 이게 확장되어서 로컬클래스가 등장!
	private void arrHeight() {		
		Member[] m_arrH = Arrays.copyOf(m, blank());
		Arrays.sort(m_arrH, heightCompare); //★배열과, Comparator로 구현된 객체를 파라미터로 같이 넘겨줌
		for (int i = 0; i < m_arrH.length; i++) {
			System.out.println(m_arrH[i]);
		}
	}
//	private void arrHeight() {		
//		HeightComp2 heightCompare = new HeightComp2(); 
//		Member[] a = Arrays.copyOf(m, blank());
//		HeightComp2[] m_arrH = (HeightComp2[]) a; //downcast라서 안된다!! 결국은 comparator로 접근할 수 밖에,,,
//		Arrays.sort(m_arrH); 
//		for (int i = 0; i < m_arrH.length; i++) {
//			System.out.println(m_arrH[i]);
//		}
//	}
	
//	//키를 기준으로 비교하기 위한 익명의 1회용 객체 -> 로컬클래스
//	Comparator<Member> heightCompare = new Comparator<Member>() { //class이름조차 없으니 upcasting할것도 없이 바로 인터페이스로 생성
//		@Override
//		public int compare(Member o1, Member o2) {
//			return (int) (o1.getHeight() - o2.getHeight());
//		}
//	};
	
	
	//★몸무게를 기준으로 비교하기 위한 익명의 객체
	Comparator<Member> weightCompare = new Comparator<Member>() {
		@Override
		public int compare(Member o1, Member o2) {
			return (int) (o1.getWeight() - o2.getWeight());
		}
	};
	private void arrWeight() {		
		Member[] m_arrW = Arrays.copyOf(m, blank());
		Arrays.sort(m_arrW, weightCompare); //★배열과, Comparator로 구현된 객체를 파라미터로 같이 넘겨줌
		for (int i = 0; i < m_arrW.length; i++) {
			System.out.println(m_arrW[i]);
		}
	}
	
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
		if (blank() == 0) {
			System.out.println("등록된 회원이 없습니다");
		}
		for(int i = 0; i < blank(); i++) {
			System.out.println(m[i].toString());
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
				printBMI[0] += m[i].toString() + "\n";
			} else if (m_BMI[i] >= 30) {
				printBMI[1] += m[i].toString() + "\n";
			} else if (m_BMI[i] >= 25) {
				printBMI[2] += m[i].toString() + "\n";
			} else if (m_BMI[i] >= 23) {
				printBMI[3] += m[i].toString() + "\n";
			} else if (m_BMI[i] >= 18.5) {
				printBMI[4] += m[i].toString() + "\n";
			} else if (m_BMI[i] > 0) { 
			//★else라고 하거나, else if (m_BMI[i] >= 0)라고 하면 m_BMI[i]가 0일때! 즉, m[i]가 null일때도 if중괄호 안으로 들어가게됨!!
			//★null은 toString이 안되니까 NullPointerException에러가 뜸 -> m_BMI[i]가 0일때는 toString안걸리게 제외 해줘야함
				printBMI[5] += m[i].toString() + "\n";
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

	private int findMemberByNum() { //회원번호로 멤버찾기
		Scanner scan = new Scanner(System.in);
		int num  = scan.nextInt();
		for (int i = 0; i < blank(); i++) {
			if (num == m[i].getMemberID()) {
				return i;
			}
		}
		return -1; //indexOf에서 찾는 값 없으면 -1주듯이
	}
	
	private void delMember(int a) { //전달받은 인덱스 번호에 해당되는 애 삭제 후 땡기기
		while (a != 9) {
			m[a] = m[a+1];
			a++;
		}
		m[9] = null;
	}
	private String delMemberProgram() { //위에꺼 결합한 삭제프로그램 //return값 줘서 break역할하게...
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
				delMember(a);
				return "회원정보가 삭제되었습니다";
			} else {
				return "취소되었습니다";
			}
		}
	}
	
	private void menu() { //메뉴 출력 메소드
		System.out.println("=========회원관리프로그램=========");
		System.out.println("1. 회원등록");
		System.out.println("2. 회원목록");
		System.out.println("3. BMI별 회원목록");
		System.out.println("4. 회원삭제");
		System.out.println("5. 키 오름차순 정렬");
		System.out.println("6. 몸무게 오름차순 정렬");
		System.out.println("0. 종료");
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
			} else if (num == 3) {
				printBMIList();
			} else if (num == 4) {
				System.out.println(delMemberProgram()); //String으로 리턴되니깐 출력해줘야함
			} else if (num == 5) {
				arrHeight();
			} else if (num == 6) {
				arrWeight();
			} else if (num == 0) {
				break;
			} else {
				System.out.println("없는 메뉴입니다");
			}
		}
	}
	
}
public class T0615 {

	public static void main(String[] args) {
		Manager m = new Manager();
		m.programStart();
//		Member m = new Member(1, "김김김", 40 , 160);
//		Member m2 = new Member(2, "박박박", 50 , 170);
//		HeightComp2 a = new HeightComp2();
//		a = (HeightComp2) m; //downcating이라서 안된다~! 
	}

}

//==========학우 아이디어==========
//getData(String s)메소드: s 출력후 scan.nextLine()-> 이유: int가 들어가도 문자가 들어가도 오류 안남-> 처리: 1번2번 선택이면 parseInt, 이름검색같은건 걍 쓰고..
//전역변수로 selectnum을 정해놓고 걔를 계속 사용