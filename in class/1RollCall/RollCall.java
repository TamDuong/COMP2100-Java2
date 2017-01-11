
/**
 * I want the roll to be called randomly instead of in alphabetical order!
 * 
 * Alas, right now I have two arrays containing the first and last names separately,
 * ordered by last name.  How can I get the full names to be displayed randomly?
 * 
 * @author Top Malasri
 * @version Jan. 22, 2014
 */
public class RollCall
{
    public static void main(String[] args)
    {
        String[] lastNames = {"Ali","Aniglo","Arega","Barwick","Bernal","Black","Blazier","Brewer","Bryant","Cheng","Cole","Coleman","Cupit","Diep","Dodge","Duong","Eanes","Edwards","Ellis","Hall","Harris","Hatten","Hiller","Hopper","Jacobs","Jones","Later","Li","Link","Lou","Maddox","Marshall","Mcglown","Moore","Murphy","Murphy","Odero","Padilla Valle","Pappas","Park","Patton","Peterson","Ransom","Rapp","Riddle","Robb","Sagardia","Salerno","Sawyer","Schranze","Suite","Tate","Thomas","Tubbs","Vance","Webb","Williams","Williams","Williams","Wood","Young"};
        String[] firstNames = {"Gadafi","Herve","Dereje","Joshua","Alexander","Evan","Kieran","Daniel","Taylor","Keli","Cassie","James","James","Kenny","David","Tam","Jeffrey","Paul","Jacob","Christopher","Kendal","Cletus","Justin","Brandon","David","Cooper","Seth","Linna","Nathaniel","Ming","Matthew","Aaron","Cadarrius","Derek","Joseph","Benjamin","Mary","Enyil","Clifton","Se","Garry","Mark","Grant","Charles","Matthew","William","Gabriel","Zackery","Samuel","Adam","William","Cameron","Jared","Timothy","Michael","David","Kevin","Melanie","Joseph","William","Denzel"};

        // create and populate a new array to store the full names
        String[] fullNames = new String[lastNames.length];

        for (int i = 0; i < fullNames.length; i++) {
            fullNames[i] = firstNames[i] + " " + lastNames[i];
        }

        // shuffle the array 100 times
        for (int j = 0; j < 100; j++) {
            // each "shuffle" involves going through the whole array and swapping each
            //  index in the array with another randomly chosen index
            for (int i = 0; i < fullNames.length; i++) {
                // pick a random index
                int randomIndex = (int)(fullNames.length*Math.random());
                
                // swap the names at index i and the randomly chosen index
                String temp = fullNames[i];
                fullNames[i] = fullNames[randomIndex];
                fullNames[randomIndex] = temp;
            }
        }

        // print the contents of the shuffled array
        for (int i = 0; i < fullNames.length; i++) {
            System.out.println((i+1) + ". " + fullNames[i]);
        }
    }
}
