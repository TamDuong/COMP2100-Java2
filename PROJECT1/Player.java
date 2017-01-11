
/**
 * Represent a player
 */
public class Player
{
    private String name = "";
    protected Card[] myCards = new Card[52];
    private int books = 0;
    private int CardsMax = 0;
    
    public Player(String name)
    {
        this.name = name;
    }
    
    public int getCardsMax()
    {
        return CardsMax;
    }
    
    public int getBooks()
    {
        return books;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void addCard(Card c)
    {
        CardsMax++;
        myCards[CardsMax-1] = c;
    }
    
    public void killCard(Card c)
    {
        int collectC = 0;
        for (int i = 0; i < CardsMax; i++)
            if (c.getRank() == myCards[i].getRank()) 
                collectC++;
                
        if (collectC == 4) {
            
            for (int i = 0; i < CardsMax; i++)
                if (c.getRank() == myCards[i].getRank()) {
                    for (int j = i; j < CardsMax - 1; j++) 
                        myCards[j] = myCards[j+1];
                    CardsMax--;
                    i--;
                }
            books++;
        }
    }
    
    public boolean giveCard(Card c, Player p)       // p is the player taking turn, c is the card in p's hand
    {
        boolean gaveC = false;
        for (int i = 0; i < CardsMax; i++)
            if (c.getRank() == myCards[i].getRank()) {
                p.addCard(myCards[i]);
                for (int j = i; j < CardsMax - 1; j++) 
                {
                    myCards[j] = myCards[j+1];
                }
                CardsMax--;
                i--;
                gaveC = true;
            }
        
        return gaveC;
    }
    
    
    public String toString()
    {
        String r = this.name + "           Books:" + books + "\n";
        for (int i = 0; i < CardsMax; i++)
            r += (i+1) + ". " + myCards[i] + "\n";
        return r;
    }
    
}
