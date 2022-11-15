package main.finalrpggame.characters;

public class Goblin extends Character{

    public Goblin(int hp, int attackPower, int chargePower, int blockPower, String name) {
        super(hp, attackPower, chargePower, blockPower, name);
    }

    // goblins will move faster
    @Override
    public String castAbility() {
        this.setVelocity(this.getVelocity() + 0.5);
        return this.getName() + " casted an ability to make itself move faster\n";
    }
}
