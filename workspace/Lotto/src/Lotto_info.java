import java.util.Arrays;

public class Lotto_info {

	public static int[] oneGame = new int[6];
	public static int[][] allGame = new int[5][6];
	private static int[] zero = new int[] { 0, 0, 0, 0, 0, 0 };

	public static int[] winnigNum = new int[] { 12, 13, 34, 40, 42, 45 }; // 당첨 번호 배열
	public static int bonus = 27;

	public static int money = 5000; // 기본 소지금 5000원

	// 길대수 1. oneGame 값 확인 후 다 차있는지 확인하는 메소드
	public static boolean checkOneGame() { // 한개라도 0이면 안차있는거
		for (int i = 0; i < oneGame.length; i++) {
			if (oneGame[i] == 0) {
				return false;
			}
		}
		return true;
	}

	// allGame 5게임 중 빈 index확인해서 return하는 메소드
	public static int findGameNum() {
		for (int i = 0; i < allGame.length; i++) {
			if (Arrays.equals(allGame[i], zero)) { // zero 참조인 게임 == 새게임
				return i; // 얘가 들어갈 게임num
			}
		}
		return -1; // 꽉차있으면 -1을 반환
	}

	// oneGame 중 빈 index확인해서 return하는 메소드 (효)
	public static int findIndexNum() {
		for (int i = 0; i < oneGame.length; i++) {
			if (oneGame[i] == 0) {
				return i;
			}
		}
		return -1; // 꽉차서 공란을 못 찾으면 -1반환
	}

	// oneGame이 완전 비어있는지 확인해서 boolean으로 리턴 (효)
	public static boolean isArrEmpty(int[] arr) {
		for (int a : arr) {
			if (a != 0) {
				return false;
			}
		}
		return true;
	}

	// allGame이 완전 비어있는지 확인해서 boolean으로 리턴 (효)
	public static boolean isArrsEmpty(int[][] arrs) {
		for (int[] a : arrs) {
			if (!isArrEmpty(a)) {
				return false;
			}
		}
		return true;
	}

	// oneGame초기화 하는 메소드
	public static void resetOneGame() {
		oneGame = Arrays.copyOf(zero, 6);
//		oneGame = zero; // 이거쓰면 안됨
	}

	// 빈 게임의 index를 파라미터로 받아서, oneGame을 allGame의 해당 index에 넣는 메소드
	public static void oneGameToAllGame(int index) {
		allGame[index] = Arrays.copyOf(oneGame, 6);
//		allGame[index] = oneGame; // 이거쓰면 안됨		
	}

	// allgame의 해당 익덱스 값을 oneGame으로 옮기는 메소드
	public static void allGameToOneGame(int index) {
		Lotto_info.oneGame = Arrays.copyOf(Lotto_info.allGame[index], 6);
	}

	// 게임의 btns를 파라미터로 받아서, arr값을 버튼위에 출력하는 메소드 (효)
	public static void arrToButton(int[] arr, RoundedButton[] btns) {
		if (arr.length == btns.length) {
			for (int i = 0; i < 6; i++) {
				// 0705 김효정~~~~~~~~~~
				int num = arr[i];
				if (num == 0) {
					btns[i].setText("");
				} else {
					btns[i].setText(String.valueOf(num));
				}
			}
		}
	}

	// 게임의 btns를 파라미터로 받아서, 그 값을 arr에 채우는 메소드
	public static void buttonToArr(RoundedButton[] btns, int[] arr) {
		if (arr.length == btns.length) {
			for (int i = 0; i < 6; i++) {
				String s = btns[i].getText();
				if (s.equals("")) {
					arr[i] = 0;
				} else {
					arr[i] = Integer.valueOf(s);
				}
			}
		}
	}

	// allGame, oneGame 초기화
	public static void resetGame() {
		// allGame 초기화
		for (int i = 0; i < allGame.length; i++) {
			allGame[i] = Arrays.copyOf(zero, 6);
		}
		// oneGame 초기화
		oneGame = Arrays.copyOf(zero, 6);
	}
}
