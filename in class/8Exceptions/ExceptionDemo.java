
/**
 * Some basic demonstrations of exception handling.
 * 
 * @author Top Malasri 
 * @version Mar. 19, 2014
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo
{
    // Prompts the user to enter an integer, and returns the
    //  value that was entered.
    public static int getIntInput()
    {
        Scanner s = new Scanner(System.in);
        boolean inputValid = false;
        int n = 0;
        while (!inputValid) {
            System.out.println("Enter an integer!");
            try {   // *try* to do the following actions
                n = s.nextInt();
                inputValid = true;
            } catch (InputMismatchException e) {    // ... and if an exception is thrown, catch it in the appropriate block
                System.out.println("Hey, that is NOT an integer!");
                s.nextLine();   // advance the Scanner past the invalid input
            } catch (Exception e) {                 // you can include as many catch blocks as desired -- just make sure they're
                                                    // ordered from most to least specific type
            }
        }
        return n;
    }
    
    // Prompts the user to enter a positive integer, and returns the
    //  value that was entered.  Demonstrates how to tell your code
    //  to throw its own exceptions.
    //
    // The throws clause in the method header is needed because
    //  NonPositiveNumberException is a checked exception.  By declaring
    //  that the exception is thrown, we are deferring its handling to
    //  whoever calls the getIntInput2() method.
    public static int getIntInput2() throws NonPositiveNumberException
    {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a positive integer!");
        int n = s.nextInt();
        
        if (n <= 0) {
            throw new NonPositiveNumberException();
        }
        
        return n;
    }
    
    
    public static void main(String[] args)
    {
        // main needs to handle the exception thrown by getIntInput2()
        try {
            int myVar = getIntInput2();
        } catch (NonPositiveNumberException e) {            //*MC* e here is an arbitrary object type it can be thing you want
            System.out.println("That is not a positive number, doofus!");
        }
        
        int myNum = getIntInput();
    }
}
