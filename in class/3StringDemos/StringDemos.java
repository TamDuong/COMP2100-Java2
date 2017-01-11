
/**
 * Some demonstrations of how to use Java's built-in String class.
 * 
 * @author Top Malasri
 * @version Jan. 29, 2014
 */
public class StringDemos
{
    public static void main(String[] args)
    {
        // create a new string
        char[] c = {'c', 'o', 'o', 'k', 'i', 'e', 's'};
        String s = new String(c);
        String s2 = new String("cookies");

        // always use .equals when comparing strings!  == will check whether the references
        //  are pointing to the same memory address, not whether the strings contain
        //  the same characters
        System.out.println(s == s2);
        System.out.println(s.equals(s2));
        System.out.println(s2.equals(s));

        // call charAt to isolate individual characters in a string, and length to return
        //  the number of characters in a string
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }

        // substring can be used to isolate parts of a string
        System.out.println(s.substring(3));
        System.out.println(s);

        // you can chain together method calls!  this example says "call s.substring(3,4), take
        //  the return value from that, and call charAt(0) on that return value"
        char myChar = s.substring(3,4).charAt(0);
        System.out.println(myChar);
        
        // both of these produce the same output, but one is a char while the other is a string
        System.out.println(s.substring(3,4));
        System.out.println(s.charAt(3));

        // replace the first character of a string with something else
        String test = new String("supercalifragilisticexpialidocious");
        test = 'd' + test.substring(1);
        System.out.println(test);
    }
}
