//콘솔 입출력
//진열대는 최대 10개
//과일 목록 보여주기
//과일 주기(제일 앞의것)
//과일 추가(제일 뒤에)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T0620_4 {
	 static int getNum(String s) {
		 int num = -444;
		 while (num == -444) {
			 try {
				 Scanner scan = new Scanner(System.in);
				 System.out.println(s);
				 num =  scan.nextInt();
			 } catch (Exception e) {
				 System.out.println("숫자를 입력하세요");
				 num = -444;
			 }
		 }
		 return num;
	 }
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>(Arrays.asList("사과", "포도", "오렌지", "배", "수박"));
		int num = 0;
		while (num != 4) {
			System.out.println("=====과일가게=====");
			System.out.println("1. 과일목록");
			System.out.println("2. 과일 받기(선입선출)");
			System.out.println("3. 과일 주기(맨 뒤에 추가)");
			System.out.println("4. 프로그램 종료");
			num = getNum("원하시는 메뉴를 선택하세요");
			if (num == 1) {
				System.out.println(list);
			}
			if (num == 2) {
				System.out.println(list.get(0) + " 가져가세요");
				list.remove(0);
				System.out.println("진열대 위의 과일 수: " + list.size());
			}
			if (num == 3) {
				if (list.size() >= 10) {
					System.out.println("진열대가 꽉 찼습니다(최대 10개)");
				} else {
					Scanner scan = new Scanner(System.in);
					System.out.println("추가할 과일 이름?");
					list.add(scan.next());
					System.out.println("추가 되었습니다");
					System.out.println("진열대 위의 과일 수: " + list.size());
				}
			}
		}
		
		
	}

}
