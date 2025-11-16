package mortalkombat.factory;
import java.util.Random;

import mortalkombat.hero.Enemy;
import mortalkombat.strategy.AlwaysAttackStrategy;
import mortalkombat.strategy.DefensiveStrategy;
import mortalkombat.strategy.RandomStrategy;
import mortalkombat.strategy.Strategy;

public class EnemyFactory {

    public Enemy create(String name, int health, int attack, int defense, Strategy strategy) {
        return new Enemy(name, health, attack, defense, strategy);
    }

    public Enemy createWaveEnemy(int wave) {

        Random random = new Random();

        String name = "Goblin " + wave;

        int health = 60 + random.nextInt(10 + wave * 5);
        int attack = 6 + random.nextInt(2 + wave * 2);
        int defense = 3 + random.nextInt(1 + wave);

        Strategy strategy =
                (wave % 3 == 0) ? new DefensiveStrategy() :
                        (wave % 2 == 0) ? new RandomStrategy() :
                                new AlwaysAttackStrategy();

        return new Enemy(name, health, attack, defense, strategy);
    }

}
