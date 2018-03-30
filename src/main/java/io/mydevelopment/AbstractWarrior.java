package io.mydevelopment;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractWarrior {
    private int health = 100;
    private boolean isPrivileged = false;
    private double koefHit = 1;
    protected Race race;
    protected boolean sideOfWar;
    protected List<Action> actions;
    protected Squad currentSquad;

    public AbstractWarrior() {
    }

    public AbstractWarrior(Race race, boolean sideOfWar, Squad currentSquad) {
        this.race = race;
        this.sideOfWar = sideOfWar;
        this.currentSquad = currentSquad;
        actions = new ArrayList<Action>();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getKoefHit() {
        return koefHit;
    }

    public void setKoefHit(double koefHit) {
        this.koefHit = koefHit;
    }

    public boolean isPrivileged() {
        return isPrivileged;
    }

    public void setPrivileged(boolean privileged) {
        isPrivileged = privileged;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public boolean isSideOfWar() {
        return sideOfWar;
    }

    public void setSideOfWar(boolean sideOfWar) {
        this.sideOfWar = sideOfWar;
    }

    public abstract void doFight(AbstractWarrior abstractWarrior);

    public abstract AbstractWarrior chooseOtherWarrior(Action action, List<Squad> squads);

    public Action selectRandomAction() {
        int choice = (int) Math.round((actions.size() - 1) * Math.random());
        return actions.get(choice);
    }

    public abstract void fillActions();

    public List<Squad> getEnemySquad(Squad squad, Action action, List<Squad> squads) {
        List<Squad> enemySquads = new ArrayList<Squad>();
        switch (action) {
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
            case FIGHT: {
                doFight(abstractWarriorEnemy);
                if (!chechHealth(abstractWarriorEnemy)) {
                    squad.getWarriors().remove(abstractWarriorEnemy);
                }
                break;
            }
        }
    }

    public boolean chechHealth(AbstractWarrior abstractWarrior) {
        if (abstractWarrior.getHealth() == 0) {
            return false;
            //enemySquad.getWarriors().remove(abstractWarriorEnemy);
        }
        return true;
    }
}
