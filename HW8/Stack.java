
/**
 * Stack interface
 * 
 * Tam Duong 
 * 4/28/2014
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
