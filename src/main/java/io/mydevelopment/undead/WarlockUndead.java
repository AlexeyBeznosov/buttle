package io.mydevelopment.undead;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;

import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

import java.util.List;

public class WarlockUndead extends Warlock {
    protected int hitFight = 5;

    public WarlockUndead() {
    }

    public WarlockUndead(Race race, boolean sideOfWar) {
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

    public void doWiz(AbstractWarrior abstractWarrior) {
        System.out.println("колдую");
    }
}
