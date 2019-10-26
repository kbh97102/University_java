package midTest;

import java.util.Scanner;



abstract class GameObject{
	public final static int FIELDWIDTH = 10;
	public final static int FIELDHEIGHT = 20;
	protected int distance;
	protected int x, y;
	public GameObject(int startX, int startY, int distance) {
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public boolean collide(GameObject p) {
		if(this.x == p.getX() && this.y == p.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	protected abstract void move();
	protected abstract char getShape();
	
}

class Fish extends GameObject{

	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void move() {
		Scanner scan = new Scanner(System.in);
		Game.field[y][x] = '-';
		int fishMove = (int)(Math.random()*4);
		switch(fishMove) {
		case 0:
			if(x-distance >=0) {
				x -= distance;
			}
			break;
		case 1:
			if(x+distance <= FIELDWIDTH-1) {
				x += distance;
			}
			break;
		case 2:
			if(y-distance >=0) {
				y -= distance;
			}
			break;
		case 3:
			if(y+distance <= FIELDHEIGHT) {
				y += distance;
			}
			break;
		default:
			System.out.println("FishError");
		}
		Game.field[y][x] = getShape();
	}
	@Override
	protected char getShape() {
		return 'f';
	}
}

class Bear extends GameObject{
	static Scanner scan = new Scanner(System.in);
	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void move() {
		System.out.print("넌 또 뭐가문제인건데");
		Scanner scan = new Scanner(System.in);
		
		Game.field[y][x] = '-';
		String userInput = scan.next();
		
		switch(userInput) {
		case "a":
			if(x-distance <0) {
				x = 0;
			}
			else {
				x -= distance;
			}
			break;
		case "d":
			if(x+distance > FIELDWIDTH-1) {
				x = FIELDWIDTH-1;
			}
			else {
				x += distance;
			}
			break;
		case "w":
			if(y-distance >=0) {
				y -= distance;
			}
			break;
		case "s":
			if(y+distance <= FIELDHEIGHT) {
				y += distance;
			}
			break;
		default:
			System.out.println("BearError");
		}
		Game.field[y][x] = getShape();
		
	}
	@Override
	protected char getShape() {
		return 'B';
	}
	public void close() {
		scan.close();
	}
}

class Game{
	public static final int FIELDWIDTH=10;
	public static final int FIELDHEIGHT=20;
	public static char field[][]=new char [FIELDHEIGHT][FIELDWIDTH];
	Bear bear;
	Fish fish;

	public void setGame() {
		try {
			for(int i=0;i<FIELDHEIGHT;i++) {
				for(int j=1;j<FIELDWIDTH;j++) {
					field[i][j] = '-';
				}
			}
			bear = new Bear(1, 1, 1);
			fish = new Fish(5, 6, 1);
			
			field[bear.y][bear.x] = bear.getShape();
			field[fish.y][fish.x] = fish.getShape();
		}
		catch(ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();
		}
		
	}
	public void display() {
		try {
			for(int i=0;i<FIELDHEIGHT;i++) {
				for(int j=0;j<FIELDWIDTH;j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}
		catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
	}
	public void winWindow() {
		field[bear.y][bear.x] = bear.getShape();
		for(int i=0;i<FIELDHEIGHT;i++) {
			for(int j=0;j<FIELDWIDTH;j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
		System.out.println("Bear Win!");
	}
	public void run() {
		setGame();
		boolean isRunning = true;
		while(isRunning) {
			int fishMoveCount=0;
			for(int i=0;i<5;i++) {
				
				display();
				bear.move();
				
				int fishRandomMove = (int)(Math.random()*5);
				switch(fishRandomMove) {
				case 0:
					if(fishMoveCount <2) {
						fish.move();
						fishMoveCount++;
					}
					break;
				case 1:
					if(fishMoveCount <2) {
						fish.move();
						fishMoveCount++;
					}
					break;
				case 2:
					if(fishMoveCount <2) {
						fish.move();
						fishMoveCount++;
					}
					break;
				case 3:
					if(fishMoveCount <2) {
						fish.move();
						fishMoveCount++;
					}
					break;
				case 4:
					if(fishMoveCount <2) {
						fish.move();
						fishMoveCount++;
					}
					break;
				default:
					System.out.println("error");
				}
				
				if(bear.collide(fish)) {
					isRunning = false;
					winWindow();
					break;
				}else if(fish.collide(bear)) {
					isRunning = false;
					winWindow();
					break;
				}
				
			}
			
		}
	}
}
public class Ch5_openChallenge{
	
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}
	
}
