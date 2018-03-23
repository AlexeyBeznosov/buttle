package io.mydevelopment.orc;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
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
