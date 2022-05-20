public class StringEquals {
	public static void main(String args[]) {
		String a = "Hello";
		String b = "Hello";
		String llo = "llo";
		
		System.out.println(a == b); //참조형에서의 관계연산자는 참조하는 대상이 같은지(O)
		System.out.println(a == ("He" + llo)); //참조형에서의 관계연산자는 값이 같은지(X)
		
		System.out.println("-------문자열 값 동등 확인---------");
		System.out.println(a.equals("He" + llo)); //참조형에서 값이 같은지 알려면 equals메소드 사용 
	}
}