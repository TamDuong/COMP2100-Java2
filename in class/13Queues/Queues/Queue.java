
/**
 * Interface that specifies the basic queue operations.  A queue
 * is a linear data structure where operations are done on both ends.
 * Adding new elements is done from the back, while removing
 * elements is done from the front.
 * 
 * A queue is a FIFO (first-in, first-out) data structure, unlike
 * a stack which is LIFO (last-in, first-out).
 * 
 * The rule used for a queue is to always remove the item that has 
 * been in the collection the most amount of time. This policy is 
 * known as first-in-first-out or FIFO.
 * 
 * @author Top Malasri
 * @version Apr. 16, 2014
 */
public interface Queue<E>
{
    // returns whether or not the queue is empty
    boolean isEmpty();
    
    // returns the front element in the queue, without removing it
    E peek();
    
    // adds the specified newItem to the back of the queue
    void enqueue(E newItem);

    // removes and returns the front element of the queue
    E dequeue();
}
