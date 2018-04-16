package io.mydevelopment.human;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Archer;

import java.util.List;

public class ArcherHuman extends Archer {
    private int hitArc = 5;
    private int hitFight = 3;

    public ArcherHuman() {
    }

    public ArcherHuman(Race race, int sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
    }

    public int getHitArc() {
        return hitArc;
    }

    public int getHitFight() {
        return hitFight;
    }

    public void doFight(AbstractWarrior abstractWarrior) {
        int currentHit = (int) Math.round(hitFight * this.getKoefHit());
        if (abstractWarrior.getHealth() > currentHit) {
            abstractWarrior.setHealth(abstractWarrior.getHealth() - currentHit);
        } else {
            abstractWarrior.setHealth(0);
        }
    }

    public void doArchery(AbstractWarrior abstractWarrior) {
        int currentHit = (int) Math.round(hitArc * this.getKoefHit());
        if (abstractWarrior.getHealth() > currentHit) {
            abstractWarrior.setHealth(abstractWarrior.getHealth() - currentHit);
        } else {
            abstractWarrior.setHealth(0);
        }
    }
}
