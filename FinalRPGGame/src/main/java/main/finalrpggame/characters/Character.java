package main.finalrpggame.characters;

import main.finalrpggame.Action;

import java.util.Random;

public abstract class Character {
    private int hp;

    private int attackPower;
    private int chargePower;
    private int blockPower;
    private double velocity;
    private String name;


    public Character(int hp, int attackPower, int chargePower, int blockPower, String name) {
        this.hp = hp;
        this.attackPower = attackPower;
        this.chargePower = chargePower;
        this.blockPower = blockPower;
        this.velocity = 1.0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getChargePower() {
        return chargePower;
    }

    public void setChargePower(int chargePower) {
        this.chargePower = chargePower;
    }

    public int getBlockPower() {
        return blockPower;
    }

    public void setBlockPower(int blockPower) {
        this.blockPower = blockPower;
    }

    public int calcDamage(Action action) {
        switch(action) {
            case ATTACK:
                return attackPower + (crit(35) ? (15) : 0);
            case CHARGE:
                return chargePower;
            case BLOCK:
                return blockPower;
            default:
                return -1;
        }
    }

    private boolean crit(int chance) {
        return chance > (new Random()).nextInt(100);
    }

    public abstract String castAbility();
    public String toString() {
        return "HP: " + hp;
    }
}
