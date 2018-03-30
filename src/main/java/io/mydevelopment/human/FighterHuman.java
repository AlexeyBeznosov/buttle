package io.mydevelopment.human;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Fighter;

import java.util.List;

public class FighterHuman extends Fighter {
    private int hitFight = 18;

    public FighterHuman() {
    }

    public FighterHuman(Race race, boolean sideOfWar, Squad currentSquad) {
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

    public AbstractWarrior chooseOtherWarrior(Action action, List<Squad> squads) {
        return null;
    }

    public AbstractWarrior chooseOtherWarrior(List<Squad> squads) {
        return null;
    }
}
