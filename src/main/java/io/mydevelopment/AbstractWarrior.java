package io.mydevelopment;

import java.util.Set;

public abstract class AbstractWarrior {
    int health = 100;
    boolean isPrivileged = false;
    int defaultHit;
    int currentHit;
    Race race;
    boolean sideOfWar;

    public abstract void doFight(AbstractWarrior abstractWarrior);

    public abstract void chooseOtherWarrior(Set<AbstractWarrior> setOfWarriors);

    public abstract void chooseDo(Set<Squad> setSquads);
}
