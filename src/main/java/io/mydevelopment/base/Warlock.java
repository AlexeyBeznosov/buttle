package io.mydevelopment.base;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;
import io.mydevelopment.Warlockable;

public abstract class Warlock extends AbstractWarrior implements Warlockable {

    public Warlock() {
    }

    public Warlock(Race race, boolean sideOfWar) {
        super(race, sideOfWar);
    }

    @Override
    public void fillActions() {
        Action action;
        action = Action.WIZ;
        actions.add(action);
        action = Action.FIGHT;
        actions.add(action);
    }
}
