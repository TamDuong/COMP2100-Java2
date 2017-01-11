
/**
 * Write a description of class Dolphin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dolphin extends Animal
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

    // Overrides the abstract move() method inherited from Animal.  Required
    //  since Dolphin is a concrete subclass of Animal.
    public void move()
    {
        System.out.println("This " + species + " is swimming!");
    }
    
    // This *overrides* the mate() method defined in Animal.  When a Dolphin
    // object calls mate(), this version is what will be used.
    public void mate()
    {
        System.out.println("This " + species + " is having funtimes awkwardly!");
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
