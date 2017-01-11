import java.util.*;
/**
 * write a method isValidPhoneNumber(String n) to determines string n is a valid or invalid phone number format
 * 
 * forms of "valid" phone number are DDD-DDD-DDDD, DDD.DDD.DDDD, DDD DDD DDDD, DDDDDDDDDD where D is a digit from 0-9
 * 
 * Tam Duong
 * 2/05/14
 */
public class PhoneNumbers
{
    public static boolean isValidPhoneNumber(String n)
    {
        String PhoneNumber = "";                           //create a new String so the orginal String will never change
        
        //if string n doesn't contain anything but 0-9, ., -, space, string PhoneNumber will be exactly the same as string n
        for(int i = 0; i < n.length(); i++)                 //check for any char that not 0-9, ., -, space
        {
            if(n.charAt(i) >= 48 && n.charAt(i) <= 57)      //0-9 in char is equivalent to 48-57 in decimal base on ASCII 
                PhoneNumber += n.charAt(i);
            else  
            {
                switch (n.charAt(i))
                {
                    case 32: PhoneNumber += n.charAt(i);          //32 is ASCII value for space
                             break;
                    case 45: PhoneNumber += n.charAt(i);          //45 is ASCII value for -
                             break;
                    case 46: PhoneNumber += n.charAt(i);          //46 is ASCII value for .
                             break;
                    default: return false;
                }
            }
        }
        
        //check if phone number is in the right form
        if(PhoneNumber.length() == 12)      //a phone number that contain ., space, - will now should have 12 char
        {
            //if phone number is in the right form (12 char with charAt(3) equal charAt(7) = either ., -, space
            //then this will delete the ., space, - to make this phone number string have 10 char
            if(PhoneNumber.charAt(3) ==  PhoneNumber.charAt(7)){
                if(PhoneNumber.charAt(3) >= 48 && PhoneNumber.charAt(7) <= 57)      //if charAt(3) = charAt(7) are 0-9 then invalid
                return false;
                PhoneNumber = PhoneNumber.substring(0,3) + PhoneNumber.substring(4,7) + PhoneNumber.substring(8);   //eleminate -, ., space
            }
        }
        
        //check if the total numbers in phone number is correct
        //a valid phone number now will contain exactly 10 char in string PhoneNumber
        //if user enter 901-867-530999 or 901-867-53 will result in false
        if(PhoneNumber.length() != 10)
            return false;
        
        //if there are a -, ., space in anywhere in PhoneNumber now is invalid
        for(int i = 0; i < PhoneNumber.length(); i++)                 //test whether or not PhoneNumber is valid
        {
            if(PhoneNumber.charAt(i) < 48 || PhoneNumber.charAt(i) > 57){       //< 48 or >57 is false not include 48 and 57
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a phone number:");
        String PhoneNumber = input.nextLine();
        long startTime = System.nanoTime();
        System.out.println("Valid phone number? "+isValidPhoneNumber(PhoneNumber));
        System.out.println(System.nanoTime() - startTime);
    }
}
