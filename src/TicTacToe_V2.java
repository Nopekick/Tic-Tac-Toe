/*
 * Creator Thomas Kamm. This is a Tic-Tac-Toe Game. It is random who starts first. To make a move, 
 * the player will select a row and a column. The computer randomly selects an appropriate spot 
 * on the board to place the 'O'. The program can detect when someone wins, or whether the board
 * is full. I hope to add intelligence to the computer move system, to have it be able to detect
 * which moves can make it win, thereby putting logic behind the moves instead of just randomness.
 */
import java.util.Scanner;
public class TicTacToe_V2 {

public static String[][] board = { {" "," "," "},{" "," "," "},{" "," "," "} };

public static void printBoard() {
	for(int i = 0; i < board.length; i++) {
		System.out.println("-------------");
		System.out.print("| ");
		for(int j = 0; j< board[i].length; j++) {
			System.out.print(board[i][j]+" | ");
		}
		System.out.println();
	}
	System.out.println("-------------");
	
}

public static void move(String a) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Which row?");
	int row = sc.nextInt()-1;
	System.out.println("Which column?");
	int col = sc.nextInt()-1;
	while(board[row][col] != " ") {
		System.out.println("You can't put a piece there!");
		System.out.println("Which row?");
		row = sc.nextInt()-1;
		System.out.println("Which column?");
		col = sc.nextInt()-1;
	}
	board[row][col] = a;
}

public static boolean isFull() {
	for(int i = 0; i < board.length; i++) {
		for(int j = 0; j < board[i].length; j++) {
			if(board[i][j] == " ") {
				return false;
			}
		}
	}
	return true;
}


public static boolean isWin(String player) {
	//horizontal row check
	for(int i = 0; i < board.length; i++) {
		if(board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
			return true;
		}
	}
	//vertical column check
	for(int i = 0; i < board.length; i++) {
		if(board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
			return true;
		}
	}
	//diagonal check
	if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
		return true;
	}
	else if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
		return true;
	}
	return false;
	
}

//currently chooses a random appropiate move. No win strategy
public static void compMove() {
	System.out.println("The computer has placed an 'O'");
	int row = (int)(Math.random()*3), column = (int)(Math.random()*3);
	while( board[row][column] != " ") {
		row = (int)(Math.random()*3) ;
		column = (int)(Math.random()*3);
	}
	board[row][column] = "O";
}
	public static void main(String[] args) {
Scanner sc= new Scanner(System.in);
boolean pvp = false;
int mode;
int start = (int)((Math.random()*2)+1);
boolean compstart = false;
switch(start) {
case 1: compstart = true;
}

System.out.println("Welcome to Tic-Tac-Toe. You are 'X'. "
		+ "\nTo make a move, first specify the row, and then the column");

System.out.println("Do you wish for PvP (1) for PvComputer? (2)");
mode = sc.nextInt();

//PvComputer Mode
if(mode == 2) {
//computer starts
if(compstart) {
	System.out.println("The computer will move first\n");
	while(!isWin("O") && !isWin("X")) {
		compMove();
		printBoard();
		if(isFull() || isWin("O")) {
			break;
		}
		move("X");
		printBoard();
		if(isFull() || isWin("X")) {
			break;
		}
	}
	
}
//player starts
else {
	System.out.println("You will go first\n");
	while(!isWin("O") && !isWin("X")) {
		move("X");
		printBoard();
		if(isFull() || isWin("X")) {
			break;
		}
		compMove();
		printBoard();
		if(isFull() || isWin("O")) {
			break;
		}
	}
	
}
if(isWin("O")) {
	System.out.println("The computer has won!");
}
else if(isWin("X")) {
	System.out.println("You won!");
}
else if(isFull()) {
	System.out.println("Draw!");
}
}

//PvP Mode
else {
	if(compstart) {
		System.out.println("Player 1 (X) will move first. Select a row and a column");
		while(!isWin("O") && !isWin("X")) {
			System.out.println("Player 1 turn");
			move("X");
			printBoard();
			if(isFull() || isWin("X")) {
				break;
			}
			System.out.println("Player 2 turn");
			move("O");
			printBoard();
			if(isFull() || isWin("O")) {
				break;
			}
		}
	}
	else {
		System.out.println("Player 2 (O) will move first. Select a row and a column");
		while(!isWin("O") && !isWin("X")) {
			System.out.println("Player 2 turn");
			move("O");
			printBoard();
			if(isFull() || isWin("O")) {
				break;
			}
			System.out.println("Player 1 turn");
			move("X");
			printBoard();
			if(isFull() || isWin("X")) {
				break;
			}
		}
	}
	if(isWin("O")) {
		System.out.println("Player 2 has won!");
	}
	else if(isWin("X")) {
		System.out.println("Player 1 has won!");
	}
	else if(isFull()) {
		System.out.println("Draw!");
	}
}

//end of main
	}
}
