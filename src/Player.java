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
