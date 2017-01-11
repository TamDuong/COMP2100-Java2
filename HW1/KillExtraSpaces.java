import java.util.*;
public class KillExtraSpaces
{
    public static String trim(String s)
    {
        String fix = s;
        for (int i = 0; i < fix.length()-1; i++)
            if (fix.charAt(i) == ' ' && fix.charAt(i+1) == ' ') {
                fix = fix.substring(0,i) + fix.substring(i+1);
                i--;
            }
            
        if (fix.charAt(0) == ' ')
            fix = fix.substring(1);
        if (fix.charAt(fix.length()-1) == ' ')
            fix = fix.substring(0,fix.length()-1);
        
            return fix;
    }
    
    public static String trim1(String s)
    {
        String g = " ";
        char v;
        for (int i = 0; i < s.length(); i++){
            v = s.charAt(i);
            System.out.println(v);
            if (g.charAt(g.length()-1) == ' ' && v == ' ' ){
                
            } else {
                g += v;
            }
        }
        
        if (g.charAt(0) == ' ')
            g = g.substring(1);
        if (g.charAt(g.length()-1) == ' ')
            g = g.substring(0, g.length()-1);
        return g;
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter any text: ");
        String text = input.nextLine();
        long startTime = System.nanoTime();
        System.out.println("Text with all extra space remove:\n" + trim1(text));
        System.out.println(System.nanoTime() - startTime);
    }
}
