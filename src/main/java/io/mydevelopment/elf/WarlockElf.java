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

    public WarlockElf(Race race, boolean sideOfWar) {
        super(race, sideOfWar);
    }

    public int getHitFight() {
        return hitFight;
    }

    public void setHitFight(int hitFight) {
        this.hitFight = hitFight;
    }

    public void doFight(AbstractWarrior abstractWarrior) {
        if (abstractWarrior.getHealth() > hitFight) {
            abstractWarrior.setHealth(abstractWarrior.getHealth() - hitFight);
        } else {
            abstractWarrior.setHealth(0);
        }
    }

    public AbstractWarrior chooseOtherWarrior(Action action, List<Squad> squads) {
        AbstractWarrior abstractWarrior = this;

        return null;
    }

    public List<Squad> getEnemySquad(Squad squad, Action action, List<Squad> squads) {
        List<Squad> enemySquads = new ArrayList<Squad>();
        switch (action) {
            case WIZ: {
                for (Squad squadOfGame : squads) {
                    if (squadOfGame.getSideOfWar() == squad.getSideOfWar()) {
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

    public void doHit(Action action, AbstractWarrior abstractWarriorEnemy, Squad squad) {
        switch (action) {
            case WIZ: {
                doWiz(abstractWarriorEnemy);
                squad.getPrivilegedWarriors().add(abstractWarriorEnemy);
            }
            case FIGHT: {
                doFight(abstractWarriorEnemy);
                if (abstractWarriorEnemy.getHealth() == 0) {
                    squad.getWarriors().remove(abstractWarriorEnemy);
                }
            }
        }
    }

    public void doWiz(AbstractWarrior abstractWarrior) {
        abstractWarrior.setPrivileged(true);
    }
}
