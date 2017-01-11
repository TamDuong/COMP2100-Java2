
/**
 * Laptop class - concrete subclass of computer
 * 
 * Tam Duong
 * 3/04/2014
 */
public class Laptop extends Computer
{
    private double screenSize;
    
    
    public Laptop(String processor, int RAM, int harddrive, double screenSize)
    {
        super(processor, RAM, harddrive);
        this.screenSize = screenSize;
        calculateCost();
    }
    
    public double getCost()
    {
        return cost;
    }
    
    public void calculateCost()
    {
        cost = 300 + (8.00*RAM) + (0.19*harddrive) + (13.83*screenSize);
    }
    
    public String toString()
    {
        return "Laptop:\n-------\n"+
                "CPU: " + processor + "\n"+
                "RAM: " + RAM + " GB\n"+
                "HDD: " + harddrive + " GB\n"+
                "Screen: "+screenSize+"\"\n"+
                "Cost: $" + getCost()+"\n";
    }
}
