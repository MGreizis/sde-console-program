# Adventure Game

This is a text-based adventure game that allows players to explore multiple maps and complete various quests. The game uses a combination of creational, structural, and behavioral design patterns to provide a simplified interface for the player to interact with the game.

# Design Patterns
## Facade (Structural)
The Facade pattern is used in the `ForestAdventure` class, which acts as a facade for the `Map` and `NPC` classes, and provides a simplified interface for the player to interact with the game.

```java
// Adventure.java

interface Adventure {
    void start();
}

// ForestAdventure.java

class ForestAdventure implements Adventure {
    //...

    public void start() {
        //...
        System.out.println("What would you like to do? (explore, rest, interact, inventory, quit)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("quit")) {
            if (input.equals("explore")) {
                map.explore();
            }
            
            //...
        }
    }
}

```

## Strategy (Behavioral)
The Strategy pattern is used in the `Map` interface and its implementation `ForestMap`, which allows for different types of maps to be used in the adventure game.

```java
// Map.java

interface Map {
    void display();
    void explore();
}

// ForestMap.java

class ForestMap implements Map {
    private final String[] locations = {"lake", "cave"};
    private boolean artifactRetrieved = false;

    public void display() {
        System.out.println("Locations in the forest: ");
        for (String location : locations) {
            System.out.println("- " + location);
        }
    }
    public void explore() {
        //...
    }
}
```
In this example, the `Map` interface defines a contract for the behavior of the map and the `ForestMap` class implements the behavior of the map. This allows for different types of maps to be used in the game, such as a desert map or a mountain map, and the game can handle them all in the same way.

## State (Behavioral)
The State pattern is implemented using the `PlayerState` interface and its implementations. The `Player` class has a hydration level, which is represented by a `PlayerState` object. When the player drinks water, the current hydration level is changed to a new state, and the player is updated with this new state. In the `DesertMap`, when the player explores, they find a cactus and can drink water, which updates their hydration level. This pattern allows for flexible hydration states and keeps the `Player` class separate from hydration level logic.

```java
public interface PlayerState {
    void drinkWater(Player player);
}

public class Player {
    private PlayerState hydrationLevel;

    public Player() {
        this.hydrationLevel = new NormalHydrationLevel();
    }

    public void setHydrationLevel(PlayerState hydrationLevel) {
        this.hydrationLevel = hydrationLevel;
    }

    public void drinkWater() {
        this.hydrationLevel.drinkWater(this);
        System.out.println("Player is now " + this.hydrationLevel);
    }
}

public class DesertMap extends MapTemplate {
    // ...
    
    protected void exploreLocation() {
        System.out.println("You find a cactus.");
        player.drinkWater();
    }
}
```

## Template Method (Behavioral)
The `MapTemplate` class is an abstract class that implements the `Map` interface, and provides a skeleton for the behavior of the `display` and `explore` methods. These two methods are now calling two abstract methods, `getLocationName()` and `displayLocationDescription()` for display, and `exploreLocation()` for explore.

```java
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

// Actual implementation:

public class DesertMap extends MapTemplate {
    private final Player player;

    public DesertMap(Player player) {
        this.player = player;
    }
    protected String getLocationName() {
        return "desert";
    }

    protected void displayLocationDescription() {
        System.out.println("The sun is beating down on the sandy dunes.\n");
    }

    protected void exploreLocation() {
        System.out.println("You find a cactus.");
        player.drinkWater();
    }
}
```

## Factory (Creational)
The Factory pattern is implemented using the `MapFactory` abstract class and its subclass, `DesertMapFactory`. The `MapFactory` has a `createMap()` method, which is implemented by the `DesertMapFactory` to create a "product", a `DesertMap` in this case. By creating different factory subclasses, we can create various types of maps, without modifying the existing client code.
```java
public abstract class MapFactory {
    public abstract Map createMap();
}

public class DesertMapFactory extends MapFactory {
    public Map createMap() {
        return new DesertMap(new Player());
    }
}

public class DesertAdventure implements Adventure {
    private final Map map;

    public DesertAdventure(Builder builder) {
        this.map = builder.mapFactory.createMap();
    }
    
    public static class Builder {
        private final MapFactory mapFactory = new DesertMapFactory();
    }
    
    // ...
}
```
