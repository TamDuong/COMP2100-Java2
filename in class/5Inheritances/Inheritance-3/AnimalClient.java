
/**
 * Client program that creates some objects and calls their methods.
 * 
 * @author Top Malasri
 * @version Feb. 24, 2014
 */
public class AnimalClient
{
    public static void main(String[] args)
    {
        // The elements in this array can be objects of any class that implements the
        //  Movable interface.  All such objects are guaranteed to provide definitions
        //  for move().
        Movable[] thingsThatMove = new Movable[3];
        
        thingsThatMove[0] = new Car();      // valid because the Car class implements Movable
        thingsThatMove[1] = new Dolphin(8193021, 111);  // valid because Dolphin extends Animal, which implements Movable
        thingsThatMove[2] = new Car();
        
        for (int i = 0; i < thingsThatMove.length; i++) {
            thingsThatMove[i].move();   // this will call each object's version of move()... due to polymorphism, the JVM is
                                        //  able to determine the correct version of move() to call at runtime
        }
        
        
        Animal a = new Dolphin(890182, 1);
        a.move();   // makes the dolphin swim without needing to cast to Dolphin first!
        
        Dolphin d1 = new Dolphin(890182, 1);
        Dolphin d2 = new Dolphin(890182, 1);
        
        System.out.println(a.equals(d1));   // calls the Dolphin class's version of equals
        System.out.println(d1.equals(a));
    }
}
