
/**
 * Two examples of using recursion: binary search, and the
 * Towers of Hanoi problem.
 * 
 * Edit on Apr. 28: Added the recursive linear search implementation.
 * 
 * @author Top Malasri
 * @version Apr. 28, 2014
 */
public class RecursiveMethods
{
    // Wrapper method for the recursive version of linear search.
    public static int linearSearch(int[] a, int key)
    {
        return linearSearch(a, key, 0);
    }
    
    // Recursive implementation of linear search -- searches the
    //  specified array for the key, from the provided startIndex.
    //  Returns the index in the array where the key exists, or
    //  -1 if the key does not exist.
    private static int linearSearch(int[] a, int key, int startIndex)
    {
        // base case - key not found
        if (startIndex == a.length) {
            return -1;
        // base case - key found
        } else if (a[startIndex] == key) {
            return startIndex;

        } else {
            // search the rest of the array, excluding startIndex
            return linearSearch(a, key, startIndex + 1);
        }
    }
    
    // "Wrapper" method for the recursive version of
    //  binary search.  This allows a client program to
    //  call the method without having to specify which
    //  indices of the array to search.
    public static int binarySearch(int[] a, int key)
    {
        return binarySearch(a, key, 0, a.length - 1);
    }

    // Recursive implementation of binary search -- searches
    //  the specified array for the key, between startIndex
    //  and endIndex (inclusive).
    // Returns the index of the key in the array if found, or
    //  -1 if not found.
    private static int binarySearch(int[] a, int key, int startIndex, int endIndex)
    {
        // base case - key not found in array
        if (startIndex > endIndex)
            return -1;

        // find the middle index
        int midIndex = (startIndex + endIndex)/2;

        // base case - key found in array
        if (key == a[midIndex]) {
            return midIndex;
        } else if (key > a[midIndex]) {
            // search the right half
            return binarySearch(a, key, midIndex + 1, endIndex);
        } else {
            // search the left half
            return binarySearch(a, key, startIndex, midIndex - 1);
        }
    }

    // Solves the Towers of Hanoi problem of moving numDiscs from
    //  column start to column end, using column mid as a temporary
    //  "holding area."
    public static void solveHanoi(int numDiscs, String start, String end, String mid)
    {
        // base case is when there are 0 discs to move - in this
        //  case do nothing!
        if (numDiscs > 0) {
            solveHanoi(numDiscs - 1, start, mid, end);
            System.out.println("Move the disc from " + start + " to " + end + ".");
            solveHanoi(numDiscs - 1, mid, end, start);
        }
    }
    
    public static void main(String[] args)
    {
        int[] a = {0, 2, 6, 13, 17, 24, 32};
        
        for (int i : a)
            System.out.println(linearSearch(a, i));
        
        System.out.println(linearSearch(a, 99));
    }
}
