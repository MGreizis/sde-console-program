class SimpleItem implements Item {
    private String name;
    private Integer price;
    public SimpleItem(String name, Integer price) {
        this.name = name;
        this.price = price;
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

    public Integer getPrice() {
        return price;
    }
}