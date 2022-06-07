package first.second;

public class SamePackage {
	public static void main(String[] args) {
		AnotherClass a = new AnotherClass(); //import없이는 다른 패키지라서 인식못함
		a.number = 11;
//		a.mySecret = 22; //(X) private라서 안됨~!
		a.test = 33; //(O) 같은 패키지라서 접근가능 
	}
}
