public class {
	public static void main(String args[]) {
		String a = "Hello";
		String b = "Hello"; //★문자열마다 각 공간을 주는게 맞지만, 공간 절약을 위해 컴파일러가 같은 문자열임을 인식하면 같은 공간으로~ ->같은 참조~ 
		String llo = "llo";
		
		System.out.println(a == b); //참조형에서의 관계연산자는 참조하는 대상이 같은지(O)
		System.out.println(a == ("He" + llo)); //참조형에서의 관계연산자는 값이 같은지(X)
		
		System.out.println("-------문자열 값 동등 확인---------");
		System.out.println(a.equals("He" + llo)); //★참조형에서 값이 같은지 알려면 equals메소드 사용 
	}
}