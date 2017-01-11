
/**
 * superclass CuteCreature
 * 
 * Tam Duong
 * 02/26/14
 */
public class CuteCreature
{
    protected String  species;
    protected int     level,
                    currentHP,
                    maxHP,
                    attackDmg,
                    exp,                // total current exp
                    expForNextLevel,    // total exp needed for next level
                    expValue;
    protected boolean isSpecial;
    protected String element = "";
    //protected boolean isEvolvable;        //not every creature can evolve
    protected boolean evolved;            //evolved become true when creature reach level 20
    
    
    public CuteCreature(    String species,
                            int maxHP, int attackDmg, int expValue,
                            boolean isSpecial )
    {
        this.species = species;
        this.level = 1;
        this.currentHP = this.maxHP = maxHP;
        this.attackDmg = attackDmg;
        this.exp = 0;
        this.expForNextLevel = 250;
        this.expValue = expValue;
        this.isSpecial = isSpecial;
    }
    
    //setter method to call from client class for currentHP
    public int getCurrentHP()
    {
        return currentHP;
    }
    
    public void takeDamage(int dmg)
    {
        currentHP -= dmg;
        System.out.println(species + " took " + dmg + " damage!");
        if (currentHP <= 0) {
            currentHP = 0;
            System.out.println(species + " fainted!");
        }
    }
    
    protected void levelUp()
    {
        level++;
        System.out.println(species + " leveled to " + level + "!");
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
    
    public void gainExp(int exp)
    {
        System.out.println(species + " gained " + exp + " experience!");
        int expLeft = exp;  // remaining exp to allocate
        
        while (expLeft > 0) {
            // level up if there's sufficient exp
            if (this.exp + expLeft >= expForNextLevel) {
                int expNeededToLevel = expForNextLevel - this.exp;
                this.exp += expNeededToLevel;
                expLeft -= expNeededToLevel;
                
                levelUp();
                expForNextLevel += (250 + (level-1)*50);

            // otherwise just add the new exp
            } else {
                this.exp += expLeft;
                expLeft = 0;
            }
        }
    }
    
    public void attack(CuteCreature c)
    {
        System.out.println(species + " attacks " + c.species + "!");
        double r = Math.random();   // to hit roll; from 0.0 to less than 1.0
        int dmg = (int)(0.8*attackDmg + 0.5*attackDmg*Math.random());   // determine base damage; 0.5*Math.random() mean from 0.0 to 0.4 is random hitting chang within -20% to +20%
        if (r <= 0.75) {
            System.out.print("Hit! ");
            c.takeDamage(dmg);
        } else if (r <= 0.8) {
            System.out.print("Critical hit! ");
            c.takeDamage(dmg*2);
        } else {
            System.out.println("Miss!");
        }
        
        if (c.currentHP == 0) {
            System.out.println(species + " defeated " + c.species + "!");
            gainExp(c.expValue);
        }
    }
    
    //elemental Attack method
    public void elementalAttack(CuteCreature c)
    {
        if(evolved == true){
            System.out.println("Hit");
            
            if (element.equals("fire")){
                if (c.element.equals("fire"))  //cast c to evolvablecutecreature but if c is a regular creature then it will have empty string as element
                    c.takeDamage(0);                            //deal 0 dmg due to same element
                else if (c.element.equals("water"))
                    c.takeDamage((int)(attackDmg*0.25));        //deal 0.25*dmg for resist
                else if (c.element.equals("air"))
                    c.takeDamage(attackDmg*4);                  //deal 4*dmg for vulnerable
                else
                    c.takeDamage(attackDmg);                    //deal normal dmg to earth element and other creature with no element
            }
            
            if (element.equals("water")){
                if (c.element.equals("water"))
                    c.takeDamage(0);
                else if (c.element.equals("earth"))
                    c.takeDamage((int)(attackDmg*0.25));
                else if (c.element.equals("fire"))
                    c.takeDamage(attackDmg*4);
                else
                    c.takeDamage(attackDmg);
            }
            
            if (element.equals("air")){
                if (c.element.equals("air"))
                    c.takeDamage(0);
                else if (c.element.equals("fire"))
                    c.takeDamage((int)(attackDmg*0.25));
                else if (c.equals("earth"))
                    c.takeDamage(attackDmg*4);
                else
                    c.takeDamage(attackDmg);
            }
            
            if (element.equals("earth")){
                if (c.element.equals("earth"))
                    c.takeDamage(0);
                else if (c.element.equals("air"))
                    c.takeDamage((int)(attackDmg*0.25));
                else if (c.element.equals("water"))
                    c.takeDamage(attackDmg*4);
                else
                    c.takeDamage(attackDmg);
            }
        }
        else
            System.out.println("Not evolved yet!!! Cannot perform special elemental attack.");
            
        if (c.currentHP == 0) {
            System.out.println(species + " defeated " + c.species + "!");
            gainExp(c.expValue);
        }
    }
    
    
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
                "XP Value: " + expValue + "\n";
        return r;
    }
    
}
