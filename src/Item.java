public interface Item {
    String getName();
    void use();
    void add(Item item);
    void remove(Item item);
    Item[] getItems();
}