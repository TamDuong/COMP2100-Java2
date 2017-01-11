
/**
 * LinkedList class, with recursive implementations for size()
 * and get() methods.
 * 
 * @author Top Malasri
 * @version Apr. 30, 2014
 */
import java.util.NoSuchElementException;

public class LinkedList<E>
{
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
    
    private Node<E> head;   // head node of the list
    private int size = 0;   // number of elements that have been added to the list

    // Wrapper method for size
    public int size()
    {
        return size(head);
    }

    // Recursive implementation of size -- returns the number
    //  of nodes in the list, starting from the node "where"
    private int size(Node<E> where)
    {
        if (where == null)
            return 0;
        else
            return 1 + size(where.next);
    }

    // Wrapper method for get
    public E get(int index)
    {
        return get(index, head, 0);
    }

    // Recursive implementation of get.  The three parameters
    //  are the desired index to get, the current node, and
    //  the index of the current node.
    public E get(int index, Node<E> where, int whereIndex)
    {
        if (whereIndex == index)
            return where.data;
        else
            return get(index, where.next, whereIndex + 1);
    }
    
    
    // Returns the element at a specific list index.
    // Big-O: O(n) (due to the nodeAt call, which must traverse the list)
//     public E get(int index)
//     {
//         return nodeAt(index).data;
//     }

    // Replaces the element at the specified index with the specified
    //  new data.
    // Big-O: O(n)
    public void set(int index, E newData)
    {
        nodeAt(index).data = newData;
    }

    // Adds the specified element to the end of the list
    //  (or to the head if the list is empty).
    // Big-O: O(1) if adding to head, O(n) otherwise
    public void add(E newData)
    {
        if (size == 0)
            addToHead(newData);
        else
            addAfter(newData, nodeAt(size-1));
    }

    // Removes and returns the element at the specified index.
    // Big-O: O(1) if removing from head, O(n) otherwise
    public E remove(int index)
    {
        if (index == 0)
            return removeFromHead();
        else
            return removeAfter(nodeAt(index-1));
    }
    
    public String toString()
    {
        String r = "LinkedList object (size = " + size + "), containing:\n";
        r += "head -> ";
        for (int i = 0; i < size;  i++)
            r += get(i) + " -> ";
        r += "null";
        return r;
    }
    
    public static void main(String[] args)
    {
        LinkedList<Integer> myList = new LinkedList<>();
        System.out.println(myList.size());

        for (int i = 1; i <= 10; i++)
            myList.add(i);
        System.out.println(myList);
        
        System.out.println(myList.size());
        
        System.out.println(myList.get(3));

    }

    // The methods below are declared private since they're
    //  not meant to be called by a user of this class.  We
    //  just wrote them to help make the public methods
    //  a little easier to write.
    
    // Adds a new element to the head of the list.
    private void addToHead(E newData)
    {
        head = new Node<E>(newData, head);
        size++;
    }
    
    // Adds a new element after the specified node in the list.
    private void addAfter(E newData, Node<E> where)
    {
        where.next = new Node<E>(newData, where.next);
        size++;
    }
    
    // Removes and returns the element at the head of the list.
    // Throws a NoSuchElementException if the list is empty.
    private E removeFromHead()
    {
        if (head != null) {
            E temp = head.data;
            head = head.next;
            size--;
            return temp;
        } else {
            throw new NoSuchElementException();
        }
    }
    
    // Removes and returns the element after the specified node
    //  in the list.  Throws a NoSuchElementException if called
    //  with the last node in the list (since there is nothing to
    //  remove after the last node).
    private E removeAfter(Node<E> where)
    {
        if (where != null && where.next != null) {
            E temp = where.next.data;
            where.next = where.next.next;
            size--;
            return temp;
        } else {
            throw new NoSuchElementException();
        }
    }
    
    // Returns the node at the specified index in the list
    //  (index 0 = head).  Throws an IndexOutOfBoundsException if
    //  an invalid index is provided.
    private Node<E> nodeAt(int index)
    {
        if (index >= 0 && index < size) {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) // traverse the list
                temp = temp.next;
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
