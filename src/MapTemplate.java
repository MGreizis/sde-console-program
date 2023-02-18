public abstract class MapTemplate implements Map {
    public void display() {
        System.out.println("You are in a" + getLocationName() + ".");
        displayLocationDescription();
    }

    public void explore() {
        System.out.println("You start to explore the " + getLocationName() + ".");
        exploreLocation();
    }

    // Abstract methods to be implemented by concrete subclasses
    protected abstract String getLocationName();
    protected abstract void displayLocationDescription();
    protected abstract void exploreLocation();
}
