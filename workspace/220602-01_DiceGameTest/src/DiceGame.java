import java.util.Scanner;
public class DiceGame {
	int diceFace;
	int userGuess;
	
	private void rollDice() { //내부에서 작동되는 애들은 private로 감춰둠
		diceFace = (int) (Math.random() * 6) + 1;
	}
	private int getUserInput(String prompt) {
		System.out.println(prompt);
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	private boolean checkUserGuess() {
		if (diceFace == userGuess) {
			System.out.println("맞았습니다");
			return true;
		}
		else {                            
			System.out.println("틀렸습니다");
			return false;
		}
	}
	public void startPlaying() { //외부에서 호출되야 하는 애는 public하게 공개
		while (true) {
			userGuess = getUserInput("예상값을 입력하시오: ");
			rollDice();
			if (checkUserGuess()) {
				break;
			}
		}
	}
}