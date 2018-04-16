package io.mydevelopment.elf;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;
import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

import java.util.ArrayList;
import java.util.List;

public class WarlockElf extends Warlock {
    private int hitFight = 10;

    public WarlockElf() {
    }

    public WarlockElf(Race race, int sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
    }

    public int getHitFight() {
        return hitFight;
    }

    public void setHitFight(int hitFight) {
        this.hitFight = hitFight;
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
