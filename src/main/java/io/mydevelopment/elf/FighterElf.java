package io.mydevelopment.elf;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Fighter;

import java.util.List;

public class FighterElf extends Fighter {
    private int hitFight = 15;

    public FighterElf() {
    }

    public FighterElf(Race race, boolean sideOfWar) {
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
