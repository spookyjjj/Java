
public class Main6 {
	public static void someMethod(int[] arr) { //배열 없었으면 someMethod(int a, int b, int c...) 이랬을거임;;
		for (int number : arr) {
			System.out.println(number);
		}
	}
	public static void someMethod2(int... arr) { //★...을쓰면 가변길이 파라미터~!
		for (int number : arr) {
			System.out.println(number);
		}
	}
	public static void someMethod3(double d, int... arr) { //...도 쓰면서 파라미터 여러개일땐, 맨 마지막에 ..가 오도록! someMethod3(int... arr, double d)는 X
		System.out.println(d);
		for (int number : arr) {
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		
		someMethod(arr);
		someMethod(new int[] {20, 30, 40, 50, 60}); //int배열만이 메소드에 들어갈 수 있다
//		someMethod({20, 30, 40, 50, 60}); //이렇게 줄여쓰는거는 배열의 선언과 초기화에서나 쓰는것
		System.out.println("------");
		someMethod2(new int[] {4, 5, 6}); //★...을쓰면 배열 자기가 만들어도 OK
		someMethod2(20, 30, 40, 50, 60); //★굳이 안만들어도, 알아서 배열로 바꿔줘서 OK
		System.out.println("------");
		someMethod3(80, 90, 50, 70, 60); //80은 실수형, 나머지는 int로~
	}

}
