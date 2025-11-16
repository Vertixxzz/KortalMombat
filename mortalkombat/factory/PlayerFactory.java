package mortalkombat.factory;

import mortalkombat.hero.Hero;
import mortalkombat.hero.HeroBuilder;

public class PlayerFactory {

    public Hero createCustom(String name, int health, int attack, int defense) {
        return new HeroBuilder()
                .setName(name)
                .setHealth(health)
                .setAttack(attack)
                .setDefense(defense)
                .build();
    }
}

