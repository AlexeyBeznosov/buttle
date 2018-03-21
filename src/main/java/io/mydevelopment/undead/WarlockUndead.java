package io.mydevelopment.undead;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

import java.util.List;

public class WarlockUndead extends Warlock {

    public WarlockUndead() {
    }

    public WarlockUndead(Race race, boolean sideOfWar) {
        super(race, sideOfWar);
    }

    public void doFight(AbstractWarrior abstractWarrior) {

    }

    public void chooseOtherWarrior(List<AbstractWarrior> setOfWarriors) {

    }

    public void chooseDo(List<Squad> setSquads) {

    }

    public void doWiz(AbstractWarrior abstractWarrior) {
        System.out.println("колдую");
    }
}
