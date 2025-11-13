/* This is a stub for the Cafe class */

/**
 * Constructs Cafes that behave like buildings with additional attributes and methods that are specific for a cafe.
 */
public class Cafe extends Building implements CafeRequirements{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    protected boolean hasElevator;     

    /**
     * Constructor that takes the attributes from building and intializes new attributes that are specifically for cafe
     * @param name name of cafe (String)
     * @param address address of cafe (String)
     * @param nFloors floors of the cafe building (int)
     * @param nCoffeeOunces number of ounces of coffee the cafe has (int)
     * @param nSugarPackets number of sugar pacets the cafe has (int)
     * @param nCreams number of creams the cafe has (int)
     * @param nCups number of cups the cafe has (int)
     * @param hasElevator if the cafe has an elevator of not (boolean)
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator){
        super(name, address, nFloors);
        this.nCoffeeOunces=nCoffeeOunces;
        this.nSugarPackets=nSugarPackets;
        this.nCreams=nCreams;
        this.nCups=nCups;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }

    /* Overloaded constructor with no inventor information */
    public Cafe(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors); // call Building constructor
      this.hasElevator = hasElevator;
      System.out.println("You have built a cafe: ☕");
      
  }

    /* Overloaded constructor with not floor numbers */
    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator){
        this.name =name;
        this.address=address;
        this.nCoffeeOunces=nCoffeeOunces;
        this.nSugarPackets=nSugarPackets;
        this.nCreams=nCreams;
        this.nCups=nCups;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }

    /** Method that adjusts the cafe inventory for each coffee sold
     * @param size how many ounces a cup of coffee is (int)
     * @param nSugarPackets how many sugar packets in the cup of coffee (int)
     * @param nCreams how many creams in the cup of coffee (int)
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if(this.nCoffeeOunces > size && this.nSugarPackets > nSugarPackets &&
        this.nCreams > nCreams &&
        this.nCups > 1){
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Here is your " + size + "oz coffee with " + nSugarPackets + " sugar packets and " + nCreams + " creams.");
        } else{
            System.out.println("Not enough resources for your " + size + "oz coffee with " + nSugarPackets + " sugar packets and " + nCreams + " creams.");
        }
    }

    /**
   * Method that allows travel between adjacent floors and travel between any floors if building has elevator
   * @param floorNum number of floor that is being traveled to.
   */
    @Override
    public void goToFloor(int floorNum) { //checks if user is inside of the house
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this cafe. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {  //checks if the building has that many floors
            throw new RuntimeException("Invalid floor number. Valid range for this cafe is 1-" + this.nFloors +".");
        }
        if (!this.hasElevator && Math.abs(floorNum - this.activeFloor) > 1) {//if you are traveling a nonadjacent floor and the building does not have an elevator
        throw new RuntimeException("This cafe does not have an elevator! You can only move to adjacent floors.");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * Method prints all the different action options
     */
    @Override
    public void showOptions() {
        super.showOptions(); 
        
        System.out.println(" + sellCoffee(int size, int nSugarPackets, int nCreams)");
    }

    /**
     * Method creates a string to be printed for a cafe
     * @return String to be printed
     */
    public String toString(){
        return this.name + " has " + this.nCoffeeOunces + " coffee ounces, " + this.nSugarPackets + " sugar packets, " + this.nCreams + " creams, and " + this.nCups + " cups.";
    }


    /**
     * Method that return a book to the collection
     * @param title title to be added to the collection (String)
     */
    public static void main(String[] args) {
        Cafe Compass = new Cafe("Compass", "Neilson Library", 3, 500, 200, 100, 100, true);
        Compass.sellCoffee(12, 2, 1);
        Compass.enter();
        Compass.goToFloor(2);
        System.out.println(Compass);
    }
    
}
