import java.math.BigDecimal;
import java.math.BigInteger;

public class Main3 {

	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE); //9223372036854775807
				
		BigInteger value1 = new BigInteger("9223372036854775808"); //long범위 밖의 수도 문자열로는 넣을 수 있다!
		System.out.println(value1.add(new BigInteger("10"))); //더하기도 가능~ 단, 새로운 인스턴스에 더한값 넣어서 출력하므로
				
		System.out.println(value1); //기존 값은 안바뀐다!
		
				
		BigDecimal d = new BigDecimal(0.1); //0.1이 부정확한 애라서
		System.out.println(d); // 0.1000000000000000055511이렇게 나옴 -> 그래서 문자열로 넣어준다
		BigDecimal dec = new BigDecimal("0.1"); //이러면 그냥 0.1만 딱 나옴
		System.out.println(dec);
	}

}
