package mortalkombat.decorator;

import mortalkombat.action.Action;
import mortalkombat.decorator.ActionDecorator;
import mortalkombat.action.AttackAction;
import mortalkombat.hero.Hero;

public class VampireAttackDecorator extends ActionDecorator {

    private final double damageMultiplier;
    private final double healFactor;

    private int lastHeal = 0;  // фасад прочитает это дай бог
    private int lastDamage = 0;

    public VampireAttackDecorator(Action baseAction, double damageMultiplier, double healFactor) {
        super(baseAction);
        this.damageMultiplier = damageMultiplier;
        this.healFactor = healFactor;
    }

    public int getLastHeal() {
        return lastHeal;
    }

    public int getLastDamage() {
        return lastDamage;
    }

    @Override
    public void execute(Hero actor, Hero target) {

        lastHeal = 0;
        lastDamage = 0;

        if (!(baseAction instanceof AttackAction)) {
            baseAction.execute(actor, target);
            return;
        }

        int originalAttack = actor.getAttack();

        int weakenedAttack = (int) (originalAttack * damageMultiplier);
        actor.setAttack(weakenedAttack);

        int targetBefore = target.getHealth();
        baseAction.execute(actor, target);
        int damage = targetBefore - target.getHealth();

        lastDamage = Math.max(0, damage);
        actor.setAttack(originalAttack);

        int heal = (int) (lastDamage * healFactor);
        lastHeal = heal;

        actor.setHealth(actor.getHealth() + heal);
    }
}

