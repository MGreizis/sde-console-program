import java.util.ArrayList;
import java.util.List;

class Merchant extends NPC {
    private List<Item> items;
    public Merchant(String name, String greetings) {
        super(name, greetings);
        this.items = new ArrayList<>();
        items.add(new SimpleItem("health potion", 20));
        items.add(new SimpleItem("mana potion", 25));
        items.add(new SimpleItem("sword", 50));
    }
    public void showItems() {
        System.out.println("Items for sale:");
        for (Item item : items) {
            System.out.println(" - " + item.getName() + " (" + item.getPrice() + " gold)");
        }
    }
    public void buyItem(String itemName, Inventory inventory) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                if (inventory.getGold() >= item.getPrice()) {
                    inventory.updateGold(-item.getPrice());
                    inventory.addToInventory(item);
                    items.remove(item);
                    System.out.println("Item purchased successfully.");
                } else {
                    System.out.println("You do not have enough gold.");
                }
                return;
            }
        }
        System.out.println("Item not found.");
    }
}
