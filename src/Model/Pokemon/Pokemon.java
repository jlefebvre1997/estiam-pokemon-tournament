package Model.Pokemon;

import java.util.Random;

public abstract class Pokemon {
    String name;
    int healthPoints;
    int attackPoints;
    int level;
    int maxHealthPoints;

    public Pokemon(String name, int level) {
        Random rand = new Random();
        this.name = name;
        this.level = level;
        this.healthPoints = (level * 5) + (rand.nextInt(level));
        this.maxHealthPoints = this.healthPoints;
        this.attackPoints = (level * 2) + (rand.nextInt(level));
    }

    public abstract int attack();

    public void refillLife() {
        this.healthPoints = this.maxHealthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void losesHealthPoints(int hp) {
        this.healthPoints -= hp;
        System.out.println(this.name + " loses " + hp + " health points ! Remaining health : " + this.healthPoints);
    }

    @Override
    public String toString() {
        return "I'm " + this.name + " I'm level " + this.level + ". I have " + this.healthPoints + " hp and " + this.attackPoints + " attack points.";
    }

    public boolean faints() {
        if (this.healthPoints <= 0) {
            System.out.println(this.name + " fainted !\n");
            return true;
        }

        return false;
    }
}
