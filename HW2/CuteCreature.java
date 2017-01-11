
/**
 * write a class cuteCreature
 * 
 * Tam Duong
 * 2/11/2014
 */
public class CuteCreature
{
    //instance variables
    private String species = "";
    private int level = 0;          
    private int currentHP = 0;      //current hit points
    private int maxHP = 0;      //maximum hit points
    private int attackDamage = 0;
    private int expPoints = 0;
    private int expValue = 0;
    private boolean isSpecial = false;      //default
    private int nextlevelXP = 250;       //250 is the minimum XP needed to get to level 2
    //tried to used private static int nextlevelXP = 250; but don't work bc static variable belong to a class as a whole so when nextlevelXP for defeated creature, nextlevelXP for victory creature will also change
    //instead nextlevelXP describe as a nonstatic variable, which belongs to a specific instance of the class
    
    //constructor
    public CuteCreature (String species, int maxhp, int attackdamage, int expvalue, boolean isspecial)
    {
        setSpecies(species);
        setMaxHP(maxhp);
        setAttackDamage(attackdamage);
        setExpValue(expvalue);
        setIsSpecial(isspecial);
        setLevel(1);                //a newly created creature have a level of 1
        setCurrentHP(maxHP);        //******current hit points equal to the maximum hit points
        setExpPoints(0);            //new creature have zero experience points
    }
    
    //setter methods
    public void setSpecies(String species){
        this.species = species;     //this. specifies the instance variable not the parameter
    }
    
    public void setLevel(int level){
        this.level = level;
    }
    
    public void setCurrentHP(int currentHP){
        this.currentHP = currentHP;
    }
    
    public void setMaxHP(int maxHP){
        this.maxHP = maxHP;
    }
    
    public void setAttackDamage(int attackDamage){
        this.attackDamage = attackDamage;
    }
    
    public void setExpPoints(int expPoints){
        this.expPoints = expPoints;
    }
    
    public void setExpValue(int expValue){
        this.expValue = expValue;
    }
    
    public void setIsSpecial(boolean isSpecial){
        this.isSpecial = isSpecial;
    }
    
    //getter method
    public String getSpecies(){       //since we will only call species  and currentHP from client class then 2 getter method is enough
        return species;
    }
    
    public int getCurrentHP(){       //getter method for currentHP
        return currentHP;
    }
    
    
    //toString method
    public String toString()
    {   
        String s= "";
        if(isSpecial == true)
            s = "**** Special ****\n";
        return "Level "+level+" "+species+"\n"+"--------------------\n"+s+"HP: "+currentHP+"/"+maxHP+"\nAttack Damage: "+attackDamage+"\nXP: "+expPoints+"/"+nextlevelXP+"\nXP Value: "+expValue;
    }
    
    
    //other methods
    public void takeDamage(int dmg)
    {
        if(dmg < 0)     //check for invalid hit points
            System.out.println("Invalid amount of damage");
        else if(dmg == 0)       //out of hit points
            System.out.println("Miss!!!");
        else if(dmg >= currentHP){              //amount of damage has taken
            System.out.println(species +" took " + dmg + " damage");
            System.out.println(species +" has been defeated!");
            currentHP -= dmg;
        }
        else {
            System.out.println(species +" took " + dmg + " damage");
            currentHP -= dmg;
        }
    }
    
    private void levelUp()
    {
        if(level >=2 && level <= 10){
            maxHP += 4;
            currentHP += 4;     //***look at constructor for currentHP
            attackDamage += 3;
            expValue += 10;
        }
        else{
            maxHP += 1;
            currentHP += 1;     //***look at constructor for currentHP
            attackDamage += 1;
            expValue += 10;
        }
        System.out.println(species +" is now level " + level + "!");
    }
    
    public void gainExp(int exp)
    {
        expPoints += exp;
        System.out.println(species +" gained " + exp + "experience.");
        int i = 250;        //250 is the experience point required for level 2
        if (expPoints >= 250){          //from level 2 and up
            while(nextlevelXP <= expPoints){     //the total exppoint required for next level is equal to the  level exppoint + the last level exppoint
                level++;
                levelUp();
                i+=50;      //experience per level increases by 50
                nextlevelXP += i ;
            }
            
        }
        
    }
    
    public void attack(CuteCreature c)
    {
        System.out.println(species + " attacks " + c.species);
        int chance = (int)(1 +Math.random()*100);       //chance is the percent chance of animal acttack, chance is the positive number between 0 to 100. 
        if (chance <= 75){           //75% chance of hittting
            System.out.print("Hit! ");
            double hittingChances = (-20 +(int)(Math.random()*41))/100.0;     //percent of damage within -20% to 20% of attack damage. This can be (-) or (+)
            int actualDamage = (int)(attackDamage + Math.round((attackDamage*hittingChances)));   //actual damage equal to attack damage +/- hitting chances
            c.takeDamage(actualDamage);
            if(c.currentHP <= 0){
                    System.out.println(species + " win!!!");
                    gainExp(c.expValue);
                    
                }
        }
            else if (chance >75 && chance <=80){     //5% chance of critical hit
                System.out.print("Critical Hit!! " );
                int actualDamage = attackDamage*2;
                c.takeDamage(actualDamage);
                if(c.currentHP <= 0){
                    System.out.println(species + " win!!!");
                    gainExp(c.expValue);
                    
                }
            }
                else            //20% remain is of missing
                    takeDamage(0);
    }
}
