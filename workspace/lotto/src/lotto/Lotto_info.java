package lotto;

public class Lotto_info {
	
	int a = 0;
	private int[] oneGame = new int[6];
	private int[][] allGame = new int[5][6];
	
	
	
	public void guess() {
		for (int j = 0; j < allGame[a].length; j++) {
				
		}
		a++;
	}
	
	//몇번째 게임인지 알아내는 메소드
	public int fideGameNum() {
		return a;
	}
	
	//생성한 게임을 이중배열에 넣기??
	public void setGame(int[] oneGame) {
		allGame[a] = oneGame; 
	}
	
	
	public static void main(String[] args) {
		Lotto_info a = new Lotto_info();
		
		

	}

}
