import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What adventure would you like to play? (forest, desert)");
        String mapType = scanner.nextLine();

        Adventure adventure;

        if (mapType.equalsIgnoreCase("forest")) {
            adventure = new ForestAdventure(new ForestAdventure.Builder("Forest"));
        } else if (mapType.equalsIgnoreCase("desert")) {
            adventure = new DesertAdventure(new DesertAdventure.Builder("Desert"));
        } else {
            System.out.println("Invalid input. Please enter 'forest' or 'desert'.");
            return;
        }
        adventure.start();
    }
}
