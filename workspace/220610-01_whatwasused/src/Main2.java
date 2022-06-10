
public class Main2 {

	public static void main(String[] args) {
		//Wrapping을 하는 이유?!
		int number1 = 10;
		int number2 = 50; //대소 비교을 위해서는 구구절절 코드 짜야함
		
		Integer refNumber = Integer.valueOf(10); //-> 객체가 되었기 때문에 int에 관련된 다양한 메소드(행동)들을 사용할 수 있게됨
		refNumber.compareTo(20); //대소 비교가 그냥 메소드 한방으로 처리됨ㅎㅎ
		
		Integer.max(10, 200); //이런것도 있다~
		
		
		//Wrapper class : 원시형을 참조형으로!!!!
//		Byte
//		Short
//		Integer //Int(X)
//		Float
//		Double
//		Character //Char(X)
//		Boolean
		
		int number = 22; //int는 원시형
		Integer i = new Integer(10); //하지만 Wrapper class를 통해 객체로 만들어 줄 수도 있다
//		System.out.println(i);
		Integer i2 = Integer.valueOf(500); //boxing : 뉴 어쩌구 하는 과정은 이 메소드로 대체 가능~
		int primitiveInt = i2.intValue(); //unboxing
		System.out.println(primitiveInt);
		
		//매번 위의 과정을 거치기 번거로우니 java에서 자동으로 해줌
		Integer auto = 100; //auto-boxing
		int un = auto; //auto-unboxing
		
		Integer value = Integer.valueOf("5959"); //int말고 String도 valueOf의 파라미터가 됨
		int result = Integer.valueOf("1234"); //얘는 인티저의 참조!!!!! -> 자동 언박싱
		
		Integer.parseInt("4567"); //얘는 아예 String!!!! -> Int형으로 반환하는 메소드
	}

}
