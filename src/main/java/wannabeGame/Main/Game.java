package wannabeGame.Main;

import wannabeGame.Exceptions.*;
import java.util.*;

public class Game {

    private Board board;
	private Scanner scan;

	public Game() {
		/** Initialize Game */
		board = new Board(15,50);
		scan = new Scanner(System.in);
	}

	public void gameTitle() {
		System.out.printf("Tiagus Wannabe Game\n");
	}

	public char readAction() {
		char action;
		System.out.printf("insert new Command:\n");
		action = scan.next().charAt(0);
		return action;
	}

	public void startGame() {
		gameTitle();
		System.out.printf(board.toString()+"\n");
		while (true) {
			try {
				board.doAction(readAction());
				System.out.println(board.toString());
			}
			catch (FinishGameException e) {
				System.out.printf(e.toString());
				break;
			}
			catch (Exception e) {
				System.out.printf(e.toString());
			}
		}		
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.startGame();
	}
}
