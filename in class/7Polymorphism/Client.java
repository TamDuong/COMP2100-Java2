
/**
 * Demonstration of how polymorphism works with inheritance.
 * 
 * Notice that Java has no way of knowing what specific types of Media
 * objects (CD, DVD, BluRay) are in the "library" array *until the program runs*.
 * Hence, the determination of what version of the "play" method to call
 * does not occur until runtime, by the Java virtual machine (JVM).
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Media[] library = new Media[3]; // an array of Media objects

        // for each position in the array, get user input for
        // media type/title/year, then instantiate an object
        // of the proper subclass and place it in the array
        for (int i = 0; i < library.length; i++) {
            System.out.print("Enter media type (1 = CD, 2 = DVD, 3 = Blu-Ray): ");
            int mediaType = s.nextInt();
            s.nextLine();
            System.out.print("Enter the title: ");
            String title = s.nextLine();
            System.out.print("Enter the year: ");
            int year = s.nextInt();
            
            switch (mediaType) {
                case 1:
                    library[i] = new CD(title, year);
                    break;
                case 2:
                    library[i] = new DVD(title, year);
                    break;
                case 3:
                    library[i] = new BluRay(title, year);
                    break;
                default:
                    System.out.println("You are incompetent.");
            }
        }

        // Polymorphism in action!  The JVM determines the correct version of play to call, at runtime
        for (int i = 0; i < library.length; i++) {
            library[i].play();
        }
    }
}
