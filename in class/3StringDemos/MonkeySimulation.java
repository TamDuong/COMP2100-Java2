
/**
 * Simulates a monkey who's locked in a room and furiously banging
 * randomly at a keyboard in an attempt to generate the works of
 * Shakespeare.  We assume the monkey is intelligent enough to
 * type only capital letters.
 * 
 * @author Top Malasri
 * @version Jan. 29, 2014
 */
public class MonkeySimulation
{
    public static void main(String[] args)
    {
        String monkeysOutput = "";  // what the monkey has typed so far
        String target = "HAMLET";   // what we want the monkey to type
        long keysPressed = 0;       // tracks the number of keys pressed by the monkey
        
        // Start by randomly hitting target.length() keys
        for (int i = 0; i < target.length(); i++) {
            char c = (char)(26*Math.random() + 'A');
            monkeysOutput += c;
        }
        keysPressed = target.length();
        System.out.println(monkeysOutput);

        // ... and repeat until the monkey has generated the target string
        while (!monkeysOutput.equals(target)) {
            char c = (char)(26*Math.random() + 'A');
            keysPressed++;
            monkeysOutput += c;     // add the new character to the end of the monkey's output
            monkeysOutput = monkeysOutput.substring(1); // cut off the first character from the monkey's output
        }

        System.out.println(monkeysOutput);
        System.out.println("The monkey has finally generated the word!");
        System.out.println(keysPressed);
    }
}
