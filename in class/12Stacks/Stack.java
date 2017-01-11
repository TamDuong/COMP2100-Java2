
/**
 * Interface that represents a stack.  A stack is a collection of items
 * that can be interacted with from only one end (the top of the stack).
 * 
 * The rule used for a stack is to always remove the item that has been 
 * in the collection the least amount of time. This policy is known as 
 * last-in first-out or LIFO.
 * 
 * We implement this Stack interface in two ways: using an array and
 * using a linked list.
 * 
 * @author Top Malasri
 * @version Apr. 9, 2014
 */
public interface Stack<E>
{
    // Adds the specified newItem to the top of the stack.
    void push(E newItem);

    // Removes and returns the top element from the stack.
    E pop();

    // Returns the top element from the stack, without removing it.
    E peek();

    // Returns whether the stack is empty.
    boolean isEmpty();
}
