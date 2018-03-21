package io.mydevelopment.elf;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

import java.util.List;

public class WarlockElf extends Warlock {
    private int hitFight = 10;

    public WarlockElf() {
    }

    public WarlockElf(Race race, boolean sideOfWar) {
        super(race, sideOfWar);
    }

    public int getHitFight() {
        return hitFight;
    }

    public void setHitFight(int hitFight) {
        this.hitFight = hitFight;
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
