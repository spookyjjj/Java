
public class TestStudent {
	public static void main(String[] args) {
		Student s1 = new Student("김방", 50, 80, 20);
		Student s2 = new Student("박구", 65, 65, 65);
		Student s3 = new Student("윤정", 80, 90, 95);
				
		Student s4 = new Student("홍이다", 100, 80, 100);
		Student s5 = new Student("정이여", 100, 100, 80);
		Student s6 = new Student("이임다", 95, 95, 90);
		
		Room myRoom = new Room(s1, s2, s3);
		myRoom.printAllStudent();
		System.out.println(myRoom.roomAver()); 
		System.out.println(myRoom.roomTop()); 
		System.out.println(myRoom.roomTop().getName()); 
		myRoom.top();
		myRoom.top2();
		
		System.out.println("------------");
		
		Room yourRoom = new Room(s4, s5, s6);
		yourRoom.printAllStudent();
		System.out.println(yourRoom.roomAver()); 
		System.out.println(yourRoom.roomTop()); 
		System.out.println(yourRoom.roomTop().getName()); 
		yourRoom.top();
		yourRoom.top2();
	}

}
