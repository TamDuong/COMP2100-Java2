package Nim;
/**
 * A class representing the Nim gameboard.  Maintains the current state of the game.
 * 
 * @author Top Malasri
 * @version Feb. 12, 2014
 */
public class GameBoard
{
    private int[] piles;        // piles of items

    // Accessor for number of piles
    //
    // Parameters: none
    // Returns: the number of piles present in the game
    public int getNumPiles()
    {
        return piles.length;
    }
    
    // Constructor - initializes a random number of piles, and a random number of items per pile
    public GameBoard()
    {
        int numPiles = (int)(3*Math.random()) + 2;  // anywhere between 2-4 piles
        
        // initialize the piles of items
        // - 1. how many piles?
        piles = new int[numPiles];
        
        // - 2. how many items in each pile?
        for (int i = 0; i < piles.length; i++)
            piles[i] = (int)(3*Math.random()) + 2;  // anywhere between 2-4 items per pile
    }
    
    // Attempts to remove the specified number of items from the specified pile on the board
    //  (piles are numbered starting from 0).
    //
    // Parameters: the pile to remove from, and how many items to remove
    // Returns: 0 if removal successful
    //          1 if whichPile doesn't exist on the board
    //          2 if howManyItems is not positive
    //          3 if there are fewer than howManyItems in whichPile
    public int removeItems(int whichPile, int howManyItems)
    {
        if (whichPile < 0 || whichPile >= getNumPiles()) {
            return 1;
        } else if (howManyItems <= 0) {
            return 2;
        } else if (piles[whichPile] < howManyItems) {
            return 3;
        } else {
            piles[whichPile] -= howManyItems;
            return 0;
        }
    }
    
    // Returns whether the game is over (i.e., all piles are empty)
    //
    // Parameters: none
    // Returns: true if all piles are empty, false otherwise
    public boolean isGameOver()
    {
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] != 0)
                return false;
        }
        return true;
    }

    // toString method that controls how the game board is displayed
    // 
    // Parameters: none
    // Returns: a string representing the current state of the board
    public String toString()
    {
        String r = "\nCurrent game board:\n-------------------\n";
        for (int i = 0; i < piles.length; i++) {
            String n = (piles[i] == 1) ? "item" : "items";      //determine if string n is item or items
            r += "Pile " + i + ": " + piles[i] + " " + n + "\n";
        }
        return r;
    }
}
