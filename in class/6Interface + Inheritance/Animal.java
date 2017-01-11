        
/**
 * Animal now implements the Comparable interface (in addition
 * to Movable).  This means that Animal must provide a definition
 * for the compareTo method in Comparable.
 * 
 * @author Top Malasri
 * @version Feb. 26, 2014
 */
public abstract class Animal implements Movable, Comparable
{
    // instance variables - the values assigned here are treated as default values
    // "protected" means that the variables are accessible within this class, as well
    //  as all subclasses of this class
    protected String species = "";
    protected int numLimbs = 4;
    protected double lethality = 3.5;

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

    // An abstract method.  Implementation of abstract methods
    //  is deferred to subclasses.
    public abstract void move();

    // compareTo method - specifies exactly how Animal objects
    //  should be compared.  In this case we do it based
    //  on lethality.
    public int compareTo(Comparable c)
    {
        Animal a = (Animal)c;   // needed since lethality is not defined in Comparable
        if (this.lethality == a.lethality)
            return 0;
        else if (this.lethality > a.lethality)
            return 1;
        else
            return -1;
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
    
    // The Animal parameter here means that when eat is called, you must provide it with an Animal
    //  object as an argument.  Because Dolphins are Animals, you can also pass a Dolphin object
    //  (or an object from any other subclass of Animal) as an argument!
    public void eat(Animal food)
    {
        System.out.println("This " + species + " is munching on " + food.getSpecies() + "!");
    }
    
    // Overrides the equals method inherited from Java's Object class.  This method allows
    //  us to test two Animal objects for equivalence.  We consider two Animal objects
    //  "equivalent" if they share the same values for all of their instance variables.
    public boolean equals(Object obj)
    {
        if (obj instanceof Animal) {    // first check to see if the thing we're comparing against is an Animal
            Animal a = (Animal)obj;     // create an Animal reference so we can access Animal's instance variables
            return  this.species.equals(a.species) &&
                    this.numLimbs == a.numLimbs &&
                    this.lethality == a.lethality;
        } else {
            return false;
        }
    }
}
