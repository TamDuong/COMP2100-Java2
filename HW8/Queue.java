
/**
 * Queue interface
 * 
 * Tam Duong 
 * 4/28/2014
 */
public interface Queue<F>
{
    // returns whether or not the queue is empty
    boolean isEmpty();
    
    // returns the front element in the queue, without removing it
    F peek();
    
    // adds the specified newItem to the back of the queue
    void enqueue(F newItem);

    // removes and returns the front element of the queue
    F dequeue();
}