/**
 * Implementation of quicksort, and comparison vs. insertion sort.
 *
 * @author Top Malasri
 * @version Apr. 30, 2014
 */
public class Sorting
{
    // Insertion sorts the specified array of ints.  We start by assuming
    //  the element at index 0 is already sorted.
    public static void insertionSort(int[] a)
    {
        // for each element after index 0, insert it into the correct
        //  position relative to the already-sorted elements to its left
        for (int i = 1; i < a.length; i++) {
            int numToInsert = a[i];

            // search for the correct insertion point, shifting
            //  array elements down as we go
            int j = i - 1;
            while (j >= 0 && numToInsert < a[j]) {
                a[j+1] = a[j];
                j--;
            }
            
            // insert the item
            a[j+1] = numToInsert;
        }
    }
    
    
    // Wrapper method for quicksort
    public static void quicksort(int[] a)
    {
        quicksort(a, 0, a.length - 1);
    }
    
    // Recursively quicksorts the array a between indices start and end, inclusive
    private static void quicksort(int[] a, int start, int end)
    {
        if (start < end) {  // base case is when start is no longer < end (i.e., nothing to sort)
            int j = quicksortPartition(a, start, end);
            quicksort(a, start, j - 1);
            quicksort(a, j + 1, end);
        }
    }
    
    // Partitions the array a between indices start and end, inclusive.  We use the start index as the
    //  pivot element, and arrange all the array elements such that the ones <= pivot are on the left,
    //  and the ones > pivot are on the right.
    private static int quicksortPartition(int[] a, int start, int end)
    {
        // pick a pivot
        int pivot = a[start];

        int lower = start, upper = end;
        while (lower < upper) {
            // look for the first element (from the left) that's greater than the pivot
            while (lower < end) {
                if (a[lower] > pivot)
                    break;
                lower++;
            }
            
            // look for the first element (from the right) that's less than or equal to the pivot
            while (upper > start) {
                if (a[upper] <= pivot)
                    break;
                upper--;
            }
                
            // swap lower/upper indices if lower < upper
            if (lower < upper) {
                int temp = a[lower];
                a[lower] = a[upper];
                a[upper] = temp;
            }
        }
        
        // swap the pivot (at index start) with index upper
        int temp = a[start];
        a[start] = a[upper];
        a[upper] = temp;
        
        return upper;
    }
    
    

    public static void printArray(int[] a)
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.print("\n");
    }
    
    public static void main(String[] args)
    {
        int[] a = new int[100000];
        int[] b = new int[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i] = (int)(100*Math.random());
        }
        
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        insertionSort(a);
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        
        startTime = System.currentTimeMillis();
        quicksort(b);
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
