package io.mydevelopment.undead;

import io.mydevelopment.base.AbstractWarrior;
import io.mydevelopment.enums.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Fighter;

public class FighterUndead extends Fighter {
    private int hitFight = 18;

    public FighterUndead() {
    }

    public FighterUndead(Race race, int sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
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
}
