package mortalkombat.hero;

import mortalkombat.strategy.Strategy;

public class Enemy extends Hero {

    private Strategy strategy;

    public Enemy(String name, int health, int attack, int defense, Strategy strategy) {
        super(name, health, attack, defense);
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

