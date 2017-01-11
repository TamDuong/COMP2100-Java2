import java.util.*;
public class LongestPalindrome
{   
    public static String FLP(String s)
    {
        int low, high, start = 0, size = 1;
        
        for (int i = 0; i < s.length()-1; i++) {
            //even length pal excluding length 0
            low = i; 
            high = i+1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > size) {
                    start = low;
                    size = high - low + 1;
                }
                low--;
                high++;
            }
            
            //odd length palindrome excluding length 1
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > size) {
                    start = low;
                    size = high - low + 1;
                }
                low--;
                high++;
            }
        }
        if (s.length() == 0)
            return "";
        else 
            return s.substring(start, start + size);
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a string to find its longest palindrome:");
        String text = input.nextLine();
        long startTime = System.nanoTime();
        System.out.println("Longest Palindrome: " + FLP(text));
        System.out.println(System.nanoTime() - startTime);
    }
}