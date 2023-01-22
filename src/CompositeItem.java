import java.util.ArrayList;
import java.util.List;

class CompositeItem implements Item {
    private List<Item> items = new ArrayList<>();
    private String name;
    public CompositeItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void use() {
        for (Item item : items) {
            item.use();
        }
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public Item[] getItems() {
        return items.toArray(new Item[0]);
    }
}