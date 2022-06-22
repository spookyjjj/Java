import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Morse {

	public static void main(String[] args) {
		Map<Character, String> map = new HashMap<>();
	      map.put('A', "ㆍ－");
	      map.put('B', "－ㆍㆍㆍ");
	      map.put('C', "－ㆍ－ㆍ");
	      map.put('D', "－ㆍㆍ");
	      map.put('E', "ㆍ");
	      map.put('F', "ㆍㆍ－ㆍ");
	      map.put('G', "－－ㆍ");
	      map.put('H', "ㆍㆍㆍㆍ");
	      map.put('I', "ㆍㆍ");
	      map.put('J', "ㆍ－－－");
	      map.put('K', "－ㆍ－");
	      map.put('L', "ㆍ－ㆍㆍ");
	      map.put('M', "－－");
	      map.put('N', "－ㆍ");
	      map.put('O', "－－－");
	      map.put('P', "ㆍ－－ㆍ");
	      map.put('Q', "－－ㆍ－ ");
	      map.put('R', "ㆍ－ㆍ ");
	      map.put('S', "ㆍㆍㆍ");
	      map.put('T', "－ ");
	      map.put('U', "ㆍㆍ－");
	      map.put('V', "ㆍㆍㆍ－");
	      map.put('W', "ㆍ－－ ");
	      map.put('X', "－ㆍㆍ－ ");
	      map.put('Y', "－ㆍ－－ ");
	      map.put('Z', "－－ㆍㆍ");
	      
	      //모스부호 반환 프로그램
	      
	      //SOS -> ㆍㆍㆍ －－－ ㆍㆍㆍ
	      Scanner scan = new Scanner(System.in);
	      System.out.println("대문자 단어를 쓰면 모스부호로 변환됩니다");
	      String input = scan.nextLine();
	      String output = "";
	      for (int i = 0; i < input.length(); i++) {
	    	  char c = input.charAt(i);
	    	  output += map.get(c) + " ";
	      }
	      System.out.println(input + "의 모스부호: " + output);
	      
	}

}
