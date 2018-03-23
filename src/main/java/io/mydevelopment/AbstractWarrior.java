package io.mydevelopment;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractWarrior {
    int health = 100;
    boolean isPrivileged = false;
    double koefHit = 1;
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

//    public void chooseDo() {
//        Action action = selectAction();
//        System.out.println(action.toString());
//    }

//    private void doAction(Action action, List<Squad> squads) {
//        switch (action) {
//            case WIZ: {
//
//                break;
//            }
//            case ARC: {
//                break;
//            }
//            case FIGHT: {
//                break;
//            }
//        }
//    }

    public Action selectRandomAction() {
        int choice = (int) Math.round((actions.size() - 1) * Math.random());
        return actions.get(choice);
    }

    public abstract void fillActions();

    public abstract List<Squad> getEnemySquad(Squad squad, Action action, List<Squad> squads);

    public abstract void doHit(Action action, AbstractWarrior abstractWarriorEnemy, Squad squad);
}
