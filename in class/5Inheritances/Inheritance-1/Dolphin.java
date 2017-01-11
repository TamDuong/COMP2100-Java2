
/**
 * Dolphin is a subclass, child class, or derived class of
 * Animal.  All Dolphin objects have the same instance
 * variables and methods (except constructors) that are
 * defined in Animal.
 * 
 * @author Top Malasri
 * @version Feb. 17, 2014
 */
public class Dolphin extends Animal // we use "extends" to indicate that Dolphin inherits from Animal
{
    // This is a new instance variable unique to Dolphin objects
    private double blowholeDiameter;

    // Getter/setter for the new instance variable
    public double getBlowholeDiameter()
    {
        return blowholeDiameter;
    }
    
    public void setBlowholeDiameter(double b)
    {
        blowholeDiameter = b;
    }

    // Subclasses do not automatically inherit constructors!  We
    // must write constructors specifically for the subclass.
    public Dolphin(double lethality, double b)
    {
        // "super" allows us to call the superclass's constructor.
        // Because the superclass of Dolphin is Animal, this line
        //  calls the Animal constructor.
        super("dolphin", 2, lethality);
        
        // now we set Dolphin's unique instance variable
        setBlowholeDiameter(b);
    }
}
