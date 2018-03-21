package io.mydevelopment.undead;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Archer;

import java.util.List;

public class ArcherUndead extends Archer {
    private int hitArc = 4;
    private int hitFight = 2;

    public ArcherUndead() {
    }

    public ArcherUndead(Race race, boolean sideOfWar) {
        super(race, sideOfWar);
    }

    public int getHitArc() {
        return hitArc;
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

    public void doArchery(AbstractWarrior abstractWarrior) {

    }
}
