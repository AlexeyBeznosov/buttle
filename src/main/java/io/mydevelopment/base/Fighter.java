package io.mydevelopment.base;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;

import java.util.ArrayList;
import java.util.List;

public abstract class Fighter extends AbstractWarrior {

    public Fighter() {
    }

    public Fighter(Race race, boolean sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
    }

    @Override
    public void fillActions() {
        Action action;
        action = Action.FIGHT;
        actions.add(action);
    }
}
