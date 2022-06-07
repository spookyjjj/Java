package first;

import first.second.AnotherClass;

public class UpperPackage {

	public static void main(String[] args) {
		AnotherClass a = new AnotherClass();
		a.number = 11;
//		a.mySecret = 22; //(X) private라서 안됨~!
//		a.test = 33; //(X) 상위 패키지라도, 결국은 다른 패키지라서 접근 안됨~!
	}

}
