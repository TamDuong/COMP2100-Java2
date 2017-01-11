package poker;
/**
 * Client program for a two-player, 5-card stud poker game.
 * In 5-card stud, each player gets dealt 5 cards, and the winner
 * is immediately determined from those 5 cards.  Players do not
 * get to change any cards in their hand.
 * 
 * @author Top Malasri
 * @version Feb. 12, 2014
 */
public class PokerGame
{
    // instance variables - one Deck and two Hand objects
    private Deck deck;      //????????????????????????????????????????ask TOP. What happen if we make this deck as a static vairable
    private Hand h1, h2;

    // Creates new objects to assign to the instance variables.  Also
    //  shuffles the deck.
    public void initialize()
    {
        deck = new Deck();
        deck.shuffle();
        h1 = new Hand();
        h2 = new Hand();
    }
    
    // Deals 5 cards to each player, in a round-robin fashion.
    public void deal()
    {
        for (int i = 0; i < 5; i++) {
            h1.addCard(deck.draw());
            h2.addCard(deck.draw());
        }
    }

    // Displays both players' hands on the screen.
    public void displayHands()
    {
        System.out.println("Player 1's hand:");
        System.out.println("----------------");
        System.out.println(h1);
        System.out.println("Player 2's hand:");
        System.out.println("----------------");
        System.out.println(h2);
    }

    // Determines and displays the winner between players 1 and 2.  Note that the
    //  winner is determined strictly by looking at the type of each player's hand
    //  (flush, straight, etc.).  If both players have the same type of hand, we simply
    //  say that the game ends in a tie, even though this is not quite true for
    //  a real poker game.
    public void determineWinner()
    {
        int eval1 = h1.evaluate(),
            eval2 = h2.evaluate();
        if (eval1 > eval2) {
            System.out.println("Player 1 won!");
        } else if (eval2 > eval1) {
            System.out.println("Player 2 won!");
        } else {
            System.out.println("We have a tie!");
        }
    }

    // Driver method -- create a new PokerGame object and call this to start the game.
    public void startGame()
    {
        initialize();
        deal();
        displayHands();
        determineWinner();
    }
    
    public static void main(String[] args)
    {
        (new PokerGame()).startGame();  // this says "create a new PokerGame object, then call startGame using that object"
                                        //  we never assign the object to a variable
                                        // this is short for pokerGame a = new PkerGame();
                                        //                   a.startGame();
    }
}
