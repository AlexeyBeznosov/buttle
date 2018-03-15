package io.mydevelopment;

public abstract class AbstractWarrior {
    int health = 100;
    boolean isPrivileged = false;

    public abstract void doFight(AbstractWarrior abstractWarrior);

}
