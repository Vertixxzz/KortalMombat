package mortalkombat.hero;

import mortalkombat.hero.Hero;

public class Tank extends Hero {
    private static final int BASE_HEALTH = 140;
    private static final int BASE_ATTACK = 8;
    private static final int BASE_DEFENSE = 20;

    public Tank(String name) {
        super(name, BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE);
    }
}
