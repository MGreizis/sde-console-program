# Adventure Game

This is a text-based adventure game that allows players to explore a forest and complete a quest to retrieve a lost artifact from a cave. The game uses a combination of creational, structural, and behavioral design patterns to provide a simplified interface for the player to interact with the game.

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
        System.out.println("What would you like to do? (explore, rest, interact, quit)");
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

## Command (Behavioral)
The `Map` class defines the `explore` method that is used by the player to explore different locations in the game. The `ForestMap` class extends the `Map` class and implements the `explore` method, which defines the specific behavior for exploring the forest map.

```java
// Map.java

abstract class Map {
    void display();
    void explore();
}

// ForestMap.java

class ForestMap extends Map {
    public void display() {
        // display the map
    }
    public void explore() {
        // code for exploring the forest map
    }
}


```

## State (Behavioral)
The State pattern is used in the quest implementation, the `artifactRetrieved` variable is used to keep the state of the quest completion and the behavior of the game changes depending on the state of the quest.

```java
class ForestMap implements Map {
    private boolean artifactRetrieved = false;

    public void display() {
        //...
    }
    
    public void explore() {
        // ...
            if(!artifactRetrieved) {
                // ...
                if(input.equals("yes")) {
                    System.out.println("You enter the cave and after a short search, you find the lost artifact.");
                    System.out.println("You successfully retrieve the artifact.");
                    artifactRetrieved = true;
                // ...
            } else {
                System.out.println("You have already retrieved the artifact from this cave.");
            }
        }
    }
    
    // ...
}

```
If the player has already retrieved the artifact from the cave, the state will change and the player will no longer be able to access the cave while exploring the `ForestMap` map.

## Builder (Creational)
The `ForestAdventure` class has a constructor that takes a Builder object as a parameter, and the `Builder` class has a public constructor that takes a string as a parameter. The `Builder` class also has default values for the map and NPCs fields, but these can be overridden by calling methods on the `Builder` object before passing it to the `ForestAdventure` constructor. This allows for a more flexible and readable way of creating `ForestAdventure` objects with different configurations.

```java
class ForestAdventure implements Adventure {
    // ...

    public ForestAdventure(Builder builder) {
        // ...
    }
    
    public static class Builder {
        private final String name;
        private Map map = new ForestMap();
        private NPC[] npcs = new NPC[] {
                new Merchant("Grendor the Goblin", "Welcome traveler! I've got some fine weapons and potions for sale."),
                new QuestGiver("Eldrin the Elf", "Greetings, adventurer. I have a task that I believe you are well suited for.", "Retrieve the lost artifact from the cave.")
        };

        public Builder(String name) {
            this.name = name;
        }
    }
    
    // ...
}
```
