package io.mydevelopment.human;

import io.mydevelopment.base.AbstractWarrior;
import io.mydevelopment.enums.Action;
import io.mydevelopment.enums.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

public class WarlockHuman extends Warlock {
    protected int hitFight = 4;

    public WarlockHuman() {
    }

    public WarlockHuman(Race race, int sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
    }

    public int getHitFight() {
        return hitFight;
    }

    public void doFight(AbstractWarrior abstractWarrior) {
        int currentHit = (int) Math.round(hitFight * this.getKoefHit());
        if (abstractWarrior.getHealth() > currentHit) {
            abstractWarrior.setHealth(abstractWarrior.getHealth() - currentHit);
        } else {
            abstractWarrior.setHealth(0);
        }
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
