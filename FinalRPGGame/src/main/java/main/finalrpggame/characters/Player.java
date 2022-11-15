package main.finalrpggame.characters;

public class Player extends Character{

    public Player(int hp, int attackPower, int chargePower, int blockPower, String name) {
        super(hp, attackPower, chargePower, blockPower, name);
    }

    @Override
    public String castAbility() {
        return "";
    }
}
