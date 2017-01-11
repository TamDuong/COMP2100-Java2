package Nim;
/**
 * Client program for the Nim game.  This class contains all the necessary objects
 * to play Nim - one GameBoard and two Players.
 * 
 * Nim is a two-player game where the game board consists of a number of piles
 * of items (they could be sticks, or rocks, or whatever).  During each player's turn,
 * s/he must remove one or more items from a single non-empty pile.  The winner is the
 * player who makes the last move (i.e., empties the whole board).
 * 
 * @author Top Malasri
 * @version Feb. 12, 2014
 */
import java.util.Scanner;

public class NimGame
{
    // a static variable is shared among all instances of that class -- it does not have unique
    //  values per instance like an instance variable does
    private static Scanner s = new Scanner(System.in);

    private GameBoard g;
    private Player p1, p2;

    // Instantiates the Player objects with the specified names.
    //
    // Parameters: none
    // Returns: none
    private void initializePlayers()
    {
        System.out.println("Welcome to NIM!");
        System.out.println("---------------");
        System.out.println();
        
        // collect player info
        System.out.print("Enter player 1's name: ");
        String p1Name = s.nextLine();
        System.out.print("Enter player 2's name: ");
        String p2Name = s.nextLine();
        
        // instantiate the two Player objects
        p1 = new Player(p1Name);
        p2 = new Player(p2Name);
    }

    // Starts a new game.  Must call initializePlayers() first.
    // This method will run until the game ends.
    //
    // Parameters: none
    // Returns: none
    private void playGame()
    {
        // create a new game board
        g = new GameBoard();
        
        // randomly choose who goes first
        System.out.println();
        System.out.println("Flipping a coin...");
        Player firstPlayer, secondPlayer;
        if (Math.random() < 0.5) {
            System.out.println(p1.getPlayerName() + " will go first!");
            firstPlayer = p1;
            secondPlayer = p2;
        } else {
            System.out.println(p2.getPlayerName() + " will go first!");
            firstPlayer = p2;
            secondPlayer = p1;
        }
        
        // main game loop
        while (!g.isGameOver()) {
            // loop twice (once for first player, once for second player)
            for (int i = 0; i < 2; i++) {
                // show the game board
                System.out.println(g);

                // whose turn is it?
                Player currentPlayer;
                if (i == 0)
                    currentPlayer = firstPlayer;
                else
                    currentPlayer = secondPlayer;
                System.out.println("*** " + currentPlayer.getPlayerName() + "'s turn! ***");
                
                // get player input for which pile and how many items to remove from that pile
                int whichPile, howManyItems;
                boolean inputValid;
                do {
                    inputValid = false;
                    System.out.print("Indicate the pile and number of item(s) to remove: ");
                    whichPile = s.nextInt();
                    howManyItems = s.nextInt();
                    
                    int code = g.removeItems(whichPile, howManyItems);
                    if (code == 0)
                        inputValid = true;
                    else if (code == 1)
                        System.out.println("Pile " + whichPile + " does not exist!");
                    else if (code == 2)
                        System.out.println("You must remove at least 1 item!");
                    else if (code == 3)
                        System.out.println("Pile " + whichPile + " does not contain that many items!");
                    
                } while (!inputValid);      //if this condition is fall this loop will break
                
                // did that item removal win the game?
                if (g.isGameOver()) {
                    System.out.println();
                    System.out.print("*********************");
                    for (int j = 0; j < currentPlayer.getPlayerName().length(); j++)
                        System.out.print("*");
                    System.out.print("***************\n");
                    System.out.println("*** CONGRATULATIONS, " + currentPlayer.getPlayerName() + " - you win! ***");
                    System.out.print("*********************");
                    for (int j = 0; j < currentPlayer.getPlayerName().length(); j++)
                        System.out.print("*");
                    System.out.print("***************\n");
                    System.out.println();

                    currentPlayer.incrementGamesWon();
                    break;  // get out of the for loop on players
                }
            }   // end for loop on players
        }   // end main game loop
    }

    // Shows the current stats of players 1 and 2.
    //
    // Parameters: none
    // Returns: none
    private void showPlayerStats()
    {
        System.out.println("Current player stats:");
        p1.showGamesWon();
        p2.showGamesWon();
        System.out.println();
    }
    
    // Driver method -- create a new instance of NimGame and call this to run the game.
    public void startGame()
    {
        initializePlayers();
        
        // we allow the user to keep playing after each game if desired
        boolean playAgain;
        do {
            // start a new game
            playGame();

            // once the game ends, show player stats
            showPlayerStats();
            
            // play again?
            System.out.print("Play again? (Y for yes, anything else for no) ");
            String input = s.next();
            playAgain = input.equalsIgnoreCase("Y");

        } while (playAgain);
    }
    
    public static void main(String[] args)
    {
        (new NimGame()).startGame();
    }
}
