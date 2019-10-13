package homework2;

import java.util.InputMismatchException;
import java.util.Scanner;

class Person {
	private String name;
	private String tel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Person(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	public void show() {
		System.out.println(name + "의 번호는 " + tel + " 입니다.");
	}
}

public class PhoneBook extends Person {

	public PhoneBook(String name, String tel) {
		super(name, tel);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean isExist = false;
		int personIndex = 0;
		int numOfPeople=0;
		while(true) {
			try {
				System.out.print("인원수>>");
				numOfPeople = scan.nextInt();
				
				break;
			}
			catch(InputMismatchException e1) {
				System.out.println("정수를 입력하세요.");
			}
		}
		Person test[] = new Person[numOfPeople];
		for (int i = 0; i < numOfPeople; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
			String name = scan.next();
			String tel = scan.next();
			test[i] = new Person(name, tel);
		}
		String line;
		while (true) {
			try {
				System.out.print("검색할 이름>>");
				line = scan.next();
				if (line.equals("그만")) {
					break;
				}
				for (int i = 0; i < numOfPeople; i++) {
					if (line.equals(test[i].getName())) {
						isExist = true;
						personIndex = i;
					}
				}
				if (isExist) {
					test[personIndex].show();
					isExist = false;
				} else {
					System.out.println(line + " 이 없습니다.");
				}
			}
			catch(IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}

		scan.close();
	}

}
