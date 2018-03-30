package io.mydevelopment.base;

import io.mydevelopment.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Warlock extends AbstractWarrior implements Warlockable {

    public Warlock() {
    }

    public Warlock(Race race, boolean sideOfWar, Squad currentSquad) {
        super(race, sideOfWar, currentSquad);
    }

    @Override
    public void fillActions() {
        Action action;
        action = Action.WIZ;
        actions.add(action);
        action = Action.FIGHT;
        actions.add(action);
    }

    public List<Squad> getEnemySquad(Squad squad, Action action, List<Squad> squads) {
        List<Squad> enemySquads;
        switch (action) {
            case WIZ: {
                enemySquads = new ArrayList<Squad>();
                for (Squad squadOfGame : squads) {
                    if (squadOfGame.getSideOfWar() == squad.getSideOfWar()) {
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

    public void doHit(Action action, AbstractWarrior abstractWarriorEnemy, Squad enemySquad) {
        switch (action) {
            case WIZ: {
                doWiz(abstractWarriorEnemy);
                enemySquad.getPrivilegedWarriors().add(abstractWarriorEnemy);
                break;
            }
            case FIGHT: {
                super.doHit(action, abstractWarriorEnemy, enemySquad);
                break;
            }
        }
    }
}
