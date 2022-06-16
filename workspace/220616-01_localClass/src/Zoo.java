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
class Herbivore {
	Animal[] herbivore = new Animal[0]; //육식동물만 담는 배열
	void setHerbivore(Animal a) { //육식동물 배열 업데이트
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
}
class Carnivore {
	Animal[] carnivore = new Animal[0];
	
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
}
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
class Tamer {
	Employee[] tamer = new Employee[0]; //조련사만
	void setTamer(Employee a) { //조련사 배열 업데이트
		if (a.getAssigned().equals("조련사")) {
			Employee[] copy = Arrays.copyOf(tamer, tamer.length + 1);
			copy[copy.length - 1] = a;
			tamer = copy;
		}
	}
//	private Animal[][] tamedAnimal = new Animal[0][0]; //첫줄이 tamer[0]의 담당동물 ..
//	private void setTamed(Animal a) { 
//		for(int i = 0; i < tamer.length; i++) {
//			if (tamer[i].getName().equals(a.getTamer())) {
//				Animal[] copy = Arrays.copyOf(tamedAnimal[i], tamedAnimal[i].length + 1);
//				copy[tamer.length - 1] = a;
//				tamedAnimal[i] = copy; 
//			}
//		}
//	}
	void showTamer() {
		for (Employee e : tamer) {
			System.out.println(e);
		}
	}
}
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
class Program {
	Herbivore h = new Herbivore();
	Carnivore c = new Carnivore();
	Tamer t = new Tamer();
	Manager m = new Manager();
	private void makeAnimal() {
		Scanner scan = new Scanner(System.in);
		System.out.println("동물 종, 무게, 나이, 주식, 담당자 순으로 입력하시오");
		Animal a = new Animal(scan.next(), Integer.parseInt(scan.next()),Integer.parseInt(scan.next()), scan.next(), scan.next());
		h.setHerbivore(a);
		c.setCarnivore(a);
	}
	private void showAnimal() {
		h.showHerbivore();
		c.showCarnivore();
	}
	public void running() {
		Scanner sacn = new Scanner(System.in);
		System.out.println("동물등록");
		makeAnimal();
		makeAnimal();
		System.out.println("초식동물보기");
		h.showHerbivore();
		System.out.println("육식동물보기");
		c.showCarnivore();
		System.out.println();
	}
}
public class Zoo {
	public static void main(String[] args) {
		Program p = new Program();
		p.running();
	}
}
