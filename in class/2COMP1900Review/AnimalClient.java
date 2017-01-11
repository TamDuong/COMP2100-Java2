
/**
 * The AnimalClient class just has a main method that
 * creates some Animal objects and uses them to call methods.
 * 
 * @author Top Malasri
 * @version Jan. 27, 2014
 */
public class AnimalClient
{
    public static void main(String[] args)
    {
        // create two new instances of Animal
        Animal tom = new Animal("tiger", 4, 6.0);
        Animal bob = new Animal("human", 4, 1.0);

        // verify that the tom object's instance variables
        //  were set successfully
        System.out.println(tom.getSpecies());   // we can't directly access species (like tom.species) since the variable is declared private in Animal
        System.out.println(tom.getNumLimbs());
        System.out.println(tom.getLethality());

        // call some methods using tom and bob
        tom.kill();
        tom.eat(bob);
        tom.mate();
    }
}
