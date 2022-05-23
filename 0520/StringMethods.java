public class StringMethods {
	public static void main(String args[]) {
		String hello = "hellllo";
		
		int index = hello.indexOf("o"); //o라는 문자를 찾아서 index번호 불러줘
		System.out.println(index);

		int notFound = hello.indexOf("a"); 
		System.out.println(notFound); //없는 문자를 찾으라 하면 -1이라고 출력하여 없음을 표시
		
		int index2 = hello.indexOf("l", 4); //4번째 index부터 l을 찾아라
		System.out.println(index2);

		int index3 = hello.lastIndexOf("l"); //마지막 l을 찾아라 = 오른쪽에서 부터 찾아라
		System.out.println(index3);		
	}
}