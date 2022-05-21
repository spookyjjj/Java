public class TypeConversion {
	public static void main(String args[]) {
		int i;
		double f;
		
		f = 5 / 4; //★정수끼리 계산으로 나온 정수를 실수박스에 담음 -> 확장 -> 1.0
		System.out.println(f);
		
		f = (double) 5 / 4; //실수 정수 계산으로 나온 값은 실수 따라감
		System.out.println(f);
		f = 5 / (double) 4;
		System.out.println(f);
		f = (double) 5 / (double) 4;
		System.out.println(f);
		
		f = (int) 1.3 + (int) 1.8; //실수를 정수로 형변환 -> 축소(소수점을 떼버림) -> 2.0
		System.out.println(f);
		f = (int) (1.3 + 1.8); //-> 3.0
		System.out.println(f);
	}
}