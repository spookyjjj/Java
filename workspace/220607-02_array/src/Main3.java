public class Main3 {
	public static void main(String[] args) {
		//실수 1.02, 0.03, 4.0
		double d1 = 1.02;
		double d2 = 0.03;
		double d3 = 4.0;
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		
		//배열로 줄여쓰기
//		double[] a = new double[] { 1.02, 0.03, 4.0 }; //★길이값을 적으면 컴파일에러! {}안을 읽어서 알아서 배당함
		double[] a = { 1.02, 0.03, 4.0 }; //이렇게 까지도 줄여진다~!
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
