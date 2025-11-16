package mortalkombat.action;

import mortalkombat.hero.Hero;

public interface Action {
    default void beforeExecute(Hero actor, Hero target) {}
    void execute(Hero actor, Hero target);
    default void afterExecute(Hero actor, Hero target) {}
}