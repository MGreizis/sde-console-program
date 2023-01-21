class QuestGiver extends NPC {
    private String quest;
    private boolean questCompleted = false;
    private Map map;

    public QuestGiver(String name, String dialogue, String quest) {
        super(name, dialogue);
        this.quest = quest;
        this.map = map;
    }

    public void giveQuest() {
        if(!questCompleted) {
            System.out.println(name + " gives you a quest: " + quest);
        } else {
            System.out.println(name + ": You have completed the quest of retrieving the lost artifact from the cave. Thank you for your help!");
        }
    }

    public void checkQuest() {
        if(map instanceof ForestMap){
            questCompleted = ((ForestMap) map).isArtifactRetrieved();
        }
    }
}
