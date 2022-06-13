class Employee {
	public String name; //공용멤버
	String address; //패키지멤버
	protected int salary; //보호멤버
	private int RRN; //전용멤버
	
	public Employee(String name, String address, int salary, int rRN) {
		this.name = name;
		this.address = address;
		this.salary = salary;
		RRN = rRN;
	}
	
	public Employee() {}
	
	public String toString() {
		return name + ", " + address + "," + RRN + ", " + salary;
	}
}

class Manager extends Employee {
	private int bonus;
	
	public Manager(String name, String address, int salary, int rRN, int bonus) {
		super(name, address, salary, rRN);
		this.bonus = bonus;
	}
	
	public Manager() {}
	
	public void printSalary() {
		System.out.println(name + "(" + address + "):" + (salary + bonus)); //private빼고는 전부 자식이 접근 가능
	}
	
	public void printRRN() {
//		System.out.println(RRN); //private는 자식이라도 접근 안됨!
	}
}
public class ManagerTest {
	public static void main(String[] args) {
		Manager m = new Manager("박관리", "김해시", 2500, 850805, 1000);
		m.printRRN();
	}

}
