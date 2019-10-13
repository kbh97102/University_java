package homework2;

import java.util.InputMismatchException;
import java.util.Scanner;

class Dictionary{
	private static String [] kor = {"사랑", "아기", "돈","미래", "희망"};
	private static String [] eng = {"love", "baby", "money", "future", "hope"};
	public static String kor2eng(String word) {
	
		for(int i=0;i<kor.length;i++) {
			if(kor[i].equals(word)) {
				return eng[i];
			}
		}
		String noResult = "no";
		return noResult;
	}
}

public class DicApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("한영 단어 검색 프로그램입니다.");
		String convertedWord;
		while(true) {
			try {
				System.out.print("한글 단어는?");
				String word = scan.next();
				if(word.equals("그만")) {
					break;
				}
				convertedWord = Dictionary.kor2eng(word);
				if(convertedWord.equals("no")) {
					System.out.println(word+"는 저의 사전에 없습니다.");
				}else {
					System.out.println(word+"은 "+convertedWord);
				}
				
			}
			catch(InputMismatchException e) {
				System.out.println("한글을 입력해주세요.");
			}
		}
		
		
		
		scan.close();
	}

}
