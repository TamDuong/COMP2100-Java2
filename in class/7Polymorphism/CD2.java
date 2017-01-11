
/**
 * CD2 must define the Playable interface's play() method.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CD2 implements Playable
{
    protected String title;
    protected int year;

    public CD2(String title, int year)
    {
        this.title = title;
        this.year = year;
    }
    
    public void play()
    {
        System.out.println("Now playing CD: " + title + " (" + year + ")");
    }
}
