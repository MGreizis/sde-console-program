class QuestGiver extends NPC {
    private String quest;

    public QuestGiver(String name, String dialogue, String quest) {
        super(name, dialogue);
        this.quest = quest;
    }

    public void giveQuest() {
        System.out.println(name + " gives you a quest: " + quest);
    }
}
