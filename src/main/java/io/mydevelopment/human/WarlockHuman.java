package io.mydevelopment.human;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

import java.util.ArrayList;
import java.util.List;

public class WarlockHuman extends Warlock {
    protected int hitFight = 4;

    public WarlockHuman() {
    }

    public WarlockHuman(Race race, boolean sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
    }

    public int getHitFight() {
        return hitFight;
    }

    public void doWiz(AbstractWarrior abstractWarrior) {
        abstractWarrior.setPrivileged(true);
    }

    public void doFight(AbstractWarrior abstractWarrior) {
        int currentHit = (int) Math.round(hitFight * this.getKoefHit());
        if (abstractWarrior.getHealth() > currentHit) {
            abstractWarrior.setHealth(abstractWarrior.getHealth() - currentHit);
        } else {
            abstractWarrior.setHealth(0);
        }
    }

    public AbstractWarrior chooseOtherWarrior(Action action, List<Squad> squads) {
        return null;
    }

    public AbstractWarrior chooseOtherWarrior(List<Squad> squads) {
        return null;
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
