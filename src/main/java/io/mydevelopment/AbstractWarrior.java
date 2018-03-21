package io.mydevelopment;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractWarrior {
    int health = 100;
    boolean isPrivileged = false;
    protected double koefHit = 1;
    protected Race race;
    protected boolean sideOfWar;
    protected List<Action> actions;

    public AbstractWarrior() {
    }

    public AbstractWarrior(Race race, boolean sideOfWar) {
        this.race = race;
        this.sideOfWar = sideOfWar;
        actions = new ArrayList<Action>();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public abstract void chooseOtherWarrior(List<AbstractWarrior> setOfWarriors);

    public abstract void chooseDo(List<Squad> setSquads);

    public abstract void fillActions();
}
