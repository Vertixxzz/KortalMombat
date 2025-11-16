package mortalkombat.action;

import mortalkombat.hero.Hero;

public class AttackAction implements Action {
    @Override
    public void execute(Hero actor, Hero target) {
        int damage = Math.max(actor.getAttack() - target.getDefense(), 0);
        target.takeDamage(damage);
    }
}