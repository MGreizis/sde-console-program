abstract class NPC {
    protected String name;
    protected String dialogue;

    public NPC(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }

    public void interact() {
        System.out.println("You approach " + name + ".");
        System.out.println(name + ": " + dialogue);
    }
}
