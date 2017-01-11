
/**
 * The Comparable interface is meant to be implemented by any class
 * whose objects should be "comparable" with each other.
 * 
 * Note that Java actually has its own built-in Comparable interface.  I'm
 * avoiding that for now since it involves a concept called generics that
 * we haven't discussed yet.
 * 
 * @author Top Malasri
 * @version Feb. 26, 2014
 */
public interface Comparable
{
    // Compares the calling object vs. another object.  The parameter of type Comparable
    //  just means that you can use an object from *any class* that implements Comparable
    //  for the argument.
    //
    // Returns 0 if the calling object is considered "equal to" c
    // Returns a negative number if the calling object is considered "less than" c
    // Returns a positive number if the calling object is considered "greater than" c
    int compareTo(Comparable c);
}
