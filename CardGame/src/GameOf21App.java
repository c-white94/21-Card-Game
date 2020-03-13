/**
 * Program Name:  GameOf21App.java
 * Purpose:
 * Coder:         Tung (Leonardo) Hoang, 0828717
 * Date:          Feb 27, 2018     
 */
import java.util.Scanner;
public class GameOf21App
{

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("------------------------------------------------");
		System.out.println("This application allows a player to play\n the Gane of 21 against the computer.'");
		System.out.println("------------------------------------------------");
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		System.out.printf("\n%s, good luck!\n", name);
		
		GameOf21 game = new GameOf21(name);
		game.startGame();
		
		input.close();
		
	}
	//End of main method
}

//End of class