package io.mydevelopment.orc;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

import java.util.ArrayList;
import java.util.List;

public class WarlockOrc extends Warlock {

    public WarlockOrc() {
    }

    public WarlockOrc(Race race, boolean sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
    }

    public void doFight(AbstractWarrior abstractWarrior) {

    }

    public AbstractWarrior chooseOtherWarrior(Action action, List<Squad> squads) {
        return null;
    }

    public AbstractWarrior chooseOtherWarrior(List<Squad> squads) {
        return null;
    }

    public void doWiz(AbstractWarrior abstractWarrior) {
        abstractWarrior.setPrivileged(true);
    }

    public void doHit(Action action, AbstractWarrior abstractWarriorEnemy, Squad squad) {
        switch (action) {
            case WIZ: {
                doWiz(abstractWarriorEnemy);
                squad.getPrivilegedWarriors().add(abstractWarriorEnemy);
            }
            case FIGHT: {
                doFight(abstractWarriorEnemy);
                if (abstractWarriorEnemy.getHealth() == 0) {
                    squad.getWarriors().remove(abstractWarriorEnemy);
                }
            }
        }
    }
}
