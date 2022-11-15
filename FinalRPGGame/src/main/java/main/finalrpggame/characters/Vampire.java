package main.finalrpggame.characters;

public class Vampire extends Character{
    public Vampire(int hp, int attackPower, int chargePower, int blockPower, String name) {
        super(hp, attackPower, chargePower, blockPower, name);
    }

    @Override
    public String castAbility() {
        int newHp = this.getHp() + 20;
        this.setHp(Math.min(newHp, 100));
        return this.getName() + " restored some health\n";
    }
}
