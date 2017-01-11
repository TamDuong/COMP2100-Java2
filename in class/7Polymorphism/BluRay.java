
/**
 * Subclass of Media representing a BluRay object.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BluRay extends Media
{
    public BluRay(String title, int year)
    {
        super(title, year);
    }
    
    public void play()
    {
        System.out.println("Now playing Blu-Ray disc: " + title + " (" + year + ")");
    }
}
