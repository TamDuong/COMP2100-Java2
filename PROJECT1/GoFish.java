import java.util.*;
/**
 * Write a description of class j here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoFish
{
    Scanner input = new Scanner(System.in);
    private Deck d = new Deck();
    private Player[] p;
    
    public boolean turn(int me, int Opponent)
    {
        int chosenC;
        boolean goAgain = false;
        do {
            System.out.println("My cards >>>");
            System.out.println(p[me]);
            System.out.println("Your Opponent " + p[Opponent].getName() + "'s cards >>>");
            System.out.println(p[Opponent]);
            System.out.print("Enter the card you want from " + p[Opponent].getName() + ": ");
            chosenC = input.nextInt() - 1;
        } while (chosenC < 0 || chosenC >= p[me].getCardsMax());

        goAgain = p[Opponent].giveCard(p[me].myCards[chosenC], p[me]);
        
        if (!goAgain) {
            System.out.println(">>>>>>>>>GO FISH<<<<<<<<\n" + p[me].getName() + " draws a card from the deck.");
            p[me].addCard(d.draw());
            if (p[me].myCards[chosenC].getRank() == p[me].myCards[p[me].getCardsMax() - 1].getRank())
                goAgain = true;
        }
        
        for (int i = 0; i < p.length; i++)
            for (int j = 0; j < p[i].getCardsMax(); j++)
                p[i].killCard(p[i].myCards[j]);
        
        return goAgain;      // true if the player got cards from other; false otherwise
    }
    
    public boolean gameOver()
    {
        for (int i = 0; i < p.length; i++) {
            if (p[i].getCardsMax() == 0)
                return true;
        }
        
        return (d.getTopCard() == 52);       
    }
    
    public String chooseWinner()
    {   
        int highest = p[0].getBooks();
        for (int i = 1; i < p.length; i++) {
            if (p[i].getBooks() > highest)
                highest = p[i].getBooks();
            }
            
        String r = "";
        for (int i = 0; i < p.length; i++) {
            if (p[i].getBooks() == highest)
                r += p[i].getName() + ", ";
            }
        return (r + "win");
    }
    
    public void startGame()
    {   
        d.shuffle();
        
        int pNum, Opponent, me = 0;
        boolean goAgain;
        do {
            System.out.print("Enter the number of players: ");
             pNum = input.nextInt();
        } while (pNum < 2 || pNum > 6);
        input.nextLine();
        
        p = new Player[pNum];
        for (int i = 0; i < pNum; i++) {
            System.out.print("Enter player " + (i+1) + " name: ");
            String name = input.nextLine();
            p[i] = new Player(name);
        }
        System.out.println();
        
        // begin with dealing 5 cards to each player
        for (int i = 0; i < 5; i++) 
            for (int j = 0; j < p.length; j++)
                p[j].addCard(d.draw());
        
        do {
            System.out.println("***" + p[me].getName() + "***.It's your turn!!");
                
            do {
                System.out.println("Pick one player below to get cards (exclude yourself)!");
                for (int i = 0; i < p.length; i++) 
                    System.out.println(i+1 + ". " + p[i].getName());
                System.out.print(p[me].getName() + ". Pick an opponent:    ");
                Opponent = input.nextInt() - 1;
                System.out.println();
            }   while (Opponent < 0 || Opponent >= p.length || Opponent == me);
            
            goAgain = turn(me, Opponent);
            if (!goAgain)
                me = Opponent;
        }   while (!gameOver());
        
        System.out.println(chooseWinner());
    }
    
    public static void main(String[] args)
     {
         (new GoFish()).startGame();
    }
}
