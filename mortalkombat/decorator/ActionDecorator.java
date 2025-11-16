
package mortalkombat.decorator;

import mortalkombat.action.Action;
import mortalkombat.hero.Hero;

public abstract class ActionDecorator implements Action {
    protected final Action baseAction;

    public ActionDecorator(Action baseAction) {
        this.baseAction = baseAction;
    }

    @Override
    public void beforeExecute(Hero actor, Hero target) {
    }

    @Override
    public void execute(Hero actor, Hero target) {
        beforeExecute(actor, target);
        baseAction.beforeExecute(actor, target);
        baseAction.execute(actor, target);
        baseAction.afterExecute(actor, target);
        afterExecute(actor, target);
    }

    @Override
    public void afterExecute(Hero actor, Hero target) {
    }
}
