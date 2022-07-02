package Scratch;

public class FieldAndMethod {
	private String s;
	private String plus = s + "5"; //(X) 필드를 이렇게 쓰는거 안됨
//	private String plus; //(O) 그냥 선언만 해놓고
	private int doSomething() {
		int a = Integer.valueOf(plus); 
		return a;
	}
	public static void main(String[] args) {
		FieldAndMethod hey = new FieldAndMethod();
		hey.s = "2";
//		System.out.println(hey.plus); //★null5
//		hey.plus = hey.s + "5"; //필드에서 하고싶었던거 여기서 해라
		int result = hey.doSomething();
		System.out.println(result);

	}

}
