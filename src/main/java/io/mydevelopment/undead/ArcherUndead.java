package io.mydevelopment.undead;

import io.mydevelopment.base.AbstractWarrior;
import io.mydevelopment.enums.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Archer;

public class ArcherUndead extends Archer {
    private int hitArc = 4;
    private int hitFight = 2;

    public ArcherUndead() {
    }

    public ArcherUndead(Race race, int sideOfWar, Squad currentSquad) {
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
