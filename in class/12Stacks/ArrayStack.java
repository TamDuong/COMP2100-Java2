
/**
 * Implementation of a stack using an array.  We let index 0
 * correspond to the bottom of the stack.  This allows us to make
 * push/pop/peek into O(1) operations since we can just go to
 * the "size" index of the data array.
 * 
 * If we had made index 0 into the top of the stack, push/pop/peek
 * would be O(n) operations since we would need to shift all
 * the elements in the array up and down with each operation.
 *
 * *MC* implement stack using array; the top of the stack 
 * is the last element of this array list
 * 
 * @author Top Malasri
 * @version Apr. 9, 2014
 */
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E>
{
    private E[] data = (E[])(new Object[10]);
    private int size = 0;

    // This is just like the add method we wrote for ArrayList.
    public void push(E newItem)
    {
        if (size == data.length) {  // reallocate data array if needed
            E[] newData = (E[])(new Object[2*data.length]);
            for (int i = 0; i < size; i++)
                newData[i] = data[i];
            data = newData;
        }
        
        data[size] = newItem;
        size++;
    }

    public E pop()
    {
        if (!isEmpty()) {
            // no need to actually "delete" the element being
            //  returned... it will be overwritten with the next
            //  call to push
            size--;
            return data[size];
        } else
            throw new EmptyStackException();
    }
    
    public E peek()
    {
        if (!isEmpty())
            return data[size-1];
        else
            throw new EmptyStackException();
    }
    
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    public static void main(String[] args)
    {
        Stack<String> s = new ArrayStack<>();
        s.push("pancakes");
        s.push("bacon");
        s.push("more bacon");
        s.push("one more bacon");
        s.push("a wad of cash");
        s.push("$100");
        s.push("$109283910283");
        
        System.out.println(s.peek());
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        //System.out.println(s.peek());
    }
}
