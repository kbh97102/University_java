package homework2;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

class Player{	
	private String name;
	private ArrayList<String> userWord = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setWordFromUser(String word) {
		this.userWord.add(word);
	}
	public String getLastWrodFromUser() {
		return userWord.get(userWord.size()-1);
	}
	public char getWordFirstChar() {
		return userWord.get(userWord.size()-1).charAt(0);
	}
	public String getWord(int index) {
		return userWord.get(index);
	}
	public boolean checkSuccess(String lastWord) {
		boolean check = false;
		int lastIndex = lastWord.length()-1;
		char lastChar = lastWord.charAt(lastIndex);
		char firstChar = getWordFirstChar();
		if(firstChar == lastChar) {
			check = true;
		}
		else {
			check = false;
		}
		return check;
	}
	public boolean checkOverlap(Player[] players, int userIndex) {
		boolean check = false;
		
		String userWord = this.getLastWrodFromUser();
		for(int i=0;i<players.length;i++) {
			if(userIndex == i) {
				for(int j=0;j<players[i].userWord.size()-1;j++) {
					String compareWord = players[i].getWord(j);
					if(userWord.equals(compareWord) == true) {
						check = true;
						break;
					}
				}
			}
			else {
				for(int j=0;j<players[i].userWord.size();j++) {
					String compareWord = players[i].getWord(j);
					if(userWord.equals(compareWord) == true) {
						check = true;
						break;
					}
				}
			}
		}
		
		return check;
	}
	public Player(String name) {
		super();
		this.name = name;
	}
	
}


public class WordGameApp extends Player {

	public WordGameApp(String name) {
		super(name);
	}
	public static void run() {
		Scanner scan = new Scanner(System.in);
		System.out.println("끝말잇기 게임을 시작합니다.");
		System.out.print("게임에 참가하는 인원은 몇명입니까?");
		int numOfPlayer = scan.nextInt();
		Player []players = new Player[numOfPlayer];
		try {
			for(int i=0;i<numOfPlayer;i++) {
				System.out.print("참가자의 이름을 입력하세요>>");
				String name = scan.next();
				players[i] = new Player(name);
			}
		}
		catch(InputMismatchException e) {
			System.out.println("이름을 입력하세요");
		}
		String lastWord = "아버지";
		System.out.println("시작단어는 "+lastWord+"입니다.");
		int index = 0;
		while(true) {
			try {
				System.out.print(players[index].getName()+">>");
				players[index].setWordFromUser(scan.next());
				if(players[index].checkOverlap(players, index) == true) {
					System.out.println("중복된 단어를 입력했습니다.");
					System.out.print(players[index].getName()+"이 졌습니다.");
					break;
				}
				else if(players[index].checkSuccess(lastWord) == false) {
					System.out.println(players[index].getName()+"이 졌습니다.");
					break;
				}
				
				else {
					lastWord = players[index].getLastWrodFromUser();
					if(index < numOfPlayer-1) {
						index++;
					}
					else {
						index = 0;
					}
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Index오류");
				e.printStackTrace();
			}
		}
		scan.close();
	}
	public static void main(String[] args) {
		
		
		run();
		
	
	}

}
