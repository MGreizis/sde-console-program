public class DehydratedHydrationLevel implements PlayerState {
    @Override
    public void drinkWater(Player player) {
        player.setHydrationLevel(new NormalHydrationLevel());
    }
}