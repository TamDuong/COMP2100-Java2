
/**
 * An interface for Playable objects.
 * 
 * This example is very similar to the example using inheritance, but we are now using
 * strictly interfaces to achieve the same effect.
 * 
 * Interfaces can't contain instance variables, so those have to be declared in each
 * individual class (CD2/DVD2/BluRay2).  For these classes it'd probably make more sense
 * to use inheritance, but I'm presenting this example with interfaces to show that
 * polymorphism works with both inheritance and interfaces.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Playable
{
    // remember that methods declared in an interface are public and abstract by default
    void play();
}
