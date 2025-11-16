package mortalkombat.observer;

import mortalkombat.hero.Hero;
import mortalkombat.hero.Enemy;

public class ConsoleBattleObserver implements BattleObserver {

    @Override
    public void update(Hero hero, Enemy enemy) {
        System.out.println(hero.getName() + " HP: " + hero.getHealth());
        System.out.println(enemy.getName() + " HP: " + enemy.getHealth());
        System.out.println("---");
    }

    @Override
    public void onAction(Hero actor, String actionName) {
        System.out.println(actor.getName() + " выполняет действие: " + actionName);
    }
}