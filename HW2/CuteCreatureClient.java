/**
 * write a class cuteCreature client
 * 
 * Tam Duong
 * 2/11/2014
 */
public class CuteCreatureClient
{
    public static void main(String[] args)
    {
        CuteCreature beebee = new CuteCreature("@__@", 40, 6, 600, false);
        CuteCreature bubu = new CuteCreature("=>", 40, 6, 600, true);
        
        //calling toString method
        System.out.println(beebee+"\n");
        System.out.println(bubu+"\n");
        
        int i = 0;
        while(i < 1){       //notice this is an infinite loop, it will break when 1 of these if statement is true
            beebee.attack(bubu);
            System.out.println();
            if(bubu.getCurrentHP() <= 0)    //if bubu die then bubu doesn't get to attack again 
                break;          //break out of while loop when bubu die
            
            bubu.attack(beebee);
            System.out.println();
            if(beebee.getCurrentHP() <= 0)  //same as the above
                break;
            //no increasement for i at the end of while oop
        }
        
        if(bubu.getCurrentHP() <= 0)        //if bubu loose print result of the victory creature which is beebee
            System.out.println(beebee+"\n");
            else        //bee loose 
                System.out.println(bubu+"\n");
        
    }
}
