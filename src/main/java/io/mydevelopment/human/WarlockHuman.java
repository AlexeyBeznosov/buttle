package io.mydevelopment.human;

import io.mydevelopment.AbstractWarrior;
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

    public void chooseOtherWarrior(List<AbstractWarrior> setOfWarriors) {

    }

    public void chooseDo(List<Squad> setSquads) {

    }
}
