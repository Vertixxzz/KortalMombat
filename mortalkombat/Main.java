package mortalkombat;

import mortalkombat.hero.Hero;
import mortalkombat.hero.Enemy;
import mortalkombat.factory.CharacterFactory;
import mortalkombat.factory.EnemyFactory;
import mortalkombat.observer.BattleObserver;
import mortalkombat.observer.ConsoleBattleObserver;
import mortalkombat.strategy.AlwaysAttackStrategy;
import mortalkombat.facade.GameFacade;

public class Main {
    public static void main(String[] args) {

        CharacterFactory characterFactory = new CharacterFactory();
        EnemyFactory enemyFactory = new EnemyFactory();
        BattleObserver observer = new ConsoleBattleObserver();

        Hero hero = characterFactory.create("warrior", "Insomnia");
        Enemy enemy = enemyFactory.create("Goblin", 80, 20, 5, new AlwaysAttackStrategy());

        GameFacade game = new GameFacade(hero, enemy, observer, enemyFactory);
        game.startBattle();
    }
}
