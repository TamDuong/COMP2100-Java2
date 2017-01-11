
/**
 * Demonstrates how polymorphism works with interfaces.
 * 
 * Differences between this code and the inheritance example are commented below.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Client2
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        
        // this array is now an array of "objects from classes that implement the Playable interface,"
        // rather than an array of Media objects
        Playable[] library = new Playable[3];
        
        for (int i = 0; i < library.length; i++) {
            System.out.print("Enter media type (1 = CD, 2 = DVD, 3 = Blu-Ray): ");
            int mediaType = s.nextInt();
            s.nextLine();
            System.out.print("Enter the title: ");
            String title = s.nextLine();
            System.out.print("Enter the year: ");
            int year = s.nextInt();

            // use the classes CD2, DVD2, BluRay2 here
            switch (mediaType) {
                case 1:
                    library[i] = new CD2(title, year);
                    break;
                case 2:
                    library[i] = new DVD2(title, year);
                    break;
                case 3:
                    library[i] = new BluRay2(title, year);
                    break;
                default:
                    System.out.println("You are incompetent.");
            }
        }

        for (int i = 0; i < library.length; i++) {
            library[i].play();
        }
    }
}
