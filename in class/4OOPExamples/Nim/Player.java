package Nim;
/**
 * A class representing a player in a Nim game.
 * 
 * @author Top Malasri
 * @version Feb. 12, 2014
 */
public class Player
{
    // we keep track of each player's name, and his/her number of games won
    private String name;
    private int gamesWon;

    // Constructor - sets the player's name and his/her games won to 0
    public Player(String aName)
    {
        name = aName;
        gamesWon = 0;
    }

    // Accessor method for the player's name
    //
    // Parameters: none
    // Returns: the player's name
    public String getPlayerName()
    {
        return name;
    }
    
    // Increases the number of games won by 1
    //
    // Parameters: none
    // Returns: none
    public void incrementGamesWon()
    {
        gamesWon++;
    }

    // Shows the player's number of games won
    //
    // Parameters: none
    // Returns: none
    public void showGamesWon()
    {
        if (gamesWon == 1)
            System.out.println(name + " has won " + gamesWon + " game.");
        else
            System.out.println(name + " has won " + gamesWon + " games.");
    }
}
