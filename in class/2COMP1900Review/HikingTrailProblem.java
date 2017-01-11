
/**
 * COMP 1900 review problem - now complete!
 * 
 * @author Top Malasri
 * @version Jan. 27, 2014
 */
import java.util.Scanner;

public class HikingTrailProblem
{
    // This method allows the user to enter a number of markers, and
    //  an elevation in feet for each marker.  The elevation info is
    //  stored in an array and returned.
    public static double[] readElevations()
    {
        Scanner fluffy = new Scanner(System.in);
        
        // get user input for the number of markers
        System.out.println("How many markers would you like to enter?");
        int numMarkers = fluffy.nextInt();
        
        // instantiate an array of the correct size
        double[] elevations = new double[numMarkers];

        // go through the array and collet user input for each position
        for (int i = 0; i < numMarkers; i++) {
            System.out.println("Enter the next elevation in feet:");
            elevations[i] = fluffy.nextDouble();
        }

        // return the populated array
        return elevations;
    }

    // This method returns whether the given trail is "level."  A trail is
    //  level if the difference between the max and min elevations on the
    //  trail is 10 ft or less.
    public static boolean isLevel(double[] elevations)
    {
        // find the max and min of the elevations array
        double max = elevations[0], min = elevations[0];
        
        for (int i = 1; i < elevations.length; i++) {
            if (elevations[i] >  max) {
                max = elevations[i];
            }
            
            if (elevations[i] < min) {
                min = elevations[i];
            }
        }

        // returns true if (max - min) is <= 10, false otherwise
        return (max - min <= 10);
    }
    
    // This method returns whether the given trail is "difficult."  A trail
    //  is considered difficult if there are at least 3 sets of adjacent
    //  markers with an elevation difference of 30 ft or more.  The 3 sets
    //  do not necessarily have to be consecutive.
    public static boolean isDifficult(double[] elevations)
    {
        int c = 0;  // keeps track of the number of adjacent markers with >= 30 ft difference

        // check all sets of adjacent markers in the array (indices 0 and 1, 1 and 2, 2 and 3, etc.)
        //  we stop at elevations.length - 1 to prevent an out of bounds exception
        for (int i = 0; i < elevations.length - 1; i++) {
            if (Math.abs(elevations[i] - elevations[i+1]) >= 30) {
                c++;
            }
        }
        
        return (c >= 3);
    }
    
    // Main method
    public static void main(String[] args)
    {
        // call the readElevations method
        double[] elevations = readElevations();

        // display the entered elevations (just to verify that readElevations worked)
        for (int i = 0; i < elevations.length; i++) {
            System.out.println(elevations[i]);
        }
        
        // call the isLevel and isDifficult methods
        System.out.println("Is level? " + isLevel(elevations));
        System.out.println("Is difficult? " + isDifficult(elevations));
    }
}
