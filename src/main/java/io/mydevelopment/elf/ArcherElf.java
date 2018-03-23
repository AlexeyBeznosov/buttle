package io.mydevelopment.elf;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Archer;

import java.util.List;

public class ArcherElf extends Archer {
    private int hitArc = 7;
    private int hitFight = 3;

    public ArcherElf() {
    }

    public ArcherElf(Race race, boolean sideOfWar) {
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

    public AbstractWarrior chooseOtherWarrior(Action action, List<Squad> squads) {
        return null;
    }

    public List<Squad> getEnemySquad(Squad squad, Action action, List<Squad> squads) {
        return null;
    }

    public void doHit(Action action, AbstractWarrior abstractWarriorEnemy) {

    }

    public List<Squad> getEnemySquad(List<Squad> squads) {
        return null;
    }

    public AbstractWarrior chooseOtherWarrior(List<Squad> squads) {
        return null;
    }

    public void doArchery(AbstractWarrior abstractWarrior) {

    }
}
