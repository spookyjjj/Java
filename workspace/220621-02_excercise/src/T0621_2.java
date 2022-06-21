import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//일기관리프로그램
//일기(날짜, 제목, 날씨, 내용 등등등)

//일기등록
//같은 일자에는 일기 중복x

//일기목록도 볼 수 있음
//날짜순
//내용길이 순

//날짜를 선택해서 해당 일기 내용을 수정 가능

//삭제 - 가장 오래된 일기가 삭제됨
class Diary {
	private String date;
	private String title;
	private String weather;
	private String contents;
	
	public Diary(String date, String title, String weather, String contents) {
		this.date = date;
		this.title = title;
		this.weather = weather;
		this.contents = contents;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "diary=================\n날짜 : " + date + "\n제목 : " + title + "\n날씨: " + weather + "\n" + contents + "\n===============\n";
	}
}
public class T0621_2 {

	public static void main(String[] args) {
		Comparator<Diary> byDate = new Comparator<Diary>() { //날짜순으로 기본 정렬해둘거임
			@Override
			public int compare(Diary a, Diary b) {
				Integer dateA = Integer.parseInt(a.getDate());
				Integer dateB = Integer.parseInt(b.getDate());
				return  dateA - dateB;
			}
		};
		
		Scanner scan = new Scanner(System.in);
//		Scanner scanInt = new Scanner(System.in); //Int받는 스캐너를 따로만들면 둘이 혼선의 염려가 없어짐
		List<Diary> list = new ArrayList<>();
		int num = 0;
		while (num != 9) {
			try {
				System.out.println("========일기 프로그램=======");
				System.out.println("1. 작성");
				System.out.println("2. 목록(기본값 : 날짜 순서 정렬)");
				System.out.println("3. 내용길이 순서로 정렬");
				System.out.println("4. 일기보기");
				System.out.println("5. 수정");
				System.out.println("6. 제일 오래된 일자의 일기 삭제");
				System.out.println("9. 프로그램 종료");
				System.out.println("=======================");
				System.out.print("원하는 메뉴를 선택하세요 : ");
				num = scan.nextInt(); //예외처리 필요
				scan.nextLine(); 
				if (num == 1) {
					System.out.println("작성할 날짜? (yymmdd형식)");
					String date = scan.nextLine();
					Boolean newORnot = true;
					for(int i = 0; i < list.size(); i++) {
						if (list.get(i).getDate().equals(date)) {
							System.out.println("이미 해당 날짜에 일기가 작성되어 있습니다");
							newORnot = false;
							break;
						}
					}
					if(newORnot) {
						System.out.println("제목?");
						String title = scan.nextLine();
						System.out.println("날씨?");
						String weather = scan.nextLine();
						System.out.println("내용?");
						String contents = scan.nextLine();
						list.add(new Diary(date, title, weather, contents));
						
						Collections.sort(list, byDate); //추가후에는 정렬~!
					}
				}
				if (num == 2) {
					for (int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i).getDate() + " / " + list.get(i).getTitle());
					}
				}
				if (num == 3) {
					Comparator<Diary> byVolum = new Comparator<Diary>() {
						@Override
						public int compare(Diary a, Diary b) {
							return a.getContents().length() - b.getContents().length();
						}
					};
					ArrayList<Diary> sortbyVolum = new ArrayList<Diary>(list);
					Collections.sort(sortbyVolum, byVolum);
					for (int i = 0; i < sortbyVolum.size(); i++) {
						System.out.println(sortbyVolum.get(i).getDate() + " / " + sortbyVolum.get(i).getTitle() + " / " + sortbyVolum.get(i).getContents().length() + "글자");
					}
				}
				if (num == 4) {
					System.out.println("보고싶은 일기의 날짜를 입력해주세요");
					String date = scan.nextLine();
					int diaryIndex = -1;
					for(int i = 0; i < list.size(); i++) {
						if (list.get(i).getDate().equals(date)) {
							diaryIndex = i;
							break;
						}
					}
					if (diaryIndex == -1) {
						System.out.println("해당하는 날짜의 일기가 없습니다");
					} else {
						System.out.println(list.get(diaryIndex));
					}
				}
				if (num == 5) {
					System.out.println("수정하고싶은 일기의 날짜를 입력해주세요");
					String date = scan.nextLine();
					int diaryIndex = -1;
					for(int i = 0; i < list.size(); i++) {
						if (list.get(i).getDate().equals(date)) {
							diaryIndex = i;
							break;
						}
					}
					if (diaryIndex == -1) {
						System.out.println("해당하는 날짜의 일기가 없습니다");
					} else {
						System.out.println(list.get(diaryIndex));
						System.out.println("위 일기의 어느부분을 수정하고 싶습니까?");
						System.out.println("날짜, 제목, 날씨, 내용");
						String choose = scan.nextLine();
						if (choose.equals("날짜")) {
							String editDate = scan.nextLine();
							Boolean botton = true;
							for(int i = 0; i < list.size(); i++) {
								if (list.get(i).getDate().equals(editDate)) {
									System.out.println("이미 해당 날짜에 일기가 작성되어 있어 수정할 수 없습니다");
									botton = false;
									break;
								}
							}
							if (botton) {
								list.get(diaryIndex).setDate(editDate);
								System.out.println("수정완료");
								Collections.sort(list, byDate); //변경후에는 다시 날짜순 정렬~!
							}
						}
						if (choose.equals("제목")) {
							list.get(diaryIndex).setTitle(scan.nextLine());
							System.out.println("수정완료");
						}
						if (choose.equals("날씨")) {
							list.get(diaryIndex).setWeather(scan.nextLine());
							System.out.println("수정완료");
						}
						if (choose.equals("내용")) {
							list.get(diaryIndex).setContents(scan.nextLine());
							System.out.println("수정완료");
						}
					}
				}
				if (num == 6) {
					if (!list.isEmpty()) {
						list.remove(0);
						System.out.println("가장 오래전 일기가 삭제되었습니다");
					} else {
						System.out.println("지울 일기가 없습니다");
					}
				}
			} catch (Exception e) {
				System.out.println("숫자를 입력하셔야 합니다");
				scan.nextLine(); //★여기서 잘못 입력된 문자열을 받아 먹어서 삼켜줘야 없어짐,,,깨끗한 공란으로 만들기!!!!!
			}
		}
		System.out.println("프로그램 종료");
	}

}
