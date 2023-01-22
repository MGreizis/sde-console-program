import java.util.ArrayList;
import java.util.List;

class Inventory {
    private List<Item> items;
    private int gold;
    public Inventory() {
        this.gold = 75;
        this.items = new ArrayList<>();
    }

    public void display() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println(" - " + item.getName());
        }
    }

    public void useItem(String name) {
        for (Item item : items) {
            if (item.getName().toLowerCase().equals(name.toLowerCase())) {
                item.use();
                return;
            }
        }
        System.out.println("Item not found in inventory.");
    }

    public void updateGold(int amount) {
        this.gold += amount;
    }
    public int getGold() {
        return gold;
    }
    public void addToInventory(Item item) {
        items.add(item);
    }

    public void getPrice(String name) {
        for (Item item : items) {
            if (item.getName().toLowerCase().equals(name.toLowerCase())) {
                System.out.println("Price: " + item.getPrice());
                return;
            }
        }
        System.out.println("Item not found in inventory.");
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}