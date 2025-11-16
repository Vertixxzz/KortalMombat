package mortalkombat.facade;

import mortalkombat.hero.Hero;
import mortalkombat.hero.Enemy;
import mortalkombat.observer.BattleObserver;

public class BattleFacade {

    private final Hero hero;
    private final Enemy enemy;
    private final BattleObserver observer;

    public BattleFacade(Hero hero, Enemy enemy, BattleObserver observer) {
        this.hero = hero;
        this.enemy = enemy;
        this.observer = observer;
    }

    public void playRound() {
        hero.performAction(enemy);
        observer.update(hero, enemy);

        if (!enemy.isAlive()) return;

        enemy.getStrategy().change(enemy);
        enemy.performAction(hero);
        observer.update(hero, enemy);
    }

    public boolean isBattleOver() {
        return !hero.isAlive() || !enemy.isAlive();
    }
}
