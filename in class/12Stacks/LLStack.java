
/**
 * Implementation of a stack using a linked list.  We let the
 * head of the list correspond to the top of the stack.  This
 * allows us to make push, pop, and peek into O(1) operations
 * since adding and removing from the head of the list does not
 * depend on the length of the list.
 * 
 * If we made the tail of the list correspond to the top of
 * the stack, push/pop/peek would become O(n) operations since
 * a traversal of the list would be required.
 * 
 * @author Top Malasri
 * @version Apr. 9, 2014
 */
import java.util.EmptyStackException;

public class LLStack<E> implements Stack<E>
{
    // Same nested Node class as in LinkedList
    private static class Node<E>
    {
        private E data;     // this node's data
        private Node<E> next;   // the next node in the list
        
        public Node(E data, Node<E> next)
        {
            this.data = data;
            this.next = next;
        }
    }
    
    private Node<E> head = null;
    private int size = 0;

    // This is equivalent to adding a new node at the head of
    //  the list.
    public void push(E newItem)
    {// Same nested Node class as in LinkedList
        head = new Node<>(newItem, head);
        size++;
    }

    // This is equivalent to removing the head node from the
    //  list.
    public E pop()
    {
        if (!isEmpty()) {
            E temp = head.data;
            head = head.next;
            size--;
            return temp;
        } else
            throw new EmptyStackException();
    }

    public E peek()
    {
        if (!isEmpty())
            return head.data;
        else
            throw new EmptyStackException();
    }
    
    public boolean isEmpty()
    {
        return (size == 0);
    }

    public static void main(String[] args)
    {
        Stack<String> s = new LLStack<>();
        s.push("pancakes");
        s.push("bacon");
        s.push("more bacon");
        s.push("one more bacon");
        s.push("a wad of cash");
        s.push("$100");
        s.push("$109283910283");
        
        System.out.println(s.peek());
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        System.out.println(s.peek());
    }
}
