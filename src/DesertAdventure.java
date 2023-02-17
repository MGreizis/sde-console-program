public class DesertAdventure implements Adventure {
    private final String name;
    private final Map map;

    public DesertAdventure(Builder builder) {
        this.name = builder.name;
        this.map = builder.mapFactory.createMap();
    }

    public static class Builder {
        private final String name;
        private final MapFactory mapFactory = new DesertMapFactory();

        public Builder(String name) {
            this.name = name;
        }
    }

    public void start() {
        System.out.println("Welcome to the " + name + " Adventure!");
        map.display();
    }
}
