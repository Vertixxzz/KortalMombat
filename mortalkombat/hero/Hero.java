package mortalkombat.hero;
import java.util.Random;

import mortalkombat.action.Action;

public abstract class Hero {

    private String name;
    private int health;
    private int healthMax;
    private int attack;
    private int defense;
    private Action currentAction;

    public Hero(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.healthMax = health;
    }

    public void setAction(Action action) {
        this.currentAction = action;
    }

    public void performAction(Hero target) {
        if (currentAction != null) {
            currentAction.execute(this, target);
        }
    }

    public void takeDamage(int damage) {
        health = Math.max(health - damage, 0);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public Action getAction() {
        return currentAction;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, healthMax));
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    private final Random random = new Random();

    public void levelUp() {

        System.out.println("\n⬆ " + name + " повышает уровень!");

        int hpIncrease = 8 + random.nextInt(8);
        int atkIncrease = random.nextInt(4);
        int defIncrease = random.nextInt(3);

        healthMax += hpIncrease;
        attack += atkIncrease;
        defense += defIncrease;

        int healAmount = (int)(healthMax * 0.25);
        health = Math.min(health + healAmount, healthMax);

        System.out.println("Макс. HP +" + hpIncrease + " - " + healthMax);
        System.out.println("Атака   +" + atkIncrease + " - " + attack);
        System.out.println("Защита  +" + defIncrease + " - " + defense);
        System.out.println("Восстановлено HP: " + healAmount);
    }

}
