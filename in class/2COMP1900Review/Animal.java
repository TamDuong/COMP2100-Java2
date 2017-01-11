
/**
 * The Animal class serves as a description or blueprint for Animal objects.
 * The class can be used to create as many Animal objects (instances)
 * as desired.  Each instance has its own values for the instance variables,
 * while they all share access to the same methods.
 * 
 * Note that all the methods here are declared *without* the "static" modifier.
 * A static method can be called without any instance of a class.  A non-static
 * method requires an instance to do the calling.  Since all of our methods here
 * involve instance variables, they are declared as non-static.
 * 
 * @author Top Malasri
 * @version Jan. 27, 2014
 */
public class Animal
{
    // instance variables - the values assigned here are treated as default values
    private String species = "";
    private int numLimbs = 4;
    private double lethality = 3.5;

    // setter (a.k.a. mutator, modifier) methods - these allow us to change the values of the
    //  instance variables
    public void setSpecies(String s)
    {
        species = s;
    }
    
    public void setNumLimbs(int n)
    {
        numLimbs = n;
    }
    
    public void setLethality(double l)
    {
        // this setter has some checking to ensure that we can't set the lethality to a negative value
        if (l >= 0.0) {
            lethality = l;
        } else {
            System.out.println("That is an invalid lethality value!");
        }
    }
    
    // getter (a.k.a. accessor) methods - these allow us to read/retrieve the values of the
    //  instance variables
    public String getSpecies()
    {
        return species;
    }
    
    public int getNumLimbs()
    {
        return numLimbs;
    }
    
    public double getLethality()
    {
        return lethality;
    }

    // constructor that allows us to set the values of all three instance variables when we first
    //  create an Animal object
    public Animal(String s, int n, double l)
    {
        setSpecies(s);
        setNumLimbs(n);
        setLethality(l);
    }

    // other methods
    public void mate()
    {
        System.out.println("This " + species + " is having funtimes!");
    }
    
    public void kill()
    {
        System.out.println("This " + species + " is working!");
    }
    
    // the Animal parameter here means that when eat is called, you must provide it with an Animal
    //  object as an argument
    public void eat(Animal food)
    {
        System.out.println("This " + species + " is munching on " + food.getSpecies() + "!");
    }
}
