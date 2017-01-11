
/**
 * Generic version of the ArrayList class.  This adds an extra type parameter
 * E, which is replaced by a specific class when you instantiate ArrayListGeneric.
 * This allows you to limit the elements stored in the list to a particular
 * type -- for example, an ArrayListGeneric<String> object can store only strings.
 * 
 * @author Top Malasri
 * @version Mar. 31, 2014
 */
import java.util.NoSuchElementException;

public class ArrayListGeneric<E>
{
    // casting the Object array to E[] is needed here to get around Java's restrictions on generic array creation
    private E[] data = (E[])(new Object[3]);        // where the data is kept
    private int size = 0;                   // the number of elements that have been added to the list
    
    // Returns the element at the specified index of the list.
    // Throws a NoSuchElementException if an invalid index is provided.
    // Big-O: O(1)
    public E get(int index)
    {
        if (index >= 0 && index < size)
            return data[index];
        else
            throw new NoSuchElementException();
    }
    
    // Replaces the element at the specified index of the list with something else.
    // Throws a NoSuchElementException if an invalid index is provided.
    // Big-O: O(1)
    public void set(int index, E newValue)
    {
        if (index >= 0 && index < size)
            data[index] = newValue;
        else
            throw new NoSuchElementException();
    }
    
    // Adds the specified element to the end of the list.  Automatically reallocates the
    //  data array to make room if needed.
    // Big-O: if no array reallocation is needed, O(1)
    //        if array reallocation is needed, O(n)
    // "amortized constant time"
    public void add(E a)
    {
        if (size == data.length) {  // if the list is at capacity...
            // create a new, larger array
            E[] newData = (E[])(new Object[2*data.length]);
            
            // copy over all of the old elements
            for (int i = 0; i < size; i++)
                newData[i] = data[i];
                
            // redirect the old data reference
            data = newData;
        }

        // insert the new element
        data[size] = a;
        size++;
    }
    
    // Removes and returns the element at the specified index from the list.
    // Throws a NoSuchElementException if an invalid index is provided.
    // Big-O: O(n)
    public E remove(int index)
    {
        if (index >= 0 && index < size) {
            E temp = data[index]; // element to return

            // shift all elements to the right down by 1 index
            for (int i = index; i < size - 1; i++)
                data[i] = data[i+1];
            
            size--;
            return temp;
        } else
            throw new NoSuchElementException();
    }
    
    public String toString()
    {
        String r = "ArrayListGeneric object (size = " + size + ", capacity = " + data.length + "), containing these elements:\n";
        for (int i = 0; i < size; i++)
            r += get(i) + "\n";
        return r;
    }
    
    public static void main(String[] args)
    {
        ArrayListGeneric<String> a = new ArrayListGeneric<>();  // this list can store only strings -- trying to add another
                                                                //  type will result in a compiler error
        System.out.println(a);
        
        a.add("4");
        System.out.println(a);
        
        a.add("6");
        System.out.println(a);

        a.add("14");
        System.out.println(a);
        
        a.add("20");
        System.out.println(a);
        
        System.out.println(a.get(0) + a.get(1));    // string concatenation (since the return from the get method is a string)
        System.out.println(a);
        
        System.out.println(a.remove(3));
        System.out.println(a);
        
        System.out.println(a.remove(0));
        System.out.println(a);

        System.out.println(a.remove(1));
        System.out.println(a);
    }
}
