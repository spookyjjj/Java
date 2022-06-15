class Student {
	private String name;
	private int age;
}
interface ISayHi { //추상메소드만 가능
	void hi();
}
class Korean extends Student implements ISayHi {
	@Override
	public void hi() { //인터페이스 ISayHi 소속이면, 무조건 재정의 해야하는 메소드
		System.out.println("안녕");
	}
}
class British extends Student implements ISayHi {
	@Override
	public void hi() { //인터페이스 ISayHi 소속이면, 무조건 재정의 해야하는 메소드
		System.out.println("hello");
	}
}
class American implements ISayHi {
	@Override
	public void hi() { //인터페이스 ISayHi 소속이면, 무조건 재정의 해야하는 메소드
		System.out.println("wassup");
	}
}

public class InterfaceHi {
	public static void main(String[] args) {
		ISayHi s1 = new British();
		ISayHi s2 = new Korean();
		ISayHi s3 = new American();
		
		s1.hi();
		s2.hi();
		s3.hi();
		
		//★각자 다른 클래스 출신이라도, 공통으로 묶이는 Object 클래스가 있으니 배열로 묶을 수 있게됨~!
		Object[] arr = new Object[3];
		arr[0] = s1; //upcasting
		arr[1] = s2; //upcasting
		arr[2] = s3; //upcasting
//		for(int i = 0; i < 3; i++) {
//			arr[i].hi(); //(X) 왜냐면 object에 있는 메소드라고는 toSting하고 equals밖에 없다
//		}
		
		//★각자 다른 클래스 출신이라도, 공통으로 묶이는 interface가 있으니 배열로 묶을 수 있게됨~!
		ISayHi[] arr2 = new ISayHi[3];
		arr2[0] = s1; 
		arr2[1] = s2; 
		arr2[2] = s3; 
		for (int i = 0; i < 3; i++) {
			arr2[i].hi(); //(O) interface에 있는 메소드이기 때문에~!
		}
		
	}
}
