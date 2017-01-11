
/**
 * Quick demo of how to use the Scanner class to read a file.
 * This code counts the number of words in the file.
 * 
 * @author Top Malasri
 * @version Mar. 26, 2014
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadDemo
{
    public static void main(String[] args)
    {
        try {
            Scanner s = new Scanner(new File("candy.txt")); //scan and store this file to s 

            int numWords = 0;
            while (s.hasNext()) {   //*MC* hasNext() returns true if the iteration has more elements. 
                String nextLine = s.nextLine(); //*MC* nextLine() advances this scanner past the current line and returns the input that was skipped.
                System.out.println(nextLine);
                String[] words = nextLine.split("\\s+");    // split around one or more spaces (\\s is space) notice nextLine is the string name declared in line 22.
                                                            //*MC* use .split() to factor out the unwanted character
                numWords += words.length;
            }
            System.out.println("Total number of words: " + numWords);

        } catch (FileNotFoundException e) {
            System.out.println("I can't find that file!");
        }
    }
}

