
/**
 * A class for a single node in a linked list.
 * 
 * @author Top Malasri
 * @version Mar. 31, 2014
 */
public class Node<E>        //*MC* E is just an object, it can be integer object or string, etc
{
    private E data;     // this node's data
    private Node<E> next;   // the next node in the list
    
    public E getData()
    {
        return data;
    }
    
    public Node<E> getNext()
    {
        return next;
    }

    public void setData(E data)
    {
        this.data = data;
    }
    
    public void setNext(Node<E> next) 
    {
        this.next = next;
    }
    
    public Node(E data, Node<E> next)
    {
        setData(data);
        setNext(next);
    }
}
