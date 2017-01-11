
/**
 * Implements the Caesar cipher, a simple encryption scheme.
 * To encrypt a message, we simply replace each character with
 * another letter according to a specified "shift" amount.
 * For example, in a cipher with a shift of 3, the letter A
 * would be replaced by the letter D.
 * 
 * @author Top Malasri
 * @version Feb. 3, 2014
 */
public class CaesarCipher
{
    // Encrypts the specified plaintext using the indicated
    //  shift amount, and returns the resulting ciphertext.
    //  We assume the plaintext is provided in capital letters.
    public static String encrypt(String plaintext, int shift)
    {
        String ciphertext = "";     // the string to return
        
        // go through each character of the plaintext
        for (int i = 0; i < plaintext.length(); i++) {
            char thisChar = plaintext.charAt(i);
            
            // check for the character being a letter -- if so,
            //  create the shifted character and add that
            //  shifted character to the ciphertext
            if (thisChar >= 'A' && thisChar <= 'Z') {
                char newChar = (char)(thisChar + shift);
                if (newChar > 'Z')  // handle shifting past Z
                    newChar = (char)(newChar - 26);
                ciphertext += newChar;
            }
        }
        
        return ciphertext;
    }
    
    public static void main(String[] args)
    {
        String s = "ZEBRAS";
        System.out.println(encrypt(s, 1));
    }
}
