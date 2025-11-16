package mortalkombat.observer;

import mortalkombat.hero.Hero;
import mortalkombat.hero.Enemy;

public interface BattleObserver {
    void update(Hero hero, Enemy enemy);
    void onAction(Hero actor, String actionName);
}
