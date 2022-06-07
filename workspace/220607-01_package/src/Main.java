import first.InPackageClass;
import first.second.AnotherClass;

public class Main {

	public static void main(String[] args) {
		InPackageClass test = new InPackageClass(); //import없이는 다른 패키지라서 인식못함
		
		AnotherClass test2 = new AnotherClass(); //import없이는 다른 패키지라서 인식못함
		test2.number = 11;
//		test2.mySecret = 22; //(X) private라서 안됨~!
//		test2.test = 33; //(X) 다른 패키지라서 접근 안됨~!
	}

}
