import java.util.Scanner;

class ForestAdventure implements Adventure {
    private final String name;
    public ForestAdventure(String name) {
        this.name = name;
    }
    public void start() {
        System.out.println("Welcome to the " + name + " Adventure!");
        System.out.println("You are standing at the entrance of the forest.");
        System.out.println("What would you like to do? (explore, rest, quit)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("quit")) {
            if (input.equals("explore")) {
                System.out.println("You start exploring");
            } else if (input.equals("rest")) {
                System.out.println("You rest for a while.");
            } else {
                System.out.println("Invalid command. Please try again.");
            }
            System.out.println("What would you like to do? (explore, rest, quit)");
            input = scanner.nextLine();
        }
        System.out.println("Thanks for playing!");
    }
}
