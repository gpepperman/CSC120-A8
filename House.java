/* This is a stub for the House class */

import java.util.ArrayList;
/**
 * Constructs Houses that behave like buildings with additional attributes and methods that are specific for a house.
 */
public class House extends Building implements HouseRequirements{
  
  protected ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  protected boolean hasDiningRoom;
  protected boolean hasElevator;


  /**
   * Constructor that takes the attributes from building and intializes new attributes that are specifically for House
   * @param name name of house (String)
   * @param address adress of house (String)
   * @param nFloors number of floors in the house (int)
   * @param hasDiningRoom if the house has a dining room (boolean)
   * @param hasElevator if the house has an elevator of not (boolean)
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors); //call building comstructor
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<>(); // start with an empty list of residents
    System.out.println("You have built a house: 🏠");
  }

  /** Overloaded constructor with Dining room only 
   * @param name name of house (String)
   * @param address adress of house (String)
   * @param nFloors number of floors in the house (int)
   * @param hasDiningRoom if the house has a dining room (boolean)
   */
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
      super(name, address, nFloors); // call Building constructor
      this.hasDiningRoom = hasDiningRoom;
      this.residents = new ArrayList<>(); // start with empty residents list
      System.out.println("You have built a house: 🏠");
  }

    /** Overloaded constructor without adress 
     * @param name name of house (String)
     * @param nFloors number of floors in the house (int)
     * @param hasDiningRoom if the house has a dining room (boolean) 
     */
    public House(String name, boolean hasDiningRoom,int nFloors) {
      this.name= name; //from building
      this.nFloors= nFloors; // from building
      this.hasDiningRoom = hasDiningRoom;
      this.residents = new ArrayList<>(); // start with empty residents list
      System.out.println("You have built a house: 🏠");
  }

  /**
   * Method that declares the attribute boolean hasDiningRoom true.
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }


/**
   * Method that declares the attribute boolean hasElevator true.
   */
  public boolean hasElevator(){
    return this.hasElevator;
  }
  
  /**
   * Method that counts how many residents live in the house.
   */
  public int nResidents(){
    return residents.size();//counts how many objects are in the array
  }

  /**
   * Method that adds a student to the list of residents of the House
   */
  public void moveIn(Student s){
    if(isResident(s)){ //checks if student is already a resident
        System.out.println(s + " is already a resident of this house"); 
    } else{
    residents.add(s);
    System.out.println(s + " has moved into this house");
    }
  }

  /**
   * Methods that removes a student from the list of residents of the House.
   */
  public Student moveOut(Student s){
    if(!isResident(s)){ //checks if student is even a resident
        System.out.println(s + " is not a resident of this house"); 
        return s;
    } else{
    residents.remove(s);
    System.out.println(s + " has moved out of this house");
    return s;
  }
  } 
  
  /**
   * Method that checks if student is a resident of the House
   */
  public boolean isResident(Student s){
    if(residents.contains(s)){
      //System.out.println("Student " + s + " IS in residence");
      return true;
    } else{
      //System.out.println("Student " + s + " IS NOT in residence");
      return false;
    }
  }

  /**
   * Method that allows travel between adjacent floors and travel between any floors if building has elevator
   * @param floorNum number of floor that is being traveled to.
   */

  @Override
  public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {//checks if user is inside of the house
            throw new RuntimeException("You are not inside this House. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) { //checks if the building has that many floors
            throw new RuntimeException("Invalid floor number. Valid range for this House is 1-" + this.nFloors +".");
        }
        if (!this.hasElevator && Math.abs(floorNum - this.activeFloor) > 1) { //if you are traveling a nonadjacent floor and the building does not have an elevator
        throw new RuntimeException("This house does not have an elevator! You can only move to adjacent floors.");
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

    System.out.println(" + hasDiningRoom()");
    System.out.println(" + nResidents()");
    System.out.println(" + moveIn(Student s)");
    System.out.println(" + moveOut(Student s)");
    System.out.println(" + isResident(Student s)");
}

  /**
   * Main section for testing code
   * @param args
   */
  public static void main(String[] args) {
    House Emerson = new House("Emerson House", "1 Paradise Road", 4, false, false);
        System.out.println(Emerson);
        Emerson.showOptions();
  }

}