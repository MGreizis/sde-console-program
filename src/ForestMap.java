import java.util.Scanner;

class ForestMap implements Map {
    // Storing the locations in an array, so that adding new locations is easy
    private final String[] locations = {"lake", "cave"};
    public void display() {
        System.out.println("Locations in the forest: ");
        for (String location : locations) {
            System.out.println("- " + location);
        }
    }

    public void explore() {
        System.out.println("You start to explore the forest.");
        System.out.println("You come across a fork in the road. Which way would you like to go? (left, right)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("left")) {
            System.out.println("You follow the left path and come across a beautiful lake.");
        } else if (input.equals("right")) {
            System.out.println("You follow the right path and come across a dark and mysterious cave.");
        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }
}

