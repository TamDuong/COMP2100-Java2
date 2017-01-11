import java.util.NoSuchElementException;
/**
 * bad implementation of queue
 * 
 * Tam Duong 
 * 4/28/2014
 */
public class NaughtyArrayQueue<F> implements Queue<F>
{
    private F[] data = (F[])(new Object[5]);
    private int size = 0;
    
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    // look at the front index of the queue
    public F peek()
    {
        if (!isEmpty())
            return data[0];
        else
            throw new NoSuchElementException();
    }
    
    //  add the item
    public void enqueue(F newItem)
    {
        if (size == data.length) {  // reallocate array if necessary
            F[] newData = (F[])(new Object[3*data.length]);
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
       
        for (int i = size; i > 0; i--)       //shift all element to the right
            data[i] = data[i-1];
        
        data[0] = newItem;
        size++;
        }
        
    public F dequeue()
    {
        if (!isEmpty()) {
            F temp = data[0];
            for (int i = 0; i < size-1; i++)
                data[i] = data[i+1];
            size--;
            return temp;
        } else
            throw new NoSuchElementException();
    }
    
    public String toString()
    {
        String r = "ArrayQueue (size = " + size + "), containing (front to back): ";
        for (int i = 0; i < size; i++) {
            r += data[i] + " ";
        }
        return r;
    }
}
