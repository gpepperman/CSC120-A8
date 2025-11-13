import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        System.out.println("\n🏫 Building the Smith College Campus Map...\n");

        System.out.println("\n=============================");
        System.out.println("Create Building for Map");
        System.out.println("=============================");
        
        House chapin= new House("Chapin", "Central Campus", 3, false);
        House tyler= new House("Tyler", "Green Street", 3, true);
        House emerson = new House("Emerson", "Quad", 4, false);
        House king = new House("King", "Quad", 4, true);
        House lamont = new House("Lamont", "Elm Street", 4, true);

        Library neilson = new Library("Neilson", "Central Campus", 6, true);
        Library joston = new Library("Josten", "Green Street", 2, false);
        Library hilyer = new Library("Hilyer", "Elm Street", 2, true);

        Cafe campusCenter = new Cafe("CC", "Elm Street", 1, 400, 500, 100, true);
        Cafe compass = new Cafe("Compass", "Central Campus", 3, 500, 200, 100, 100, true);

        // Finally, print the directory
        System.out.println("\n=============================");
        System.out.println(myMap);
        System.out.println("=============================");

        myMap.addBuilding(chapin);
        myMap.addBuilding(tyler);
        myMap.addBuilding(emerson);
        myMap.addBuilding(king);
        myMap.addBuilding(lamont);

        myMap.addBuilding(neilson);
        myMap.addBuilding(joston);
        myMap.addBuilding(hilyer);

        myMap.addBuilding(campusCenter);
        myMap.addBuilding(compass);

        System.out.println("\n=============================");
        System.out.println("Test out Methods");
        System.out.println("=============================");

        System.out.println("========House================");

        Student grace = new Student("Grace", "2004", 2026);
        Student maggie = new Student("Maggie", "2003", 2026);

        chapin.moveIn(grace);
        chapin.moveIn(maggie);
        chapin.showOptions();
        chapin.enter();
        chapin.goToFloor(2);
        chapin.moveOut(maggie);

        System.out.println("========Library================");

        neilson.showOptions();
        neilson.enter();
        neilson.goToFloor(2);
        neilson.addTitle("Alice in Wonderland");
        neilson.addTitle("Alice in Wonderland");
        neilson.removeTitle("The Giving Tree");
        neilson.returnBook("Alice in Wonderland");
        neilson.checkOut("Alice in Wonderland");
        neilson.checkOut("The Giving Tree");
        neilson.returnBook("The Giving Tree");
        neilson.returnBook("Alice in Wonderland");
        neilson.isAvailable("Alice in Wonderland");
        neilson.printCollection();

        System.out.println("========Cafe================");

        compass.showOptions();
        compass.enter();
        compass.goToFloor(2);
        compass.sellCoffee(8, 2, 1);    
        compass.sellCoffee(800, 2, 1);   
        
    }
    
}
