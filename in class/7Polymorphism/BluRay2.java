
/**
 * BluRay2 must define the Playable interface's play() method.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BluRay2 implements Playable
{
    protected String title;
    protected int year;

    public BluRay2(String title, int year)
    {
        this.title = title;
        this.year = year;
    }
    
    public void play()
    {
        System.out.println("Now playing Blu-Ray disc: " + title + " (" + year + ")");
    }
}
