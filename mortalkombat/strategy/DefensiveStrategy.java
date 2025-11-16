package mortalkombat.strategy;

import mortalkombat.hero.Enemy;
import mortalkombat.action.AttackAction;
import mortalkombat.action.DefendAction;

public class DefensiveStrategy implements Strategy {
    private static final double LOW_HEALTH_THRESHOLD = 0.3;

    @Override
    public void change(Enemy enemy) {
        if ((double) enemy.getHealth() / enemy.getHealthMax() < LOW_HEALTH_THRESHOLD) {
            enemy.setAction(new DefendAction());
        } else {
            enemy.setAction(new AttackAction());
        }
    }
}
