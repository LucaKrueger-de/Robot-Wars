package com.btcag.bootcamp.APIconnectedGame.Models;

public class Bot {
    private String name;
    private int health;
    private int attackDamage;
    private int movementRate;
    private int attackRange;

    public Bot(String name) {
        this.attackRange = 1;
        this.name = name;
        this.health = 1;
        this.attackDamage = 1;
        this.movementRate = 1;
    }


    public int getAttackRange(){
        return attackRange;
    }

    public void setAttackRange(int attackRange){
        this.attackRange = attackRange;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int damage) {
        this.attackDamage = attackDamage;
    }

    public int getMovementRate() {
        return movementRate;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }


}
