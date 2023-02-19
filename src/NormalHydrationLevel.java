public class NormalHydrationLevel implements PlayerState {
    @Override
    public void drinkWater(Player player) {
        player.setHydrationLevel(new OverHydratedHydrationLevel());
    }
}