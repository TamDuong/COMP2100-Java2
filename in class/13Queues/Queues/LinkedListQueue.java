
/**
 * Implementation of a queue using a linked list.  We let the
 * head of the list correspond to the front of the queue, and
 * the tail of the list correspond to the back of the queue.  By
 * maintaining references to both the head and tail nodes, we
 * make enqueue/dequeue/peek into O(1) operations.
 * 
 * @author Top Malasri
 * @version Apr. 16, 2014
 */
import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E>
{
    // same nested class for Node that we used in LinkedList
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
    
    private Node<E> head, tail;
    private int size = 0;
    
    public boolean isEmpty()
    {
        return (size == 0);
    }

    // look at the head node of the list
    public E peek()
    {
        if (!isEmpty())
            return head.data;
        else
            throw new NoSuchElementException();
    }

    // add a new node at the tail of the list
    public void enqueue(E newItem)
    {
        if (isEmpty())  // adding to an empty list makes the new node both the head and the tail
            head = tail = new Node<E>(newItem, null);
        else
            tail = tail.next = new Node<E>(newItem, null);
        size++;
    }
    
    // remove the list's head node
    public E dequeue()
    {
        if (!isEmpty()) {
            E temp = head.data;
            head = head.next;
            size--;
            if (size == 0)  // if removal results in an empty list, point tail to null
                tail = null;
            return temp;
        } else {
            throw new NoSuchElementException();
        }
    }
    
    public String toString()
    {
        String r = "LinkedListQueue (size = " + size + "), containing (front to back): ";
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            r += temp.data + " ";
            temp = temp.next;
        }
        return r;
    }
    
    public static void main(String[] args)
    {
        Queue<String> f = new LinkedListQueue<>();
        f.enqueue("milk");
        f.enqueue("eggs");
        f.enqueue("beer");
        f.enqueue("murder victims");
        f.enqueue("bacon");
        f.enqueue("cheese");
        f.enqueue("Jack Daniel's");
        System.out.println(f);
        
        System.out.println(f.peek());
        System.out.println(f.dequeue());
        System.out.println(f);
        
        System.out.println(f.peek());
        System.out.println(f.dequeue());
        System.out.println(f);

        System.out.println(f.peek());
        System.out.println(f.dequeue());
        System.out.println(f);
    }
}
