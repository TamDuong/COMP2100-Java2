
/**
 * subclass EvolvableCuteCreature that extends CuteCreature with new elementalAttack method and overriding levelUp() and toString methods
 * 
 * Tam Duong
 * 02/26/14
 */
public class EvolvableCuteCreature extends CuteCreature
{
    
    //constructor
    public EvolvableCuteCreature(String species, int maxHP, int attackDmg, int expValue, boolean isSpecial)
    {
        super(species, maxHP, attackDmg, expValue, isSpecial);
        //this.evolved = false;
        //this.isEvolvable = isEvolvable;
    }
    
    //other methods
    
    
    //overriding levelUp() method to handle level 20 and up
    protected void levelUp()
    {
        level++;
        System.out.println(species + " leveled to " + level + "!");
        
        //if level is 20 and creature is evolvable then maxHP,.... will be difference else it will be the same as cutecreature levelUp()
        if (level >= 20){
            evolved = true;
            if (level == 20)
                System.out.println(species + " evolved!!!");
            expValue += 10;
            currentHP += 15;
            maxHP += 15;
            attackDmg += 5;
            
            //assume that species begin with Uppercase letter, if doesn't match then creature have no element
            //**even if a creature is evolvable but the species not in the right form then this creature still can not perform element Attack
            if (species.charAt(0) >= 'A' && species.charAt(0) <= 'G')
                this.element = "fire";
            if (species.charAt(0) >= 'H' && species.charAt(0) <= 'M')
                this.element = "water";
            if (species.charAt(0) >= 'N' && species.charAt(0) <= 'S')
                this.element = "air";
            if (species.charAt(0) >= 'T' && species.charAt(0) <= 'Z')
                this.element = "earth";
        }
        else{
            expValue += 10;
            if (level <= 10) {
                currentHP += 4;
                maxHP += 4;
                attackDmg += 3;
            } else {
                currentHP += 1;
                maxHP += 1;
                attackDmg += 1;
            }
        }
    }
    
    //overriding toString method
    public String toString()
    {
        String r = "Level " + level + " " + species + "\n";
        for (int i = 0; i < 7 + (level + "").length() + species.length(); i++)
            r += "-";
        r += "\n";
        if (isSpecial)
            r += "*** Special! ***\n";
        r +=    "HP: " + currentHP + "/" + maxHP + "\n" +
                "Attack Dmg: " + attackDmg + "\n" +
                "XP: " + exp + "/" + expForNextLevel + "\n" +
                "XP Value: " + expValue + "\n"+
                "Evolved: " + evolved + "\n";
        return r;
    }

}
