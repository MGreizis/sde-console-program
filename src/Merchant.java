class Merchant extends NPC {
    private String[] itemsForSale = {"sword", "armor", "healing potion"};

    public Merchant(String name, String dialogue) {
        super(name, dialogue);
    }

    public void showItems() {
        System.out.println(name + " shows you their wares:");
        for (String item : itemsForSale) {
            System.out.println("- " + item);
        }
    }
}
