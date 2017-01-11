
/**
 * Implementation of queue using an array.  The main idea here is
 * to keep track of which indices in the array correspond to the
 * front and back of the queue, and let both of those indices vary.
 * Enqueueing increases the back index, while dequeueing increases
 * the front index.  This allows us to make peek/enqueue/dequeue
 * into O(1) operations.
 * 
 * To minimize wasted space in the array, the front and back indices
 * are allowed to reset to 0 if necessary.
 * 
 * @author Top Malasri
 * @version Apr. 21, 2014
 */
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E>
{
    private E[] data = (E[])(new Object[5]);
    private int front = 0, back = -1;
    private int size = 0;
    
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    // look at the front index of the queue
    public E peek()
    {
        if (!isEmpty())
            return data[front];
        else
            throw new NoSuchElementException();
    }

    // increment the back index, and insert the new item
    //  at that location
    public void enqueue(E newItem)
    {
        if (size == data.length) {  // reallocate array if necessary
            E[] newData = (E[])(new Object[2*data.length]);
            for (int i = 0, j = front; i < data.length; i++) {
                newData[i] = data[j];
                j = (j + 1) % data.length;
            }
            data = newData;
            front = 0;  // reset front and back relative to the newData array
            back = size - 1;
        }
        back = (back + 1) % data.length;
        data[back] = newItem;
        size++;
    }
    
    // increment the front index
    public E dequeue()
    {
        if (!isEmpty()) {
            E temp = data[front];
            front = (front + 1) % data.length;
            size--;
            return temp;
        } else
            throw new NoSuchElementException();
    }
    
    public String toString()
    {
        String r = "ArrayQueue (size = " + size + "), containing (front to back): ";
        for (int i = 0, j = front; i < size; i++) {
            r += data[j] + " ";
            j = (j + 1) % data.length;
        }
        return r;
    }

    public static void main(String[] args)
    {
        Queue<String> f = new ArrayQueue<>();
        f.enqueue("milk");
        f.enqueue("eggs");
        f.enqueue("beer");
        f.enqueue("murder victims");
        f.enqueue("bacon");
        f.enqueue("cheese");
        f.enqueue("Bud");
        System.out.println(f);
        
        while (!f.isEmpty()) {
            System.out.println(f.peek());
            System.out.println(f.dequeue());
            System.out.println(f);
        }

        f.enqueue("milk");
        f.enqueue("eggs");
        f.enqueue("beer");
        f.enqueue("murder victims");
        f.enqueue("bacon");
        f.enqueue("cheese");
        f.enqueue("Bud");
        System.out.println(f);
        System.out.println(f.peek());
        System.out.println(f.dequeue());
        System.out.println(f);
    }
}
