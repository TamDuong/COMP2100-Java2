
/**
 * Subclass of Media representing a DVD object.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DVD extends Media
{
    public DVD(String title, int year)
    {
        super(title, year);
    }
    
    public void play()
    {
        System.out.println("Now playing DVD: " + title + " (" + year + ")");
    }
}
