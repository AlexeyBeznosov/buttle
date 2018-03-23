package io.mydevelopment.human;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

import java.util.List;

public class WarlockHuman extends Warlock {
    protected int hitFight = 4;

    public WarlockHuman() {
    }

    public WarlockHuman(Race race, boolean sideOfWar) {
        super(race, sideOfWar);
    }

    public int getHitFight() {
        return hitFight;
    }

    public void doWiz(AbstractWarrior abstractWarrior) {

    }

    public void doFight(AbstractWarrior abstractWarrior) {

    }

    public AbstractWarrior chooseOtherWarrior(Action action, List<Squad> squads) {
        return null;
    }

    public List<Squad> getEnemySquad(List<Squad> squads) {
        return null;
    }

    public AbstractWarrior chooseOtherWarrior(List<Squad> squads) {
        return null;
    }
}
