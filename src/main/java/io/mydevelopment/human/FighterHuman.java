package io.mydevelopment.human;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Fighter;

import java.util.List;

public class FighterHuman extends Fighter {
    private int hitFight = 18;

    public FighterHuman() {
    }

    public FighterHuman(Race race, boolean sideOfWar) {
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
