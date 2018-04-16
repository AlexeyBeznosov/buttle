package io.mydevelopment.undead;

import io.mydevelopment.AbstractWarrior;
import io.mydevelopment.Action;
import io.mydevelopment.Race;

import io.mydevelopment.Squad;
import io.mydevelopment.base.Warlock;

import java.util.ArrayList;
import java.util.List;

public class WarlockUndead extends Warlock {
    protected int hitFight = 5;

    public WarlockUndead() {
    }

    public WarlockUndead(Race race, int sideOfWar, Squad currentSquad) {
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

    public List<Squad> getEnemySquad(Squad squad, Action action, List<Squad> squads) {
        List<Squad> enemySquads = new ArrayList<Squad>();
        switch (action) {
            case WIZ: {
                for (Squad squadOfGame : squads) {
                    if (!(squadOfGame.getSideOfWar() == squad.getSideOfWar())) {
                        enemySquads.add(squadOfGame);
                    }
                }
                return enemySquads;
            }
            case FIGHT: {
                for (Squad squadOfGame : squads) {
                    if (!(squadOfGame.getSideOfWar() == squad.getSideOfWar())) {
                        enemySquads.add(squadOfGame);
                    }
                }
                return enemySquads;
            }
        }
        return null;
    }

    public void doWiz(AbstractWarrior abstractWarrior) {
        abstractWarrior.setKoefHit(0.5);
    }

    public void doHit(Action action, AbstractWarrior abstractWarriorEnemy, Squad enemySquad) {
        switch (action) {
            case WIZ: {
                doWiz(abstractWarriorEnemy);
                break;
            }
            case FIGHT: {
                super.doHit(action, abstractWarriorEnemy, enemySquad);
                break;
            }
        }
    }
}
