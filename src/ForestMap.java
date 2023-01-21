import java.util.Scanner;

class ForestMap implements Map {
    // Storing the locations in an array, so that adding new locations is easy
    private final String[] locations = {"lake", "cave"};
    private boolean artifactRetrieved = false;

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
            if(!artifactRetrieved) {
                System.out.println("This must be the cave where the lost artifact is said to be.");
                System.out.println("Do you want to enter the cave and retrieve the artifact? (yes/no)");
                input = scanner.nextLine();
                if(input.equals("yes")) {
                    System.out.println("You enter the cave and after a short search, you find the lost artifact.");
                    System.out.println("You successfully retrieve the artifact.");
                    artifactRetrieved = true;
                } else {
                    System.out.println("You decide not to enter the cave and continue exploring the forest.");
                }
            } else {
                System.out.println("You have already retrieved the artifact from this cave.");
            }
        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }

    public boolean isArtifactRetrieved() {
        return artifactRetrieved;
    }
}


