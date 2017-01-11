
/**
 * Representation of a customer standing in line.
 * 
 * @author Top Malasri
 * @version Apr. 21, 2014
 */
public class Customer
{
    private int timeInLine,     // time this customer has been waiting in line
                arriveTime,     // time this customer arrived at the checkout line
                transTime,      // time this customer will take to complete his/her transaction
                transQty;       // quantity of items this customer plans to purchase
    private double transPrice;  // price of items this customer plans to purchase

    // Accessors
    public int getTimeInLine() { return timeInLine; }
    public int getArriveTime() { return arriveTime; }
    public int getTransTime() { return transTime; }
    public int getTransQty() { return transQty; }
    public double getTransPrice() { return transPrice; }

    // Increments timeInLine by 1
    public void incrementTimeInLine() { timeInLine++; }

    // Constructor - sets timeInLine to 0 and allows specification of the other instance variables
    public Customer(int aTime, int tTime, int qty, double price)
    {
        timeInLine = 0;
        arriveTime = aTime;
        transTime = tTime;
        transQty = qty;
        transPrice = price;
    }

    public String toString()
    {
        return (    "CUSTOMER\n" +
                        "\tArrived " + arriveTime + ", trans " + transTime + ", qty " + transQty + ", price " + transPrice + "\n" +
                        "\tWaiting in line for " + timeInLine   );
    }

    public boolean equals(Object o)
    {
        if (o instanceof Customer) {
            Customer c = (Customer)o;
            return (    getTimeInLine() == c.getTimeInLine()    &&
                        getArriveTime() == c.getArriveTime()    &&
                        getTransTime() == c.getTransTime()      &&
                        getTransQty() == c.getTransQty()        &&
                        getTransPrice() == c.getTransPrice()    );
        } else {
            return false;   
        }
    }
}
