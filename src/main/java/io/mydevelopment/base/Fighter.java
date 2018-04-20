package io.mydevelopment.base;

import io.mydevelopment.enums.Action;
import io.mydevelopment.enums.Race;
import io.mydevelopment.Squad;

public abstract class Fighter extends AbstractWarrior {

    public Fighter() {
    }

    public Fighter(Race race, int sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
    }

    @Override
    public void fillActions() {
        Action action;
        action = Action.FIGHT;
        actions.add(action);
    }
}
