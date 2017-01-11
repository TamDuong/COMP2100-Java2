
/**
 * Subclass of Media representing a CD object.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CD extends Media
{
    public CD(String title, int year)
    {
        super(title, year);
    }
    
    public void play()
    {
        System.out.println("Now playing CD: " + title + " (" + year + ")");
    }
}
