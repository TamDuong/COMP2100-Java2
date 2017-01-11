import java.util.EmptyStackException;
/**
 * bad implementation of stack
 * 
 * Tam Duong 
 * 4/28/2014
 */
public class NaughtyLinkedListStack<E> implements Stack<E>
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
    
    // Add a new node to the tail from the list
    public void push(E newItem)
    {
        if (isEmpty())          // if this list is empty then head node is the tail node
            head = new Node<>(newItem, null);
        else {
            Node<E> tail = lastElement();
            tail.next = new Node<>(newItem, null);
        }
        size++;
    }
    
    // Remove the tail node from the list
    public E pop()
    {
        if (!isEmpty()) {
            Node<E> temp = lastElement();
            E removeData = temp.data;
            temp = null;
            size--;
            return removeData;
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
    
    // Return the tail node
    public Node<E> lastElement()
    {
        Node<E> tail = head;
        while (tail.next != null)//for (int i = 0; i < size-1; i++) 
            tail = tail.next;
        return tail;
    }
    
}
