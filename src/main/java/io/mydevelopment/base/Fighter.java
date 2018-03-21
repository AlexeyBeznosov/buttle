package io.mydevelopment.base;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;

public abstract class Fighter extends AbstractWarrior {

    public Fighter() {
    }

    public Fighter(Race race, boolean sideOfWar) {
        super(race, sideOfWar);
    }

    @Override
    public void fillActions() {
        Action action;
        action = Action.FIGHT;
        actions.add(action);
    }
}
