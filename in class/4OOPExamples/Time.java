
/**
 * This class represents a time of day (hour and minute).  Time objects always store
 * the hour as a number from 0-23 and the minute as a number between 0-59.  We
 * can change how the object is displayed in the toString method by using a boolean
 * instance variable to switch between 12 and 24 hour modes.
 * 
 * @author Top Malasri
 * @version Feb. 3, 2014
 */
public class Time
{
    // Static variable - the value for this variable is shared among *all* Time objects.  The purpose
    //  of this variable is to keep track of the number of Time objects that have been created.  The
    //  variable gets incremented every time we call the Time constructor.
    private static int numTimeObjects = 0;

    // Getter method for the static variable
    public static int getNumTimeObjects()
    {
        return numTimeObjects;
    }
    
    // Instance variables
    private int hour = 0, minute = 0;
    private boolean is24Hours = false;      //*MC* that mean all time is set in basic 12 hour

    // Setter methods
    public void setHour(int hour)
    {
        if (hour >= 0 && hour <= 23)
            this.hour = hour;   // this.hour specifies the instance variable hour, to distinguish it from the parameter hour
    }
    
    public void setMinute(int minute)
    {
        if (minute >= 0 && minute <= 59)
            this.minute = minute;
    }
    
    // Toggles 24 hour mode on or off (the default is off)
    public void toggle24Hours()
    {
        is24Hours = !is24Hours;
    }
    
    // Constructor - need to specify the hour and minute when creating a new Time object in *24 hour mode*
    public Time(int hour, int minute)
    {
        setHour(hour);
        setMinute(minute);
        numTimeObjects++;
    }

    // Increases the minute by 1, rolling over to the next hour if necessary
    public void incrementMinute()
    {
        minute++;
        if (minute == 60) {
            minute = 0;
            incrementHour();
        }
    }

    // Increases the hour by 1, rolling over to the next day if necessary
    public void incrementHour()
    {
        hour++;
        if (hour == 24)
            hour = 0;
    }

    // toString method.  This is automatically called by Java whenever it needs to treat a Time
    // object as a string (such as when printing the object on the screen).  This toString
    // method determines how to format the time based on whether we're in 12 or 24 hour mode.
    public String toString()
    {
        if (is24Hours) {        // in 24 hour mode
            String m;           
            if (minute < 10)    // add a leading zero for single-digit minutes
                m = "0" + minute;
            else
                m = "" + minute;    // this creates a string from the int value minute, by concatenating it with the empty string
            return hour + ":" + m;

        } else {                // in 12 hour mode
            String h;
            if (hour > 12)          // convert afternoon/evening times into something between 1-12
                h = "" + (hour - 12);
            else if (hour == 0)     // special case for midnight
                h = "12";
            else
                h = "" + hour;
            
            String m;
            if (minute < 10)    // add a leading zero for single-digit minutes
                m = "0" + minute;
            else
                m = "" + minute;
            
            String amOrPm;
            if (hour >= 12)     // determine whether to add an AM or PM to the end
                amOrPm = "pm";
            else
                amOrPm = "am";
            
            return h + ":" + m + " " + amOrPm;
        }
    }
    
    // Test main method
    public static void main(String[] args)
    {
        System.out.println("Number of Time objects :" + Time.getNumTimeObjects() + "\n");       //*MC* since getNumTimeObjects() method is a static then u can call it using the class or any of the class instances variable and it will be the same
        
        Time t = new Time(21, 00);  // haven't toggle24Hours() this should be 9:00 pm
        System.out.println("Original time object: " + t);
        System.out.println("Number of Time objects :" + getNumTimeObjects() + "\n");            //*MC* this main method is place inside class Time so call Time.get... or not it will find get... in Time class anyway
        
        Time t2 = new Time(12, 49);
        System.out.println("Original time object: " + t2);
        for (int i = 1; i <= 300; i++)
            t2.incrementMinute();
        System.out.println("Time object after increment of minute: " + t2);     // 5:49 pm
        System.out.println("Number of Time objects :" + t.getNumTimeObjects() + "\n");
        
        Time t3 = new Time(0, 0);
        System.out.println("Original time object: " + t3);
        t3.toggle24Hours();
        System.out.println("24Hour mode of time object: " + t3);
        System.out.println("Number of Time objects :" + t3.getNumTimeObjects() + "\n");
    }
}
