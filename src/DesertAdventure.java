public class DesertAdventure implements Adventure {
    private String name;
    private Map map;

    public DesertAdventure(Builder builder) {
        this.name = builder.name;
        this.map = builder.mapFactory.createMap();
    }

    public void start() {
        System.out.println("You are in a desert.");
        System.out.println("You find a cactus.");
    }

    public static class Builder {
        private String name;
        private MapFactory mapFactory = new DesertMapFactory();

        public Builder(String name) {
            this.name = name;
        }
    }
}
