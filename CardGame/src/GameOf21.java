/**
 * Program Name:  GameOf21.java
 * Purpose:
 * Coder:         Tung (Leonardo) Hoang, 0828717
 * Date:          Feb 27, 2018     
 */
import java.util.Scanner;
public class GameOf21
{
	private static Scanner in;
	private Deck deck;
	private Hand user;
	private Hand computer;
	
	public GameOf21(String player) {
		in = new Scanner(System.in);
		deck = new Deck();
		user = new Hand(player);
		computer = new Hand("Computer");
	}

	/**
	 * Gets the in of the object
	 * @return the in
	 */
	public Scanner getIn()
	{
		return in;
	}

	/**
	 * Sets the in of this object
	 * @param in - value to set
	 */
	public void setIn(Scanner in)
	{
		this.in = in;
	}

	/**
	 * Gets the deck of the object
	 * @return the deck
	 */
	public Deck getDeck()
	{
		return deck;
	}

	/**
	 * Sets the deck of this object
	 * @param deck - value to set
	 */
	public void setDeck(Deck deck)
	{
		this.deck = deck;
	}

	/**
	 * Gets the user of the object
	 * @return the user
	 */
	public Hand getUser()
	{
		return user;
	}

	/**
	 * Sets the user of this object
	 * @param user - value to set
	 */
	public void setUser(Hand user)
	{
		this.user = user;
	}

	/**
	 * Gets the computer of the object
	 * @return the computer
	 */
	public Hand getComputer()
	{
		return computer;
	}

	/**
	 * Sets the computer of this object
	 * @param computer - value to set
	 */
	public void setComputer(Hand computer)
	{
		this.computer = computer;
	}
	
	public void startGame() {
		printTitle();
		printInstruction();
		playGame();
	}
	
	public void printTitle() {
		System.out.println("------------------------------------------------");
		System.out.println("Welcome to the Game of 21!");
		System.out.println("------------------------------------------------");
	}
	
	public void printInstruction() {
		System.out.println("HOW TO PLAY:");
		System.out.println("------------------------------------------------");
		System.out.println(". . . game instructions go here . . .\n");
	}
	
	public void playGame() {
		System.out.printf("The deck has %d cards.\n", deck.size());
		//deal two cards to each player
		user.hit(deck.dealCard());
		computer.hit(deck.dealCard());
		user.hit(deck.dealCard());
		computer.hit(deck.dealCard());
		
		//display all cards on the user's hand
		user.displayAllCards();
		//display visible cards on computer's hand
		computer.displayVisibleCards();
		
		//display each player's hand
		userDraws();
		computerDraws();
		//print the winner
		printWinner();
		//call playAgain()
		playAgain();
		
	}
	
	public void userDraws() {
		String userAns = "";
			do {
				System.out.print("\nDo you want another card (Y/N) ? ");
				userAns = in.nextLine();
				if(userAns.equalsIgnoreCase("n")) {
					System.out.println("\n"+user.getPlayerName() + " stands.");
				}else if(userAns.equalsIgnoreCase("y")){
					user.hit(deck.dealCard());
					user.displayAllCards();
					if(user.totalHand() > 21) {
						System.out.println("\n"+user.getPlayerName() + " busts!");
						break;
					}
				}
				
			}while(userAns.equalsIgnoreCase("y"));
	}
	
	public void computerDraws() {
		if(user.totalHand() > 21) {
			System.out.println("Computer stands.");
			computer.displayAllCards();
		}else {
			computer.hit(deck.dealCard());
			computer.displayAllCards();
			if(computer.totalHand() > 21) {
				System.out.println("\nComputer busts.");
			}else {
				System.out.println("\nComputer stands.");
				computer.displayAllCards();
			}
		}
	}
	
	public void printWinner() {
		System.out.println("----------------------------------");
		System.out.println("Game of 21 - Final Score");
		System.out.println("----------------------------------");
		System.out.printf("%s points:      %d\n", user.getPlayerName(), user.totalHand());
		System.out.printf("%s points:      %d\n", computer.getPlayerName(), computer.totalHand());
		System.out.println("----------------------------------");
		if(user.totalHand() == computer.totalHand()) {
			System.out.println("Draw!");
		}else if(user.totalHand() <= 21 && computer.totalHand() <= 21) {
			if(user.totalHand() > computer.totalHand()) {
				System.out.println(user.getPlayerName() + " wins!");
			}else if(computer.totalHand() > user.totalHand()){
				System.out.println("Computer wins!");
			}
		}else if(user.totalHand() > 21){
			System.out.println("Computer wins!");
		}else if(computer.totalHand() > 21) {
			System.out.println(user.getPlayerName() + " wins!");
		}
		System.out.println("----------------------------------");
	}
	
	public void playAgain() {
		System.out.print("Play another game (Y/N)? ");
		String playAnother = in.nextLine();
		if(playAnother.equalsIgnoreCase("n")) {
			System.out.println("\nThanks for playing!  Bye!");
		}else {
			if(deck.size() < 4) {
				System.out.printf("Deck has only %d cards left.\n", deck.size());
				System.out.println("Thanks for playing!  Bye!");
				System.exit(0);
			}else {
				user.emptyHand();
				computer.emptyHand();
				playGame();
			}
		}
	}
}

//End of class