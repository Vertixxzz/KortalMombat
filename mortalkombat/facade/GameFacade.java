package mortalkombat.facade;

import mortalkombat.action.*;
import mortalkombat.decorator.VampireAttackDecorator;
import mortalkombat.decorator.CriticalAttackDecorator;
import mortalkombat.hero.Hero;
import mortalkombat.hero.Enemy;
import mortalkombat.factory.EnemyFactory;
import mortalkombat.observer.BattleObserver;

import java.util.Scanner;

public class GameFacade {

    private Hero hero;
    private Enemy enemy;
    private final BattleObserver observer;
    private final Scanner scanner;
    private final EnemyFactory enemyFactory;

    public GameFacade(Hero hero, Enemy enemy, BattleObserver observer, EnemyFactory enemyFactory) {
        this.hero = hero;
        this.enemy = enemy;
        this.observer = observer;
        this.scanner = new Scanner(System.in);
        this.enemyFactory = enemyFactory;
    }

    public void startBattle() {

        int wave = 1;

        while (hero.isAlive()) {

            System.out.println("\nВолна " + wave + " начинается!");
            System.out.println(hero.getName() + " VS " + enemy.getName());
            System.out.println("----------------------------------");

            runSingleBattle();

            if (!hero.isAlive()) {
                System.out.println("\nВы пали в бою...");
                break;
            }

            System.out.println("\nПобеда над " + enemy.getName() + "! Вы стали сильнее!");
            hero.levelUp();

            wave++;
            enemy = enemyFactory.createWaveEnemy(wave);
        }

        System.out.println("\n=================================");
        System.out.println("Игра окончена!");
    }

    private void runSingleBattle() {
        while (hero.isAlive() && enemy.isAlive()) {

            processPlayerTurn();
            observer.update(hero, enemy);

            if (!enemy.isAlive()) break;

            processEnemyTurn();
            observer.update(hero, enemy);
        }
    }

    private void processPlayerTurn() {

        System.out.println("\nВаш ход! Выберите действие:");
        System.out.println("1 - Обычная атака");
        System.out.println("2 - Вампирическая атака (урон ниже, лечение 50%)");
        System.out.println("3 - Защита");
        System.out.println("4 - Критический удар (урон ниже, 25% шанс крита x2.5)");
        System.out.print("> ");

        int choice = readInt();

        Action action;

        switch (choice) {

            case 1 -> {
                System.out.println("Вы наносите обычную атаку!");
                action = new AttackAction();
            }

            case 2 -> {
                System.out.println("Вы используете вампирическую атаку!");
                action = new VampireAttackDecorator(
                        new AttackAction(),
                        0.7,
                        0.5
                );
            }

            case 3 -> {
                System.out.println("Вы встали в защитную стойку.");
                action = new DefendAction();
            }

            case 4 -> {
                System.out.println("Вы бьёте с надеждой на крит!");
                action = new CriticalAttackDecorator(
                        new AttackAction(),
                        0.7,
                        2.5,
                        0.25
                );
            }

            default -> {
                System.out.println("Неверный выбор. Использована обычная атака.");
                action = new AttackAction();
            }
        }

        hero.setAction(action);
        observer.onAction(hero, action.getClass().getSimpleName());
        hero.performAction(enemy);

        if (action instanceof CriticalAttackDecorator crit) {
            if (crit.wasCrit()) {
                System.out.println("Критический удар! Нанесено: " + crit.getFinalDamage());
            } else {
                System.out.println("Урон без крита: " + crit.getFinalDamage());
            }
        }
    }

    private void processEnemyTurn() {

        System.out.println("\nХод врага...");

        enemy.getStrategy().change(enemy);

        if (enemy.getAction() != null) {
            observer.onAction(enemy, enemy.getAction().getClass().getSimpleName());
        }

        enemy.performAction(hero);
    }

    private int readInt() {
        while (1 == 1) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Введите число: ");
            }
        }
    }
}




