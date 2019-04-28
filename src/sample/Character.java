package sample;

public enum Character {
    Boy("Boy",15,15,15),
    Robot("Robot",10,8,10);

    String name;
    int Idle,walk,dead;



    Character(String name,int Idle,int walk,int dead) {
        this.name = name;
        this.Idle=Idle;
        this.walk=walk;
        this.dead=dead;
    }

    public String getName() {
        return name;
    }

}
