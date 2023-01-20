import java.util.Scanner;

class ForestAdventure implements Adventure {
    private final String name;
    private final Map map;
    private final NPC[] npcs;

    public ForestAdventure(String name) {
        this.name = name;
        this.map = new ForestMap();
        this.npcs = new NPC[] {
                new QuestGiver("Eldrin the Elf", "Greetings, adventurer. I have a task that I believe you are well suited for.", "Retrieve the lost artifact from the cave.")
        };
    }

    public void start() {
        System.out.println("Welcome to the " + name + " Adventure!");
        map.display();
        System.out.println("You are standing at the entrance of the forest.");
        System.out.println("What would you like to do? (explore, rest, interact, quit)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("quit")) {
            if (input.equals("explore")) {
                map.explore();
            } else if (input.equals("rest")) {
                System.out.println("You rest for a while.");
            } else if (input.equals("interact")) {
                ((QuestGiver) npcs[0]).giveQuest();
            } else {
                System.out.println("Invalid command. Please try again.");
            }
            System.out.println("What would you like to do? (explore, rest, interact, quit)");
            input = scanner.nextLine();
        }
        System.out.println("Thanks for playing!");
    }
}

