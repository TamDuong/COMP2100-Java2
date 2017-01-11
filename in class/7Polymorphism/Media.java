
/**
 * Abstract class Media - defines instance variables,
 * a constructor, and an abstract method play().
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Media
{
    protected String title;
    protected int year;

    public Media(String title, int year)
    {
        this.title = title;
        this.year = year;
    }
    
    public abstract void play();
}
