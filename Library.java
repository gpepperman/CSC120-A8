/* This is a stub for the Library class */

import java.util.Hashtable;
/**
 * Constructs Librarys that behave like buildings with additional attributes and methods that are specific for a library.
 */
    public class Library extends Building implements LibraryRequirements{
  private Hashtable<String, Boolean> collection;
  protected boolean hasElevator;

    /**
     * Constructor that takes the attributes from building and intializes new attributes that are specifically for Library
     * @param name name of library (String)
     * @param address adress of library (String)
     * @param nFloors number of floors in the library (int)
     * @param hasElevator if the library has an elevator of not (boolean)
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.hasElevator = hasElevator;
      this.collection = new Hashtable();
      System.out.println("You have built a library: 📖");
    }

    /** Overloaded constructor with no information besides building atributes 
     * @param name name of library (String)
     * @param address adress of library (String)
     * @param nFloors number of floors in the library (int)
    */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors); // call Building constructor
      this.collection = new Hashtable();
      System.out.println("You have built a library: 📖");
  }

    /** Overloaded constructor without adress 
     * @param name name of library (String)
     * @param nFloors number of floors in the library (int)
     * @param hasElevator if the library has an elevator of not (boolean)
    */
    public Library(String name, int nFloors, boolean hasElevator) {
      this.name= name;
      this.nFloors = nFloors;
      this.hasElevator = hasElevator;
      this.collection = new Hashtable();
      System.out.println("You have built a library: 📖");
    }

    /**
     * Method that adds title to the library's collection
     * @param title title to be added to the collection (String)
     */
    public void addTitle(String title){
    if (containsTitle(title)) { //checks if the collection already has this title
      System.out.println(title + " is already in the collection.");
    } else {
      collection.put(title, true); // true = available for checkout
      System.out.println(title + " added to the collection.");
      }
    }
    
    /**
     * Method that removes title from the library's collection
     * @param title title to be added to the collection (String)
     * @return title as a String
     */
    public String removeTitle(String title){
    if (!containsTitle(title)) {//checks to see if the title was even in the collection
      System.out.println(title + " not found in the collection.");
    } else {
      collection.remove(title);
      System.out.println(title + " removed from the collection.");
    }
    return title;
    }

    /**
     * Method that check a title out of the collection
     * @param title title to be added to the collection (String)
     */
    public void checkOut(String title){
    if (containsTitle(title)) { //checks that the collection has the title
      if (isAvailable(title)) { //checks if the title has already been checked out
        collection.put(title, false);
        System.out.println(title + " has been checked out.");
      } else {
        System.out.println(title + " is already checked out.");
      }
    } else {
      System.out.println(title + " is not in the collection.");
    }
    }

    /**
     * Method that return a book to the collection
     * @param title title to be added to the collection (String)
     */
    public void returnBook(String title){
    if (containsTitle(title)) {//checks if the title is in the collection
      if (!isAvailable(title)) {//checks if the book is checked out
        collection.put(title, true);
        System.out.println(title + " has been returned.");
      } else {
        System.out.println(title + " was not checked out.");
      }
    } else {
      System.out.println(title + " is not in the collection.");
    }
    }

    /**
     * Method that checks if the collection contains a title
     * @param title title to be added to the collection (String)
     * @return boolean: true if the collection contains the title
     */
    public boolean containsTitle(String title){
    return collection.containsKey(title);
    }

    /**
     * Method that checks if the title is available for checkout in the collection
     * @param title title to be added to the collection (String)
     * @return boolean: true if the title is title is in the collection and available for checkout
     */
    public boolean isAvailable(String title){
    if (!collection.containsKey(title)) {//checks if the title is in the collection
        System.out.println(title + " is not in the collection.");
        return false;
    }
    boolean available = collection.get(title);//checks if it is (title, true) i.e. available for checkout
    if (available) {
        System.out.println(title + " is available.");
        return true;
    } else {
        System.out.println(title + " is currently checked out.");
        return false;
    }
    }

    /**
     * Method that prints all the titles in the collection
     */
    public void printCollection(){
    if (collection.isEmpty()) {//checks if there are any titles in the collection
      System.out.println("The library collection is empty.");
    } else {
      System.out.println("\nLibrary Collection:");
      for (String title : collection.keySet()) {
        String status = collection.get(title) ? "Available" : "Checked out";
        System.out.println("• " + title + " — " + status);
      }
    }
    }

    /**
   * Method that allows travel between adjacent floors and travel between any floors if building has elevator
   * @param floorNum number of floor that is being traveled to.
   */
    @Override
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) { //checks if user is inside of the house
            throw new RuntimeException("You are not inside this Library. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) { //checks if the building has that many floors
            throw new RuntimeException("Invalid floor number. Valid range for this library is 1-" + this.nFloors +".");
        }
        if (!this.hasElevator && Math.abs(floorNum - this.activeFloor) > 1) { //if you are traveling a nonadjacent floor and the building does not have an elevator
        throw new RuntimeException("This library does not have an elevator! You can only move to adjacent floors.");
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

        System.out.println(" + addTitle(String title)");
        System.out.println(" + removeTitle(String title)");
        System.out.println(" + checkOut(String title)");
        System.out.println(" + returnBook(String title)");
        System.out.println(" + containsTitle(String title)");
        System.out.println(" + isAvailable(String title)");
        System.out.println(" + printCollection()");
    }
  
    /**
     * Main section for testing code
     * @param args
     */
    public static void main(String[] args) {
      Library Josten = new Library("Josten", "Mendall Hall", 3, true);
      Josten.enter();
      Josten.goToFloor(2); // works
      Josten.goToFloor(4);
    }
  
  }