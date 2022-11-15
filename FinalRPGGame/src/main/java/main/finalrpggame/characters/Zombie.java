package main.finalrpggame.characters;

public class Zombie extends Character {
    public Zombie(int hp, int attackPower, int chargePower, int blockPower, String name) {
        super(hp, attackPower, chargePower, blockPower, name);
    }

    // zombie will lose some health and gain power
    @Override
    public String castAbility() {
        int curHp = this.getHp();

        if (curHp > 5) {
            this.setHp(curHp - 5);
            this.setAttackPower(this.getAttackPower() + 5);
            this.setChargePower(this.getChargePower() + 5);
            this.setBlockPower(this.getBlockPower() + 5);
            return this.getName() + " lost 5 hp but gained lots of power, be careful!\n";
        } else {
            return this.getName() + " is low on health, fails to cast ability\n";
        }
    }
}
