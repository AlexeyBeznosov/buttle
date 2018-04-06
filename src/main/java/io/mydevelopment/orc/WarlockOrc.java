package io.mydevelopment.orc;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

import java.util.List;

public class WarlockOrc extends Warlock {

    public WarlockOrc() {
    }

    public WarlockOrc(Race race, int sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
    }

    public void doFight(AbstractWarrior abstractWarriorEnemy) {
        abstractWarriorEnemy.setPrivileged(false);
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

    public void doHit(Action action, AbstractWarrior abstractWarriorEnemy, Squad squadEnemy) {
        switch (action) {
            case WIZ: {
                doWiz(abstractWarriorEnemy);
                squadEnemy.getPrivilegedWarriors().add(abstractWarriorEnemy);

            }
            case FIGHT: {
                doFight(abstractWarriorEnemy);
                List<AbstractWarrior> listOfPrivillegedWarriors = squadEnemy.getPrivilegedWarriors();
                if (listOfPrivillegedWarriors.contains(abstractWarriorEnemy))
                    listOfPrivillegedWarriors.remove(abstractWarriorEnemy);
            }
        }
    }
}
