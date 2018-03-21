package io.mydevelopment.orc;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

import java.util.List;

public class WarlockOrc extends Warlock {
    protected int hitFight = 5;

    public WarlockOrc() {
    }

    public WarlockOrc(Race race, boolean sideOfWar) {
        super(race, sideOfWar);
    }

    public int getHitFight() {
        return hitFight;
    }

    public void doFight(AbstractWarrior abstractWarrior) {

    }

    public void chooseOtherWarrior(List<AbstractWarrior> setOfWarriors) {

    }

    public void chooseDo(List<Squad> setSquads) {

    }

    public void doWiz(AbstractWarrior abstractWarrior) {

    }
}
