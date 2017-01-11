import java.util.*;
public class FoneNum
{
    public static boolean isValidFoneNum(String s)
    {
        if (s.length() == 12 && s.charAt(3) == s.charAt(7) && (s.charAt(3) == ' ' || s.charAt(3) == '.' || s.charAt(3) == '-'))
            s = s.substring (0,3) + s.substring(4,7) + s.substring(8);
            
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != '0' && s.charAt(i) != '1' && s.charAt(i) != '2' && s.charAt(i) != '3' && s.charAt(i) != '4' && 
                s.charAt(i) != '5' && s.charAt(i) != '6' && s.charAt(i) != '7' && s.charAt(i) != '8' && s.charAt(i) != '9' || s.length() != 10)
                return false;
        return true;
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a fone number to check:");
        String foneNum = input.nextLine();
        long startTime = System.nanoTime();
        System.out.println("This number is valid?    " + isValidFoneNum(foneNum));
        System.out.println(System.nanoTime() - startTime);
    }
}
