import java.util.Scanner;

class ForestAdventure implements Adventure {
    private final String name;
    private final Map map;
    private final NPC[] npcs;
    private final Inventory inventory;

    public ForestAdventure(Builder builder) {
        this.name = builder.name;
        this.map = builder.mapFactory.createMap();
        this.npcs = builder.npcs;
        this.inventory = builder.inventory;
    }

    public static class Builder {
        private final String name;
        private MapFactory mapFactory = new ForestMapFactory();
        private final Inventory inventory = new Inventory();
        private final NPC[] npcs = new NPC[] {
                new Merchant("Grendor the Goblin", "Welcome traveler! I've got some fine weapons and potions for sale."),
                new QuestGiver("Eldrin the Elf", "Greetings, adventurer. I have a task that I believe you are well suited for.", "Retrieve the lost artifact from the cave.")
        };

        public Builder(String name) {
            this.name = name;
        }

        public Builder setMapType(String mapType) {
            this.mapFactory = new ForestMapFactory();
            return this;
        }
    }

    public void start() {
        System.out.println("Welcome to the " + name + " Adventure!");
        map.display();
        System.out.println("You are standing at the entrance of the forest.");
        System.out.println("What would you like to do? (explore, rest, interact, inventory, quit)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("quit")) {
            if (input.equals("explore")) {
                map.explore();
            } else if (input.equals("rest")) {
                System.out.println("You rest for a while.");
            } else if (input.equals("interact")) {
                System.out.println("Which NPC would you like to interact with? (1, 2)");
                String npcNumStr = scanner.nextLine();
                int npcNum;
                try {
                    npcNum = Integer.parseInt(npcNumStr);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
                if (npcNum < 1 || npcNum > npcs.length) {
                    System.out.println("Invalid input. Please enter a number between 1 and " + npcs.length);
                    continue;
                }
                npcs[npcNum - 1].interact();
                if (npcs[npcNum - 1] instanceof Merchant) {
                    ((Merchant) npcs[npcNum - 1]).showItems();
                    System.out.println("Which item would you like to purchase? (name)");
                    System.out.println("You have " + inventory.getGold() + " gold.");
                    String itemName = scanner.nextLine();
                    ((Merchant) npcs[npcNum - 1]).buyItem(itemName, inventory);
                } else if (npcs[npcNum - 1] instanceof QuestGiver) {
                    ((QuestGiver) npcs[npcNum - 1]).giveQuest();
                }
            } else if (input.equals("inventory")) {
                if (inventory.isEmpty()) {
                    System.out.println("Your inventory is empty.");
                } else {
                    inventory.display();
                    System.out.println("Which item would you like to use? (enter the item name)");
                    String itemName = scanner.nextLine();
                    inventory.useItem(itemName);
                }
            } else {
                System.out.println("Invalid command. Please try again.");
            }
            System.out.println("What would you like to do? (explore, rest, interact, inventory, quit)");
            input = scanner.nextLine();
        }
        System.out.println("Thanks for playing!");
    }
}

