import java.util.StringTokenizer;

//아이유씨가 금요일을 몇번 언급하였는가?
//시계는 몇 번 언급하였는가?
//
public class Main8 {

	public static void main(String[] args) {
		String friday = "월요일엔 아마 바쁘지 않을까\r\n" + 
				"화요일도 성급해 보이지 안 그래\r\n" + 
				"수요일은 뭔가 어정쩡한 느낌\r\n" + 
				"목요일은 그냥 내가 왠지 싫어\r\n" + 
				"우 이번 주 금요일\r\n" + 
				"우 금요일에 시간 어때요 oh\r\n" + 
				"주말까지 기다리긴 힘들어\r\n" + 
				"시간아 달려라 시계를 더 보채고 싶지만\r\n" + 
				"(Mind control)\r\n" + 
				"일분 일초가 달콤해\r\n" + 
				"이 남자 도대체 뭐야\r\n" + 
				"사랑에 빠지지 않곤 못 배기겠어 (못 배기겠어)\r\n" + 
				"온 종일 내 맘은 저기 시계바늘 위에 올라타\r\n" + 
				"한 칸씩 그대에게 더 가까이\r\n" + 
				"Na na na na na\r\n" + 
				"Na na na na na na\r\n" + 
				"Na na na na na\r\n" + 
				"La la la la la la la\r\n" + 
				"La la la la la la la la la\r\n" + 
				"우 이번 주 금요일\r\n" + 
				"우 금요일에 시간 어때요 oh\r\n" + 
				"딱히 보고 싶은 영화는 없지만\r\n" + 
				"딱히 먹고 싶은 메뉴는 없지만\r\n" + 
				"주말까지 기다리긴 힘들어\r\n" + 
				"시간아 달려라 시계를 더 보채고 싶지만\r\n" + 
				"(Mind control)\r\n" + 
				"일분 일초가 달콤해\r\n" + 
				"이 남자 도대체 뭐야\r\n" + 
				"사랑에 빠지지 않곤 못 배기겠어 (겠어)\r\n" + 
				"온 종일 내 맘은 저기 시계바늘 위에 올라타\r\n" + 
				"한 칸씩 그대에게 더 가까이\r\n" + 
				"나 뭔가에 홀린 것 같아\r\n" + 
				"이 여잔 도대체 뭐야\r\n" + 
				"사랑해주지 않고는 못 배기겠어\r\n" + 
				"돌아오는 이번 주 금요일에 만나요\r\n" + 
				"그 날 내 맘을 더 가져가줘요\r\n" + 
				"Na 더 가까이 (na na na na) 더 가까이\r\n" + 
				"Na na na na na na 더 가까이 더 가까이 와요\r\n" + 
				"Na na na na na 더 가까이\r\n" + 
				"La la la la la la la la la\r\n" + 
				"La la la la la la la la la";
		StringTokenizer st = new StringTokenizer(friday, "금요일"); //★통째로 금요일을 찾지 않고 금, 요, 일을 찾아댐
		
//		int count = 0;
//		while (st.hasMoreTokens()) {
//			count++;
//		}
//		System.out.println(count);
		//★hasMoreTokens()는 nextToken()과 세트이기 때문에 nextToken으로 빼내지 않으면 계속 같은 토큰을 찾아댐,,무한루프
		
//		String trash = "";
//		int count = 0;
//		while (st.hasMoreTokens()) {
//			trash += st.nextToken();
//			count++; //★얘도 마지막 token은 금요일 없어도 추가되니깐 -1해줘야함~!
//		}
//		System.out.println("금요일을 외친 횟수: " + (count - 1)); //이렇게 해도 결국은, 금, 요, 일을 찾은거라 내 의도와 다름
		//===============================
		//countTokens(); 구분자가 2개있으면 token은 세개니깐
//		System.out.println(stF.countTokens() - 1); //지금와서 쓰면 주머니에서 이미 다 꺼내놨기때문에 없음~!
//		System.out.println(stC.countTokens() - 1); //★nextToken()으로 빼내기 전에 사용해야함~!
		
		StringTokenizer st2 = new StringTokenizer(friday, " "); //일단 단어 단위로 나눈 나음,
		int count = 0;
		while (st2.hasMoreTokens()) {
			if (st2.nextToken().contains("금요일")) { //contains메소드 사용~!
				count++;
			}
		}
		System.out.println("금요일을 외친 횟수: " + count);
		
		friday.trim(); //문자열 좌우 공백 제거한 문자열 반환
	}

}
