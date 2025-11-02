package linkedListChallenge;

import java.util.*;

public class ItineraryNavigator {
    private LinkedList<Place> itinerary;
    private ListIterator<Place> iterator;
    private boolean goingForward = true;
    
    public ItineraryNavigator() {
        itinerary = new LinkedList<>();
        itinerary.add(new Place("Sydney", 0));
    }
    
    public void addPlace(String name, int distance) {
        Place newPlace = new Place(name, distance);
        
        if (itinerary.contains(newPlace)) {
            System.out.println("Place '" + name + "' already exists in the itinerary.");
            return;
        }
        
        int index = 0;
        for (Place place : itinerary) {
            if (distance < place.getDistance()) {
                break;
            }
            index++;
        }
        itinerary.add(index, newPlace);
        
        iterator = itinerary.listIterator();
    }
    
    public void goForward() {
        if (iterator == null) {
            iterator = itinerary.listIterator();
        }
        
        if (!goingForward && iterator.hasNext()) {
            iterator.next();
            goingForward = true;
        }
        
        if (iterator.hasNext()) {
            Place place = iterator.next();
            System.out.println("Moving forward to: " + place);
            goingForward = true;
        } else {
            System.out.println("Already at the end of the itinerary.");
        }
    }
    
    public void goBackward() {
        if (iterator == null) {
            iterator = itinerary.listIterator();
        }
        
        if (goingForward && iterator.hasPrevious()) {
            iterator.previous();
            goingForward = false;
        }
        
        if (iterator.hasPrevious()) {
            Place place = iterator.previous();
            System.out.println("Moving backward to: " + place);
            goingForward = false;
        } else {
            System.out.println("Already at the beginning of the itinerary.");
        }
    }
    
    public void listPlaces() {
        System.out.println("\n=== Itinerary (Ordered by Distance) ===");
        for (Place place : itinerary) {
            System.out.println("  " + place);
        }
        System.out.println("========================================\n");
    }
    
    private void displayMenu() {
        System.out.println("\nAvailable actions (select word or letter):");
        System.out.println("(F)orward");
        System.out.println("(B)ackward");
        System.out.println("(L)ist Places");
        System.out.println("(M)enu");
        System.out.println("(Q)uit");
        System.out.print("Enter choice: ");
    }
    
    public void run() {
        addPlace("Melbourne", 877);
        addPlace("Brisbane", 917);
        addPlace("Adelaide", 1374);
        addPlace("Alice Springs", 2771);
        addPlace("Darwin", 3972);
        addPlace("Perth", 3923);
        
        listPlaces();
        
        Scanner scanner = new Scanner(System.in);
        displayMenu();
        
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            
            if (input.isEmpty()) {
                continue;
            }
            
            char choice = input.charAt(0);
            
            switch (choice) {
                case 'F':
                    goForward();
                    break;
                case 'B':
                    goBackward();
                    break;
                case 'L':
                    listPlaces();
                    break;
                case 'M':
                    displayMenu();
                    break;
                case 'Q':
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        ItineraryNavigator navigator = new ItineraryNavigator();
        navigator.run();
    }
}
