import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
  
/**
 * Mapping class
 * 
 * Tam Duong
 * 04/18/14
 */
public class Mapping
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the name of the file to load data: ");
        String file = input.nextLine();
        System.out.print("Enter the start and end vertex(separate by spaces): ");
        String read = input.nextLine();
        String[] read2 = read.split("\\s+");
    
        
        try {
            Graph a = new Graph(file);
            a.dijkstra(read2[0], read2[1]);
            System.out.println(a);
        } catch (FileNotFoundException e) {
            System.out.println("This file does not exit!!!");
        } catch (InputMismatchException e) {
            System.out.println("This vertex does not exit, please try with vertex that in your file!");
        }
    }
}
