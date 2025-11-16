package mortalkombat.strategy;

import mortalkombat.hero.Enemy;
import mortalkombat.action.AttackAction;
import mortalkombat.action.DefendAction;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private static final Random random = new Random();

    @Override
    public void change(Enemy enemy) {
        if (random.nextBoolean()) {
            enemy.setAction(new AttackAction());
        } else {
            enemy.setAction(new DefendAction());
        }
    }
}
