import java.util.*;
/**
 * write a method trim(String s) that returns a version of the parameter s with all extra spaces removed.
 * (Only remove the extraneous ones not all)
 * 
 * TAM DUONG
 * 2/7/2014
 */
public class EliminateExtraSpace
{
    public static String trim(String s)
    {
        
        //eliminate spaces infront of string s
        for (int i = 0; i < s.length(); i++)    //i can be the running index
        {
            if (s.charAt(i) == 32){         
                s = s.substring(i+1);       //reassign string with with its substring(i+1) 
                i--;            //since string s been change then we should take i back to its last value before entering if statement
                                //bc the condition of for loop base on i and s.length(); s.length(0) will keep changing but i should always be at index 0
                                //if i keep changing then this will create a plit and still leave extra space infront of string s
            }
            else
                break;      //when this index hit a char that not a space then this loop and the for loop
        }
        
        //eliminate spaces on the back of string s
        for (int i = s.length()-1; i >= 0; i--)
        {
            if (s.charAt(i) == 32){
                s = s.substring(0,i);
            }
            else
                break;
        }
        
        //eliminate spaces in the body of string
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == 32){     //this index is a space
                if(s.charAt(i+1) == 32){    //test whether or not the index next to the above index is a space
                    s = s.substring(0,i) + s.substring(i+1);
                    i--;            //same as the 1st for statement for eleminate space infront of string s
                }
            }
        }
    
        return s;
    }
    
    public static void main(String[] args)
    {
        String information = "";
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the information below:");
        information = input.nextLine();
        long startTime = System.nanoTime();
        String correctInformation = trim(information);
        System.out.println(correctInformation);
        System.out.println(System.nanoTime() - startTime);
    }
}
