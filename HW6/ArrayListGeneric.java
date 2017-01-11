
/**
 * homework 6
 * 
 * MC: 193, 194
 * 
 * Tam Duong
 * 04/07/2014
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
    
    // Replaces the element at the specified index of the list with something.
    // else Throws a NoSuchElementException if an invalid index is provided.
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
    
    // Adds the specified newItem to the specified index in the calling list, shifting all subsequent elements up by one index.
    // Throw an IndexOutOfBoundsException if an invalid index is supplied.
    public void add(int index, E newItem)
    {
        if (index >= 0 && index < size) {
            if (size == data.length) {  // if the list is at capacity...
                // create a new, larger array
                E[] newData = (E[])(new Object[2*data.length]);
                
                // copy over all of the old elements
                for (int i = 0; i < size; i++)
                    newData[i] = data[i];
                    
                // redirect the old data reference
                data = newData;
            }
            
            for (int i = size-1; i >= index; i--)
                data[i+1] = data[i];
                
            data[index] = newItem;
            size++;
        } else
            throw new IndexOutOfBoundsException();
    }
    
    // Adds all of the elements in anotherList to the back of the calling list
    public void addAll(ArrayListGeneric<E> anotherList)
    {
        if ((size + anotherList.data.length) >= data.length) {
            // create a new, larger array
            E[] newData = (E[])(new Object[anotherList.data.length + data.length]);
            
            // copy over all of the old elements
            for (int i = 0; i < size; i++)
                newData[i] = data[i];
                
            // redirect the old data reference
            data = newData;
        }
        
        for (int i = 0; i < anotherList.size; i++, size++)
            data[size] = anotherList.data[i];
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
    
    // Removes and returns the element at the specified index
    // if the removal results in a new size that is less than half of the capacity, the capacity should be halved.
    public E removeAndTrim(int index)
    {
        if (index >= 0 && index < size) {
            E temp = data[index]; // element to return

            // shift all elements from the right down by 1 index
            for (int i = index; i < size - 1; i++)
                data[i] = data[i+1];
            size--;
            
            if (size < (int)(data.length/2)) {
                E[] newData = (E[])(new Object[(int)(data.length/2)]);
                
                for (int i = 0; i < size; i++)
                    newData[i] = data[i];
                    
                data = newData;
            }
            return temp;
            
        } else
            throw new NoSuchElementException();
    }
    
    // Removes all elements from list and resetting its capacity to default value
    public void clear()
    {
        size = 0;
        data = (E[])(new Object[3]);    //reinstantiate array capacity to default
    }
    
    // Returns a new ArrayListGeneric<E> object containing the elements of the calling list between beginIndex(inclusive) and endIndex(exclusive)
    // throw an IndexOutOfBoundsException if an invalid index is supplied or beginIndex is not at least 1 less than endIndex 
    public ArrayListGeneric<E> slice(int beginIndex, int endIndex)
    {
        ArrayListGeneric<E> sub = new ArrayListGeneric<>();
        if (beginIndex >=0 && beginIndex < size && endIndex > 0 && endIndex <= size && beginIndex < endIndex) {
            
            for(int i = 0, j = beginIndex; i < endIndex-beginIndex; i++, j++)
                sub.add(this.data[j]);
            return sub;
        } else
            throw new IndexOutOfBoundsException();
    }
    
    // Returns the highest index in the calling list that contains someData, or -1 if the list does not contain that data.
    public int lastIndexOf(E someData)
    {
        int highestIndex = -1;
        
        for (int i = 0; i < size; i++) {
            if (data[i].equals(someData))
                highestIndex = i;
            }
            
        return highestIndex;
    }
    
    public String toString()
    {
        String r = "ArrayListGeneric object (size = " + size + ", capacity = " + data.length + "), containing these elements:\n";
        for (int i = 0; i < size; i++)
            r += get(i) + "\n";
        return r;
    }
    
    public static void main(String[] args)  //*MC* think of this main method as a client class of arrayListGeneric. when declare arraylistgeneric a and b,
    {// all of the method above belong to a individualy and b individualy. To call method of a u must write a.methodyouwant
        ArrayListGeneric<String> a = new ArrayListGeneric<>(),  // this list can store only strings -- trying to add another
                                                                //  type will result in a compiler error. () mean empty, if put (20) mean array of 20
                                 b = new ArrayListGeneric<>();
        
                                 
        System.out.println(a);
        a.add("0");
        a.add("10");
        a.add("15");
        a.add("20");
        System.out.println(a);
        
        System.out.println(b);
        b.add("10");
        b.add("20");
        b.add("15");
        b.add("10");
        System.out.println(b);
        
        b.add(3, "10");
        System.out.println(b);
        
        System.out.println(b.slice(3, 5));
        
        a.addAll(b);
        System.out.println(a);
        
        System.out.println(a.remove(3));
        System.out.println(a.removeAndTrim(0));
        System.out.println(a.removeAndTrim(2));
        System.out.println(a.removeAndTrim(4));
        System.out.println(a.removeAndTrim(3));
        System.out.println(a.removeAndTrim(1));
        System.out.println(a);
        
        int findhighest = a.lastIndexOf("10");
        System.out.println(findhighest);
        
        a.clear();
        System.out.println(a);
    }
}
