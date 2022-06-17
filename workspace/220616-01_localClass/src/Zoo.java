import java.util.Arrays;
import java.util.Scanner;

//동물원 관리 프로그램
//동물 - 종, 나이, 무게
//직원 - 역할(조련사, 경영 등등), 이름
//조련사는 동물을 담당
//동물은 육식/초식
//주식으로 분류하여 동물목록보기
//조련사 담당에 따라 동물목록보기 (담당자 없는 동물도 볼 수 있어야 함)
//추가기능이 생겼을때도 동작할 수 있게

class Animal {
	private String species;
	private double wight;
	private int age;
	private String feed;
	private String tamer;
	
	public Animal(String species, double wight, int age, String feed) {
		this.species = species;
		this.wight = wight;
		this.age = age;
		this.feed = feed;
	}
	public Animal(String species, double wight, int age, String feed, String tamer) {
		this.species = species;
		this.wight = wight;
		this.age = age;
		this.feed = feed;
		this.tamer = tamer;
	}
	public String getSpecies() {
		return species;
	}
	public double getWight() {
		return wight;
	}
	public int getAge() {
		return age;
	}
	public String getFeed() {
		return feed;
	}
	public String getTamer() {
		return tamer;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public void setWight(double wight) {
		this.wight = wight;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setFeed(String feed) {
		this.feed = feed;
	}
	public void setTamer(String tamer) {
		this.tamer = tamer;
	}
	@Override
	public String toString() {
		return "Animal [species=" + species + ", wight=" + wight + ", age=" + age + ", feed=" + feed + ", tamer="
				+ tamer + "]";
	}
	
}
class ZooAnimal {
	private static Animal[] zooAnimal = new Animal[0]; //동물원 전체 동물 담는 배열
	private static Animal[] herbivore = new Animal[0]; //초식동물만 담는 배열
	private static Animal[] carnivore = new Animal[0]; //육식동물만 담는 배열
	void setZooAnimal(Animal a) { //초식동물 배열 업데이트
		Animal[] copy = Arrays.copyOf(zooAnimal, zooAnimal.length + 1);
		copy[copy.length - 1] = a;
		zooAnimal = copy;
	}
	void showZooAnimal() {
		for (Animal a : zooAnimal) {
			System.out.println(a);
		}
	}
	
	void setHerbivore(Animal a) { //초식동물 배열 업데이트
		//foodsorage 객체생성 후 grass[]의 스트링과 같을때 by for문
		if (a.getFeed().equals("풀")) {
			Animal[] copy = Arrays.copyOf(herbivore, herbivore.length + 1);
			copy[copy.length - 1] = a;
			herbivore = copy;
		}
	}
	
	void showHerbivore() {
		for (Animal a : herbivore) {
			System.out.println(a);
		}
	}
	
	void setCarnivore(Animal a) { //육식동물 배열 업데이트
		//foodsorage 객체생성 후 grass[]의 스트링과 같을때 by for문
		if (a.getFeed().equals("고기")) {
			Animal[] copy = Arrays.copyOf(carnivore, carnivore.length + 1);
			copy[copy.length - 1] = a;
			carnivore = copy;
		}
	}
	void showCarnivore() {
		for (Animal a : carnivore) {
			System.out.println(a);
		}
	}
	
	void showNullAnimal() {
		for (Animal a : zooAnimal) {
			if (a.getTamer() == null) {
				System.out.println(a);
			}
		}
	}
	
	//동물 이름으로 동물배열의 인덱스찾기
	int findIndexAnimal(String s) {
		for (int i = 0; i < zooAnimal.length; i++) {
			if (zooAnimal[i].getSpecies().equals(s)) {
				return i;
			}
		}
		return -1;
	}
	
}


//===========================================================
class Employee {
	private String name;
	private String assigned;
	
	public Employee(String name, String assigned) {
		this.name = name;
		this.assigned = assigned;
	}
	public String getName() {
		return name;
	}
	public String getAssigned() {
		return assigned;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", assigned=" + assigned + "]";
	}
}

//=============================================
class Tamer {
	private static Employee[] tamer = new Employee[1]; //조련사만
//	private static Animal[] tamerGotAnimal = new Animal[0];
//	이렇게 조련사별 동물 목록을 또 따로 만들어줘버리면 조련사 등록될때마다 필드가 등록되어야 하는 문제점
//	그래서 걍 맘속으로만 저기 1번이 여기 1번이다~라고 여겨버림...
	private static Animal[][] tamedAnimal = new Animal[1][0]; //첫줄이 사육사 없는 놈, 둘째줄은 tamer[0] 담당동물 ..

	
	public Employee[] getTamer() {
		return tamer;
	}

	public Animal[][] getTamedAnimal() {
		return tamedAnimal;
	}

	public void setTamer(Employee[] tamer) {
		Tamer.tamer = tamer;
	}

	public void setTamedAnimal(Animal[][] tamedAnimal) {
		Tamer.tamedAnimal = tamedAnimal;
	}

	void setTamer(Employee e) { //조련사 배열 업데이트
		if (e.getAssigned().equals("조련사")) {
			//이름을 검색해서 같은 애가 없다면 과정이 필요!!-> 조련사배열에 추가하고, 조련동물배열에도 칸 추가
			Employee[] copy = Arrays.copyOf(tamer, tamer.length + 1);
			copy[copy.length - 1] = e;
			tamer = copy;
			//그리고 조련사 명수에 맞춰서 tamedAnimal배열 줄수도 늘려주는 과정 필요!
			Animal[][] copy2 = Arrays.copyOf(tamedAnimal, tamedAnimal.length + 1); //뭐 넣을것도 없이 칸만 증가시키면 됨
			copy2[copy2.length - 1] = new Animal[0];
			tamedAnimal = copy2;
		}
		
	}

	void showTamer() {
		for (int i = 1; i < tamer.length; i++) {
			System.out.println(tamer[i]);
		}
	}
	
	//조련사 이름으로 조련사배열의 인덱스 알아내기 -> 조련사 배열 인덱스 대로 조련된 동물 이중배열 만들었기때문에
	int findTamerByName(String s) {
		for (int i = 1; i < tamer.length; i++) { //1한건, 0번이 배정없는 동물란이라서
			if (tamer[i].getName().equals(s)) {
				return i;
			}
		}
		if(s.equals("")) { //조련사이름 검색이 공란이면, 배정되지 않은 동물들 보기
			return 0;
		}
		return -1; //동일한 이름의 조련사가 없는 경우에는 -1값 리턴
	}
	void showTamedAnimal(String s) { //해당 조련사의 동물 보기
		int num = findTamerByName(s);
		if (num == -1) {
			System.out.println("해당 조련사가 없습니다");
		} else {
			for (Animal a : tamedAnimal[num]) {
				System.out.println(a);
			}
		}
	}
	void showAllTamedAnimal() { //해당 조련사의 동물 보기
		System.out.println(Arrays.deepToString(tamedAnimal));
	}
	void setTamed(Animal a) { 
		if (a.getTamer() == null) { //조련사 없는 동물들은 tamedAnimal[0], 즉 첫줄에 다 넣음
			Animal[] copy = Arrays.copyOf(tamedAnimal[0], tamedAnimal[0].length + 1);
			copy[copy.length - 1] = a;
			tamedAnimal[0] = copy; 
		} else {
			int num = findTamerByName(a.getTamer());
			Animal[] copy = Arrays.copyOf(tamedAnimal[num], tamedAnimal[num].length + 1); //조련사란에 동물 하나 집어넣고
			copy[copy.length - 1] = a;
			tamedAnimal[num] = copy; 
		}
	}
}

//================================================
class Manager {
	Employee[] manager = new Employee[0]; //관리자만
	void setManager(Employee a) { //관리자 배열 업데이트
		if (a.getAssigned().equals("관리자")) {
			Employee[] copy = Arrays.copyOf(manager, manager.length + 1);
			copy[copy.length - 1] = a;
			manager = copy;
		}
	}
}


//===================================================
class Program {
	ZooAnimal z = new ZooAnimal();
	Tamer t = new Tamer();
	Manager m = new Manager();
	
	private void makeAnimal() {
		Scanner scan = new Scanner(System.in);
		System.out.println("동물 종, 무게, 나이, 주식, 담당자 순으로 입력하시오");
		System.out.println("담당자가 지정되지 않았다면 엔터로 넘겨주세요");
		Animal a = new Animal(scan.next(), Integer.parseInt(scan.next()),Integer.parseInt(scan.next()), scan.next());
		String s = scan.next();
		if (!s.equals("")) {
			a.setTamer(s);
		}
		z.setZooAnimal(a);
		z.setHerbivore(a);
		z.setCarnivore(a);
		t.setTamed(a);
	}
	private void makeEmployee() {
		Scanner scan = new Scanner(System.in);
		System.out.println("직원의 이름과 할당된 업무를 입력해주세요");
		Employee e = new Employee(scan.next(), scan.next());
		t.setTamer(e);
		m.setManager(e);
	}

	//동물을 조련사에게 담당시키는 메소드
//	private void animalToTamer() {
//		Scanner scan = new Scanner(System.in);
//		String s;
//		int num;
//		System.out.println("할당되지 않은 동물 목록입니다");
//		System.out.println("할당을 시작할 동물의 이름을 입력해 주세요");
//		s = scan.next();
//		num = z.findIndexAnimal(s);
//		if (num == -1) {
//			System.out.println("해당하는 동물이 없습니다");
//		} else {
//			System.out.println("할당한 조련사 이름을 입력해 주십시오");
//			s = scan.next();
//			num = t.findTamerByName(s);
//			if (num == -1) {
//				System.out.println("해당하는 조련사가 없습니다");
//			} else {
//				Animal[] copy = Arrays.copyOf(t.getTamedAnimal()[num], tamedAnimal[num].length + 1); //조련사란에 동물 하나 집어넣고
//				copy[copy.length - 1] = a;
//				tamedAnimal[num] = copy; 
//			}
//		}
//		
//	}
	
	//배열 싹다 보여주는 메소드
	private void showArr() {
		z.showZooAnimal();
		z.showCarnivore();
		z.showHerbivore();
		t.showTamer();
		t.showAllTamedAnimal();
	}
	//조련사별 담당동물보기
	private void showTamedAnimalRun() { 
		Scanner scan = new Scanner(System.in);
		System.out.println("담당하는 동물을 보고싶은 조련사의 이름을 입력하세요");
		System.out.println("배정되지 않은 동물을 보고싶다면 공란을 입력");
		t.showTamedAnimal(scan.next());
	}
	public void running() {
		Scanner sacn = new Scanner(System.in);
		System.out.println("직원등록");
		makeEmployee();
		makeEmployee();
		showArr();
		System.out.println("동물등록");
		makeAnimal();
		makeAnimal();
		System.out.println("모든동물보기");
		z.showZooAnimal();
		System.out.println("초식동물보기");
		z.showHerbivore();
		System.out.println("육식동물보기");
		z.showCarnivore();
		System.out.println("조련사별 담당동물보기");
		showTamedAnimalRun();
	}
}
public class Zoo {
	public static void main(String[] args) {
		Program p = new Program();
		p.running();
	}
}
