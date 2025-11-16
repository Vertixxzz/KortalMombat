package mortalkombat.strategy;

import mortalkombat.hero.Enemy;
import mortalkombat.action.AttackAction;

public class AlwaysAttackStrategy implements Strategy {
    @Override
    public void change(Enemy enemy) {
        enemy.setAction(new AttackAction());
    }
}
