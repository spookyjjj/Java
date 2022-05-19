public class CharTypes {
	public static void main(String args[]) {
		char a = 'a'; // ""쌍따옴표(X), ''홑따옴표 안에는 한 글자만!
		char b = 'b';
		char ga = '가';
		char num1 = '1';
		System.out.println(a);
		System.out.println(b);
		System.out.println(ga);
		System.out.println(num1);
		
		char what = 65; //내부에 약속된 65번째에 있는 문자(A)를 가져옴. 숫자로 인식X
		char what2 = 97; //내부에 약속된 65번째에 있는 문자(a)를 가져옴. 숫자로 인식X
		System.out.println(what);
		System.out.println(what2);
		System.out.println(what + a); //char에 연산자(+-*/)를 넣으면 숫자로 바꿔서 숫자값을 출력함~
	}
}