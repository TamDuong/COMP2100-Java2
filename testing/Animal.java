public abstract class Animal
{
    //instance variable
    protected String species = "";
    protected int numLimbs = 4; 
    protected double lethality = 3.5;
    
    //setter method
    
    public void setSpecies (String s){
        species = s;
    }
    
    public void setnumLimbs (int n){
        numLimbs = n;
    }
    
    public void setLethality (double l){
        lethality = l;
    }
    
    
    //constructor
    public Animal (String s, int n, double l){
        setSpecies(s);
        setnumLimbs(n);
        setLethality(l);
    }
    
    
    //getter method
    
    public String getSpecies(){
        return species;
    }
    
    public int getnumLimbs(){ 
        return numLimbs;
    }
    
    public double getLethality(){
        return lethality;
    }
    
    
    //toString method
    public String toString(){
        return " the " +species + " (number of limbs: " +numLimbs + ", lethality: " + lethality + ")";        
    }
    
    
    //other methods
    public abstract void move();
    
    public void kill(){
        System.out.println(species+ " is working!");
    }
    
    public void eat(Animal food){
        System.out.println(species+ " is eatting " + food + "!");      //can also write food as food.toString()
        System.out.println(species+ " is eatting " + food.species);
        System.out.println(species+ " is eatting " + food.getSpecies() + "!");
    }
    
    public void mate(){
        System.out.println(species + " is having fun time!");
    }
    
}
