import java.util.ArrayList;
/**
 * Homework 7
 * 
 * Tam Duong
 * 04/13/2014
 */
import java.util.NoSuchElementException;

public class LinkedList<E>      //*MC* you can make E to be any object you want in main method
{//*MC* most methods in this class like set method take in object type E, this mean u must give the same object just like linkedlist<E> to parameter

    // A "static" nested class cannot access the instance variables
    //  of the outer class.  That applies here, since no individual
    //  Node object needs to know about the head of the list or
    //  the list's size.
    //*MC* just like static method cannot access to private variable in the class
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

    // Returns the element at a specific list index.
    // Big-O: O(n) (due to the nodeAt call, which must traverse the list)
    public E get(int index)
    {
        return nodeAt(index).data;
    }

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
    
    // Removes and returns the first item in the list that is equivalent to specified object.
    // Return null if the list does not contain such an item
    public E removes(E item)
    {
        for (int i = 0; i < size; i++) {
            if (get(i) == item) 
                return remove(i);
            }
            
        return null;
    }
    
    // Removes all elements from the list
    public void clear()
    {
        size = 0;   // by making the size = 0 this linkedlist only print those node within the size, eventhough this linklist may have more nodes in it
    }
    
    // Reverses the order of the nodes in the calling list
    public void reverse()
    {
        for (int i = 0; i < (int)size/2; i++) {
            E temp = nodeAt(i).data;
            set(i, nodeAt(size-1-i).data);
            set(size-1-i, temp);
        }      
    }
    //public void reverse()
    //{
            //if(size > 1) {                    //if there is something to reverse
                //Node<E> prev = head,
                        //temp = head.next;
                        
                //while (temp != null) {
                    //Node<E> next = temp.next;
                    //temp.next = prev; 
                    //prev = temp;
                    //temp = next;
                //}
                //head.next = null;             //head is now the tail node 
                //head = prev;                     //prev is pointing to the new head node
            //}
    //}
    
    // Returns an ArrayList<E> object containing all elements in the calling list, 
    // in the same order
    public ArrayList<E> toArrayList()
    {
        ArrayList<E> myArray = new ArrayList<>();
        for (Node<E> temp = head; temp != null; temp = temp.next) 
            myArray.add(temp.data);        //calling add here refer to the add method of myArray class(which is ArrayList not LinkedList)
            
        return myArray;
    }
    
    // Returns a new LinkedList<E> object containig the elements of the 
    // calling list between beginIndex and endIndex(exclusive).
    // Throw an IndexOutOfBoundsException if invalid index is supplied,
    // or if beginIndex is not at least 1 less than endIndex.
    public LinkedList<E> slice(int beginIndex, int endIndex)
    {
        LinkedList<E> sub = new LinkedList<>();
        if (beginIndex >= 0 && beginIndex < size && endIndex > 0 && endIndex <= size && beginIndex < endIndex) {
            
            for (int i = beginIndex; i < endIndex; i++) 
                sub.add(get(i));
            return sub;
        } else
            throw new IndexOutOfBoundsException();
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
        LinkedList<Integer> myList = new LinkedList<>(),
                            subList = new LinkedList<>();
        
        for (int i = 1; i <= 10; i++)
            myList.add(i);      //*MC* notice add(i) i is integer which is the type of E on ln 37 parameter E newData
        System.out.println(myList);
        
//         subList = myList.slice(9, 10);
//         System.out.println(subList);
//         
//         subList = myList.slice(3, 7);
//         System.out.println(subList);
//         
         myList.reverse();
         System.out.println(myList);
//         
//         ArrayList<Integer> myArrayList = myList.toArrayList();
//         System.out.println(myArrayList);
//         
//         myList.add(10);
//         System.out.println(myList);
//         
        System.out.println(myList.remove(9));
        System.out.println(myList);
        
        myList.clear();
        System.out.println(myList); 
    }

    // The methods below are declared private since they're
    //  not meant to be called by a user of this class.  We
    //  just wrote them to help make the public methods
    //  a little easier to write.
    
    // Adds a new element to the head of the list.
    private void addToHead(E newData)
    {
        //         Node<E> newNode = new Node<>(newData, head);
        //         head = newNode;              //*MC* line below is short for these lines
        head = new Node<E>(newData, head);
        size++;
    }
    
    // Adds a new element after the specified node in the list.
    private void addAfter(E newData, Node<E> where)
    {
        //         Node<E> newNode = new Node<>(newData, where.next);
        //         where.next = newNode;      //*MC* line below is short for these lines
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
    
    //*MC* have to make nodeAt method even through we know the which node is it by its integer index but java won't read integer index
    //*MC* since index in here is a part of linkledlist<E> it work as Node<E> name
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
