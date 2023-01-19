import java.util.Scanner;

class ForestMap implements Map {
    // Storing the locations in an array, so that adding new locations is easy
    private final String[] locations = {"lake"};
    public void display() {
        System.out.println("Locations in the forest: ");
        for (String location : locations) {
            System.out.println("- " + location);
        }
    }
    public void explore() {
        System.out.println("You start to explore the forest.");
        System.out.println("The path begins to become darker and darker. Are you sure you want to continue? (yes, no)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("yes")) {
            System.out.println("You keep walking the path and come across a beautiful lake.");
        } else if (input.equals("no")) {
            System.out.println("You decide to turn around and let the forest keep its secrets.");
        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }
}
