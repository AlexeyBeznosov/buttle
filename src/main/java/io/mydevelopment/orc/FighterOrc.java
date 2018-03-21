package io.mydevelopment.orc;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Fighter;

import java.util.List;

public class FighterOrc extends Fighter {
    private int hitFight = 20;

    public FighterOrc() {
    }

    public FighterOrc(Race race, boolean sideOfWar) {
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
}
