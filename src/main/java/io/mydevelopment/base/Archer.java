package io.mydevelopment.base;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Archerable;
import io.mydevelopment.Race;

public abstract class Archer extends AbstractWarrior implements Archerable {

    public Archer() {
    }

    public Archer(Race race, boolean sideOfWar) {
        super(race, sideOfWar);
    }

    @Override
    public void fillActions() {
        Action action;
        action = Action.ARC;
        actions.add(action);
        action = Action.FIGHT;
        actions.add(action);
    }
}
