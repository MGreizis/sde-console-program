class Inventory {
    private Item[] items;
    public Inventory() {
        items = new Item[] {
                new SimpleItem("Sword"),
                new SimpleItem("Potion"),
                new CompositeItem("Bag")
        };
        items[2].add(new SimpleItem("Gold"));
        items[2].add(new SimpleItem("Gem"));
    }

    public void display() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println(" - " + item.getName());
        }
    }

    public void useItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                item.use();
                return;
            }
        }
        System.out.println("Item not found in inventory.");
    }
}