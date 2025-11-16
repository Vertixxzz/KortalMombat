package mortalkombat.action;

import mortalkombat.hero.Hero;

public class DefendAction implements Action {
    private static final int DEFENSE_BONUS = 10;

    @Override
    public void execute(Hero actor, Hero target) {
        actor.setDefense(actor.getDefense() + DEFENSE_BONUS);
    }
}