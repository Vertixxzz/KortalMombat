package mortalkombat.decorator;

import mortalkombat.action.Action;
import mortalkombat.decorator.ActionDecorator;
import mortalkombat.action.AttackAction;
import mortalkombat.hero.Hero;

import java.util.Random;

public class CriticalAttackDecorator extends ActionDecorator {

    private static final Random random = new Random();

    private final double baseDamageMultiplier;
    private final double critMultiplier;
    private final double critChance;

    private boolean crit = false;
    private int finalDamage = 0;

    public CriticalAttackDecorator(Action baseAction,
                                   double baseDamageMultiplier,
                                   double critMultiplier,
                                   double critChance) {
        super(baseAction);
        this.baseDamageMultiplier = baseDamageMultiplier;
        this.critMultiplier = critMultiplier;
        this.critChance = critChance;
    }

    public boolean wasCrit() {
        return crit;
    }

    public int getFinalDamage() {
        return finalDamage;
    }

    @Override
    public void execute(Hero actor, Hero target) {

        crit = false;
        finalDamage = 0;

        if (!(baseAction instanceof AttackAction)) {
            baseAction.execute(actor, target);
            return;
        }

        int originalAttack = actor.getAttack();
        int originalDefense = target.getDefense();

        int weakenedAttack = (int)(originalAttack * baseDamageMultiplier);
        actor.setAttack(weakenedAttack);

        if (random.nextDouble() < critChance) {
            crit = true;

            target.setDefense(0);

            actor.setAttack((int)(weakenedAttack * critMultiplier));
        }

        int before = target.getHealth();
        baseAction.execute(actor, target);
        int damage = before - target.getHealth();

        finalDamage = Math.max(0, damage);

        target.setDefense(originalDefense);
        actor.setAttack(originalAttack);
    }
}
