
/**
 * Simulation of a store checkout line, using queues.  The store has a single
 * line of customers, who are helped by multiple customer service representatives
 * (CSRs).
 * 
 * Uses Java's built-in Queue<E> interface and its implementation
 * in the built-in LinkedList<E> class.
 * 
 * @author Top Malasri
 * @version Apr. 21, 2014
 */
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Simulation
{
    /**** SIMULATION PARAMETERS ****/
    private final int   NUM_CSRS = 6,               // number of customer service representatives available to help customers
                        MAX_WAIT_TIME = 10;         // max time that a customer is willing to wait in line before s/he leaves
    /*******************************/

    private Queue<Customer> customersInLine,        // queue to simulate people waiting in line
                            customersArriving;      // queue holding customer arrival data (which is read from file)
                                                    //  This is mainly so that the file can be read all at once -- put the
                                                    //  file data into here, and use this queue as the simulation runs.
    
    private int     qtyBought = 0,                  // total quantity of items bought/lost by customers
                    qtyLost = 0,
                    totalWaitTime = 0,              // total wait time of customers in line who eventually got service
                    totalCustomersServed = 0,       // number of customers who eventually got service
                    totalCustomersLost = 0;         // number of customers who left the line due to slow service

    private double  priceBought = 0,                // total price of items bought/lost by customers
                    priceLost = 0;  


    // Constructor - initializes the customersArriving queue by reading the specified file
    public Simulation(String fileName)
    {
        readCustomersArriving(fileName);
    }
                    
    // Reads customer arrival data from a file into the queue customersArriving
    // MUST be called before calling runSimulation()
    public void readCustomersArriving(String fileName)
    {
        Scanner fileScanner = null;

        // Create a Scanner object on the input file
        try {
            fileScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            System.exit(1);
        }

        // Instantiate customersArriving
        customersArriving = new LinkedList<Customer>();
        
        // Read the input file line by line.  For each line, create a new
        // Customer object and enqueue it to customersArriving.
        while (fileScanner.hasNextLine()) {
            String thisLine = fileScanner.nextLine();
            String[] tokens = thisLine.split(" ");
            int aTime = Integer.parseInt(tokens[0]);
            int tTime = Integer.parseInt(tokens[1]);
            int transQty = Integer.parseInt(tokens[2]);
            double transPrice = Double.parseDouble(tokens[3]);
               
            Customer newGuy = new Customer(aTime, tTime, transQty, transPrice);
            customersArriving.add(newGuy);       // add() acts like our enqueue() method
        }
        
        fileScanner.close();
    }
    
    
    // Main driver method that runs the simulation
    // readCustomersArriving() MUST be called before calling this method
    public void runSimulation()
    {
        // Initialize the customersInLine queue
        customersInLine = new LinkedList<Customer>();
        
        // This array keeps track of the time until each CSR is available
        //  to help the next customer in the customersInLine.
        // When the array is initialized the default value is 0 -- i.e., all CSRs are available immediately.
        int[] timeTillService = new int[NUM_CSRS];
        
        // Run the simulation until at least 120 time units have passed and the customersInLine is empty
        int time = 0;
        while (time <= 120 || !customersInLine.isEmpty()) {

            // Display the current time
            System.out.println("");
            System.out.println("Time " + time + ":");
            for (int i = 0; i < ("" + time).length() + 6; i++)
                System.out.print("-");   
            System.out.print("\n\n");

            // Check for new customers arriving in line (by looking at the customersArriving queue).
            //  If one has arrived, enqueue him/her in the customersInLine.
            if (!customersArriving.isEmpty() && (customersArriving.element().getArriveTime() == time)) {    // element() acts like our peek() method
                Customer newCustomer = customersArriving.remove();                                          // remove() acts like our dequeue() method
                customersInLine.add(newCustomer);                                                           // add() acts like our enqueue() method
                System.out.println("Just arrived at the line: " + newCustomer);
            }

            // Go through the timeTillService array, and for each CSR see if s/he can help the next
            //  customer in line.  If the CSR is available, dequeue the customer from the customersInLine.
            for (int i = 0; i < NUM_CSRS; i++) {
                if (timeTillService[i] == 0 && !customersInLine.isEmpty()) {   // a customer is waiting, and this CSR is ready

                    // the CSR will be occupied until the transaction finishes, so
                    //  update his/her timeTillService with the customer's transaction time
                    Customer dequeuedCustomer = customersInLine.remove();
                    timeTillService[i] = dequeuedCustomer.getTransTime();
    
                    // update group statistics with this customer
                    qtyBought += dequeuedCustomer.getTransQty();
                    priceBought += dequeuedCustomer.getTransPrice();
                    totalWaitTime += dequeuedCustomer.getTimeInLine();
                    totalCustomersServed++;
                    
                    System.out.println("CSR" + (i+1) + " is now helping: " + dequeuedCustomer);
                }                
            }

            // Show the current waiting time for each CSR
            System.out.print("Waiting times for CSRs: ");   
            for (int i = 0; i < NUM_CSRS; i++)
                System.out.print(timeTillService[i] + " ");
            System.out.print("\n");

            // Update waiting times for each CSR
            for (int i = 0; i < NUM_CSRS; i++)
                if (timeTillService[i] > 0)
                    timeTillService[i]--;

            // Now update the customers who are still in the customersInLine queue.
            // If any customer has been waiting for MAX_WAIT_TIME or longer, s/he leaves the queue;
            //  otherwise, increase the time in line of that customer by 1.
            Iterator<Customer> iter = customersInLine.iterator();
            while (iter.hasNext()) {       // traverse the customersInLine
                Customer thisCustomer = iter.next();
                
                // this customer leaves the queue if s/he's been waiting MAX_WAIT_TIME or longer
                if (thisCustomer.getTimeInLine() >= MAX_WAIT_TIME) {
                    iter.remove();

                    // update group statistics with the leaving customer
                    qtyLost += thisCustomer.getTransQty();
                    priceLost += thisCustomer.getTransPrice();
                    totalCustomersLost++;

                    System.out.println("Left the line due to poky service: " + thisCustomer);

                // if this customer stays in line, increment his/her timeInLine by 1
                } else {
                    thisCustomer.incrementTimeInLine();
                }
            }

            // Show current group statistics
            System.out.println("Total stats so far:");
            System.out.printf("\tItems bought:\tqty = %d, price = $%.2f%n", qtyBought, priceBought);
            System.out.printf("\tItems lost:\tqty = %d, price = $%.2f%n", qtyLost, priceLost);
            System.out.printf("\tCustomers:\tserved = %d, lost = %d%n", totalCustomersServed, totalCustomersLost);
            System.out.printf("\tAverage waiting time of served customers: %.3f%n", (double)totalWaitTime/totalCustomersServed);
            
            // Pause the simulation for a little bit, then increment time
            try {
                Thread.sleep(0);    // this will pause program execution for the specified number of milliseconds
            } catch (InterruptedException e) { }
            time++;
        }   // end simulation loop
    }

    
    public static void main(String[] args)
    {
        Simulation s = new Simulation("data.txt");  // create a new Simulation object, reading from the specified file
        s.runSimulation();                          // run the simulation!
    }
}
