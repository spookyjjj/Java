import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

//중국집 주문 가격 계산기

//짜장면 2500
//짬뽕 4000
//볶음밥 4000

//메뉴를 추가

//계산결과 출력가능
public class T0622_2 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		Map<String, Integer> menu = new HashMap<>();
		menu.put("짜장면", 2500);
		menu.put("짬뽕", 4000);
		menu.put("볶음밥", 4000);
		// 갯수 map을 따로 또 만든다?????
		Map<String, Integer> howMany = new HashMap<>();
		howMany.put("짜장면", 0);
		howMany.put("짬뽕", 0);
		howMany.put("볶음밥", 0);
		int num = 0;
		while (num != 9) {
			try {
				System.out.println("====중국집메뉴=====");
				System.out.println(menu); 
				Set<Entry<String, Integer>> entrySet = menu.entrySet(); // ★entrySet()이라는 메소드는 Entry를 반환함
				for (Entry<String, Integer> e : entrySet) {
					System.out.println(e.getKey() + " : " + e.getValue());
				}
				System.out.println("===============");

				System.out.println("1.음식주문");
				System.out.println("2.메뉴추가");
				System.out.println("9.프로그램 종료");
				System.out.print("번호 입력하시오");
				num = scan.nextInt();
				scan.nextLine();

				if (num == 1) {
					int sum = 0;
					int num2 = 1;
					while (num2 == 1) {
						System.out.println("주문할메뉴?");
						String name = scan.nextLine();
						if (menu.containsKey(name)) {
							sum += menu.get(name);
							howMany.put(name, howMany.get(name) + 1);//개수 추가하기
							System.out.println("1.계속주문? 2.계산서받기?");
							num2 = scan.nextInt();
							scan.nextLine();
							if (num2 == 1) {
							} else if (num2 == 2) {
								System.out.println("========계산서========");
								//개수 map 출력
								Set<String> keySet = howMany.keySet(); 
								for (String s : keySet) { 
									System.out.println(s + " : " + howMany.get(s) + "개");
								}
								System.out.println(sum);
								System.out.println("===================");
								//개수 map 초기화
								for (String s : keySet) { 
									howMany.put(s, 0);
								}
							} else {
								System.out.println("없는 번호입니다");
							}
						} else {
							System.out.println("해당하는 메뉴가 없습니다");
						}
					}

				}
				if (num == 2) {
					System.out.println("메뉴이름?");
					String name = scan.nextLine();
					if (!menu.containsKey(name)) {
						System.out.println("가격?");
						int price = scan.nextInt();
						scan.nextLine();
						menu.put(name, price);
						howMany.put(name, 0); //개수 map도 초기화
						System.out.println("추가되었습니다");
					} else {
						System.out.println("이미 메뉴판에 있는 품목입니다");
					}
				}
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다");
				scan.nextLine();
			}

		}
	}
}
