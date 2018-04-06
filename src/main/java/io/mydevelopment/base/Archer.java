package io.mydevelopment.base;

import io.mydevelopment.*;
import io.mydevelopment.elf.ArcherElf;

import java.util.ArrayList;
import java.util.List;

public abstract class Archer extends AbstractWarrior implements Archerable {

    public Archer() {
    }

    public Archer(Race race, int sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
    }

    @Override
    public void fillActions() {
        Action action;
        action = Action.ARC;
        actions.add(action);
        action = Action.FIGHT;
        actions.add(action);
    }

    @Override
    public void doHit(Action action, AbstractWarrior abstractWarriorEnemy, Squad enemySquad) {
        switch (action) {
            case ARC: {
                doArchery(abstractWarriorEnemy);
                if (!chechHealth(abstractWarriorEnemy)) {
                    enemySquad.getWarriors().remove(abstractWarriorEnemy);
                }
                break;
            }
            case FIGHT: {
                super.doHit(action, abstractWarriorEnemy, enemySquad);
                break;
            }
        }
    }

    @Override
    public List<Squad> getEnemySquad(Squad squad, Action action, List<Squad> squads) {
        List<Squad> enemySquads = new ArrayList<Squad>();
        switch (action) {
            case ARC: {
                for (Squad squadOfGame : squads) {
                    if (!(squadOfGame.getSideOfWar() == squad.getSideOfWar())) {
                        enemySquads.add(squadOfGame);
                    }
                }
                return enemySquads;
            }
            case FIGHT: {
                enemySquads = super.getEnemySquad(squad, action, squads);
                return enemySquads;
            }
        }
        return null;
    }
}
