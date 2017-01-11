
/**
 * Quick demo of how to write text to a file using the PrintWriter class.
 * 
 * @author Top Malasri
 * @version Mar. 26, 2014
 */
import java.io.*;

public class FileWriteDemo
{
    // Don't actually declare the main method to throw an exception! :)
    // I'm just doing this to show it will appease the compiler.
    public static void main(String[] args)
        throws FileNotFoundException
    {
        PrintWriter p = new PrintWriter("output.txt");
        
        // calling println doesn't actually write the lines to
        //  file yet -- they are stored temporarily in a buffer
        p.println("This is my first output file!");
        p.println("Let's ask Gradma to post it on the fridge!");

        // you could also call p.flush() to write the lines to
        //  file without closing the PrintWriter object
        // *mycomment* p.flush() to save the file 
        // p.close() to save+close the file (this mean after calling p.close() u whatever u write after this line will NOT going to be on the file)
        p.close();
        p.println("hello");
    }
}

