package io.mydevelopment.base;

import io.mydevelopment.*;
import io.mydevelopment.elf.ArcherElf;

import java.util.ArrayList;
import java.util.List;

public abstract class Archer extends AbstractWarrior implements Archerable {

    public Archer() {
    }

    public Archer(Race race, boolean sideOfWar, Squad currentSquad) {
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
}
