package poker;
/**
 * This class represents a single playing card.
 * 
 * @author Top Malasri
 * @version Feb. 5, 2014
 */
public class Card
{
    // Instance variables for suit and rank -- we use integers to represent both
    private int suit;   // 0 = spades, 1 = hearts, 2 = clubs, 3 = diamonds
    private int rank;   // 2-10 = the corresponding number rank on the card, 11 = jack, 12 = queen, 13 = king, 14 = ace

    // Getter methods
    public int getSuit()
    {
        return suit;
    }
    
    public int getRank()
    {
        return rank;
    }
    
    // Constructor
    public Card(int suit, int rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    // toString method to display the card in "rank of suit" format
    public String toString()
    {
        String suitString;
        if (suit == 0) {
            suitString = "spades";
        } else if (suit == 1) {
            suitString = "hearts";
        } else if (suit == 2) {
            suitString = "clubs";
        } else {
            suitString = "diamonds";
        }
        
        String rankString;
        switch (rank) {
            case 11:
                rankString = "jack";
                break;
            case 12:
                rankString = "queen";
                break;
            case 13:
                rankString = "king";
                break;
            case 14:
                rankString = "ace";
                break;
            default:
                rankString = "" + rank;
        }
        
        return rankString + " of " + suitString;
    }
    
    public static void main(String[] args)
    {
        Card c1 = new Card(0, 12);  // queen of spades
        Card c2 = new Card(1, 2);   // 2 of hearts
        Card c3 = new Card(3, 11);  // jack of diamonds
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        
    }
}
