package mortalkombat.hero;

import mortalkombat.hero.Hero;

public class Warrior extends Hero {

    private static final int BASE_HEALTH = 100;
    private static final int BASE_ATTACK = 15;
    private static final int BASE_DEFENSE = 10;

    public Warrior(String name) {
        super(name, BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE);
    }
}


