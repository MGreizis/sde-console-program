public class Main {
    public static void main(String[] args) {
        Adventure adventure = new ForestAdventure(new ForestAdventure.Builder("Forest"));
        adventure.start();
    }
}
