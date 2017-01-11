
/**
 * computer client
 * 
 * Tam Duong
 * 3/04/2014
 */
public class ComputerClient
{
    public static void insertionSort(Comparable[] c)
    {
        for (int i = 1; i < c.length; i++){
            Comparable temp = c[i];
            int j = i-1;
            
            while (j >= 0 && temp.compareTo(c[j]) < 0){
                c[j+1] = c[j];
                j--;
            }
            c[j+1] = temp;
        }
    }
    
    public static void printArrayObject(Comparable[] c)
    {
        for (int i = 0; i < c.length; i++)
            System.out.println(c[i]);
        
    }
    
    
    public static void main(String[] args)
    {
        Computer[] computer = new Computer[5];
        
        computer[0] = new Desktop("Intel Core i7 2600K", 8, 900, 3072);
        computer[1] = new Desktop("AMD FX-8150", 12, 1024, 1296);
        computer[2] = new Laptop("Intel Core 2 Duo T7700", 2, 96, 15.1);
        computer[3] = new Laptop("Intel Core i5 4200M", 12, 2048, 17.0);
        computer[4] = new Laptop("AMD A10-4600M", 8, 800, 13.0);
        
        printArrayObject(computer);
        System.out.println("\n");
        insertionSort(computer);
        printArrayObject(computer);
    }
}
