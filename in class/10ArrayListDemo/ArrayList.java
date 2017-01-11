
/**
 * An ArrayList class to store integers.
 * 
 * An array list uses an array to store its elements.  As we add and remove
 * elements from the list, the class keeps track of the size of the list and
 * reallocates the array to make it bigger if necessary.
 * 
 * @author Top Malasri
 * @version Mar. 26, 2014
 */
import java.util.NoSuchElementException;

public class ArrayList
{
    private int[] data = new int[3];        // where the data is kept
    private int size = 0;                   // the number of elements that have been added to the list
    
    // Returns the element at the specified index of the list.
    // Throws a NoSuchElementException if an invalid index is provided.
    // Big-O: O(1)
    public int get(int index)
    {
        if (index >= 0 && index < size)
            return data[index];
        else
            throw new NoSuchElementException();
    }
    
    // Replaces the element at the specified index of the list with something else.
    // Throws a NoSuchElementException if an invalid index is provided.
    // Big-O: O(1)
    public void set(int index, int newValue)
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
    public void add(int a)
    {
        if (size == data.length) {  // if the list is at capacity...
            // create a new, larger array
            int[] newData = new int[2*data.length];
            
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
    public int remove(int index)    
    //*MC* doesn't actually delete the element from data array, it just decrease the size by 1 so the last element won't get display in the toString method
    {
        if (index >= 0 && index < size) {
            int temp = data[index]; // element to return

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
        String r = "ArrayList object (size = " + size + ", capacity = " + data.length + "), containing these elements:\n";
        for (int i = 0; i < size; i++)
            r += get(i) + "\n";
        return r;
        
        //*MC* if replace size with data.length and get(i) with data[i] then it will show the full data array
        //String r = "ArrayList object (size = " + size + ", capacity = " + data.length + "), containing these elements:\n";
        //for (int i = 0; i < data.length; i++)
        //    r += data[i] + "\n";
        //return r;
    }
    
    public static void main(String[] args)
    {
        ArrayList a = new ArrayList();
        System.out.println(a);
        
        a.add(4);
        System.out.println(a);
        
        a.add(6);
        System.out.println(a);

        a.add(14);
        System.out.println(a);
        
        a.add(20);
        System.out.println(a);
        
        System.out.println(a.get(0));
        System.out.println(a);
        
        System.out.println(a.remove(3));
        System.out.println(a);
        
        System.out.println(a.remove(0));
        System.out.println(a);

        System.out.println(a.remove(1));
        System.out.println(a);
    }
}
