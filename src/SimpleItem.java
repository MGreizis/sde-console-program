class SimpleItem implements Item {
    private String name;
    public SimpleItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void use() {
        System.out.println("Using " + name);
    }

    public void add(Item item) {
        throw new UnsupportedOperationException();
    }

    public void remove(Item item) {
        throw new UnsupportedOperationException();
    }

    public Item[] getItems() {
        throw new UnsupportedOperationException();
    }
}