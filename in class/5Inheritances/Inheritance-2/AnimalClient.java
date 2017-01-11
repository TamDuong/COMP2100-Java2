
/**
 * The AnimalClient class just has a main method that
 * creates some Animal objects and uses them to call methods.
 * 
 * @author Top Malasri
 * @version Feb. 19, 2014
 */
public class AnimalClient
{
    public static void main(String[] args)
    {
        Dolphin d1 = new Dolphin(890182, 1);
        Dolphin d2 = new Dolphin(890182, 1);
        
        System.out.println(d1.equals(d2));
        System.out.println(d1.lethality);
    }
}
