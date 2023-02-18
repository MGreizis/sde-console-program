public class DesertMap extends MapTemplate {
    protected String getLocationName() {
        return "desert";
    }

    protected void displayLocationDescription() {
        System.out.println("The sun is beating down on the sandy dunes.\n");
    }

    protected void exploreLocation() {
        System.out.println("You find a cactus.");
    }
}
