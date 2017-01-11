
/**
 * Dolphin is a subclass, child class, or derived class of
 * Animal.  All Dolphin objects have the same instance
 * variables and methods (except constructors) that are
 * defined in Animal.
 * 
 * @author Top Malasri
 * @version Feb. 19, 2014
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

    // This *overrides* the mate() method defined in Animal.  When a Dolphin
    // object calls mate(), this version is what will be used.
    public void mate()
    {
        System.out.println("This " + species + " is having funtimes awkwardly!");
    }

    // Only Dolphin objects can call swim(), since it's defined in the Dolphin class.
    public void swim()
    {
        System.out.println("This " + species + " is swimming!");
    }

    // Overrides the equals method inherited from Animal.  This version checks for
    //  the three instance variables of Animal (by calling super.equals()), and
    //  it adds a check for the blowholeDiameter instance variable.
    public boolean equals(Object obj)
    {
        if (obj instanceof Dolphin) {
            return super.equals(obj) && this.blowholeDiameter == ((Dolphin)obj).blowholeDiameter;
        } else {
            return false;
        }
    }
}
