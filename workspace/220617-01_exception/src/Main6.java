import java.util.StringJoiner;

public class Main6 {

	public static void main(String[] args) {
		String str = "원본문자열";
		String other = "다른문자열";
		String origin = "원본문자열";
		
		System.out.println(str == origin); //이건 엄밀히 말하자면 다른 참조이지만, 같은 값이면 메모리 절약을 위해 같은 참조로 연결해버림
		
		String conorigin = "원본문자열다른문자열";
		String concat = str + other;
	
		System.out.println(concat);
		System.out.println("원본문자열다른문자열" == concat); //참조가 달라서 false
		System.out.println(conorigin == concat); //원래부터 그 문자인 것과 합연산으로 하나가 된 아이는 메모리절약이고 뭐고 같은 참조 아님 false
	
		//그렇다면 합연산을 통한 애조차도 값이 같으면 같은 참조공간으로 연결시켜주는 애는 없을까?? for 메모리 절약
		//=================StringBuilder
		StringBuilder sb = new StringBuilder("원본");
		sb.append(",one=");
		sb.append(1);
		sb.append(", doublevalue=");
		sb.append(225.0);
		String result = sb.toString();
		System.out.println(result);
	
		//저걸 더 줄일 수 있음!
		sb.append("이건").append("계속").append("추가됨").append(77777);
		String result2 = sb.toString();
		System.out.println(result2);
		
		//sb.해보면 다양한 StringBuilder메소드들 존재!
		//애는 구성자체가 char[]임~! 그러니깐 인덱스 선택해서 삭제도 되고 역순출력도 되고
//		sb.replace(start, end, str); 
//		sb.setCharAt(index, ch);
//		sb.insert(offset, str);
		
		//똑같은 기능을 가지고 있지만 멀티스레드에서 안정적(대신 좀 느림)인 애로,
		//=============StringBuffer
		StringBuffer sbuffer;
		
		//문자열을 좀더 예쁘게 꾸미며 쓸 수 있는 애로,
		//============StringJoiner
		StringJoiner sj = new StringJoiner(","); //사이사이를 인식해서 사이에만 쉼표 넣어줌~!
//		StringJoiner sj = new StringJoiner(",", "[", "]"); //사이, 처음, 끝
		sj.add("1");
		sj.add("2");
		sj.add("3");
		String result3 = sj.toString();
		System.out.println(result3);
		System.out.println(sj); //StringJoiner클래스에도 toString이 있으니 sj만 넣고 출력해도 가능~!
	}

}
