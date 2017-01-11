
/**
 * write an abstract class Computer that contain many common elements as possible for desktop and laptop.
 * this class should contain an abstract getCost() method
 * 
 * Tam Duong
 * 3/04/2014
 */
public abstract class Computer implements Comparable
{
    protected String processor;
    protected int RAM,
                  harddrive;
    protected double cost;
                  
    public Computer(String processor, int RAM, int harddrive)
    {
        this.processor = processor;
        this.RAM = RAM;
        this.harddrive = harddrive;
    }
    
    public abstract double getCost();
    
    //compareTo method - specify how computer object should be compare base on cost
    public int compareTo(Comparable cost)
    {
        Computer com = (Computer) cost;    //cost is not define in Comparable so need casting
        if (this.cost >= com.cost)            //or getCost() is fine bc we have line 23. 
        //we have a concrete method for getCost() in Desktop and Laptop which is what Java will take for the getCost() since line 23 is abstract so it can not be call
            return 0;
        else 
            return -1;
    }
}
