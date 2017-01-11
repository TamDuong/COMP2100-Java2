
/**
 * Illustrates insertion sort for an array of ints vs.
 * an array of Comparables.
 * 
 * @author Top Malasri
 * @version Feb. 26, 2014
 */
public class Sorting
{
    // Implements the insertion sort algorithm for an array of ints.
    public static void insertionSort(int[] a)
    {
        for (int i = 1; i < a.length; i++) {
            int numToInsert = a[i];
            
            int j = i - 1;
            while (j >= 0 && numToInsert < a[j]) {
                a[j+1] = a[j];
                j--;
            }
            
            a[j+1] = numToInsert;
        }
    }

    // This version of insertion sort works on an array of Comparables.
    // Very nice because it allows us to sort objects from *any* class,
    //  as long as that class implements Comparable!
    public static void insertionSort(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++) {
            Comparable objectToInsert = a[i];
            
            int j = i - 1;
            while (j >= 0 && objectToInsert.compareTo(a[j]) < 0) {
                a[j+1] = a[j];
                j--;
            }
            
            a[j+1] = objectToInsert;
        }
    }
    
    public static void printArray(Object[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }
    
    public static void printArray(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }
    
    
    public static void main(String[] args)
    {
        int[] a = {7, 3, 5, 0, -5, -9, 0, 3, 5, 7};
        printArray(a);
        insertionSort(a);
        printArray(a);
        
        Dolphin[] pod = new Dolphin[3];
        pod[0] = new Dolphin(100, 1);
        pod[1] = new Dolphin(4000, 11);
        pod[2] = new Dolphin(101, 1);

        printArray(pod);
        insertionSort(pod);
        printArray(pod);
    }
    
}
