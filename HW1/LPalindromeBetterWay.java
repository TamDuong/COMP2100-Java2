import java.util.*;
public class LPalindromeBetterWay
{
    public static String findLP(String s)
    {
        int left, right, start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // even length palindrome
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left >= end - start) {  // >= or > either is ok but changing the order of even length to the bottom will need to keep it this way
                                                    // Ex: oo, tt, aa, hh, are the case
                                                    // use >= since end - start will mostlikely equal to right-left (only for the case
                                                    // that user put odd palindrome first)
                    start = left;
                    end = right + 1;                // add 1 since substring won't get the last char in the string 
                }
                left--;
                right++;
            }
            
            // odd length palindrome
            left = i;
            right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left >= end - start) {  // use >= so it won't give emplty string when there are only 1 char in the string
                    start = left;
                    end = right + 1;                // add 1 since substring won't get the last char in the string 
                }
                left--;
                right++;
            }
        }
        return s.substring(start, end);
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a string to find its longest palindrome:");
        String text = input.nextLine();
        long startTime = System.nanoTime();
        System.out.println("Longest Palindrome: " + findLP(text));
        System.out.println(System.nanoTime() - startTime);
    }
}