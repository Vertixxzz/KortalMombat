package mortalkombat.hero;

import mortalkombat.hero.Hero;

public class Barbarian extends Hero {
    private static final int BASE_HEALTH = 80;
    private static final int BASE_ATTACK = 25;
    private static final int BASE_DEFENSE = 8;

    public Barbarian(String name) {
        super(name, BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE);
    }
}


