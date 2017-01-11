
/**
 * Desktop class - concrete subclass of computer
 * 
 * Tam Duong
 * 3/04/2014
 */
public class Desktop extends Computer
{
    private int videoRAM;
    //dont have to redeclare cost since we already have it in the superclass
    
    public Desktop(String processor, int RAM, int harddrive, int videoRAM)
    {
        super(processor, RAM, harddrive);
        this.videoRAM = videoRAM;
        calculateCost();
    }
    
    public double getCost()
    {
        return cost;
    }
    
    public void calculateCost()
    {
        this.cost = 150;        //the value of cost in computer class is now been replace by this cost
        this.cost += (6.50 * RAM);   //$6.50*(RAM in GB)
        this.cost += (0.15 * harddrive);  //$0.15*(hard drive space in GB)
        this.cost += (0.48 * videoRAM);  //$0.48*(VRAM in MB)
    }
    
    public String toString()
    {
        return "Desktop:\n--------\n"+
                "CPU: " + processor + "\n"+
                "RAM: " + RAM + " GB\n"+
                "HDD: " + harddrive + " GB\n"+
                "VRAM: "+ videoRAM +" MB\n"+
                "Cost: $" + getCost()+ "\n";
    }
}
