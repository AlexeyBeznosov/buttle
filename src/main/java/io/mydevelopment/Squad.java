package io.mydevelopment;

import java.util.Set;

public class Squad {
    Set<AbstractWarrior> warriors;
    Set<AbstractWarrior> privilegedWarriors;
    Race race;
    boolean sideOfWar;

    public Squad(Race race) {
        this.race = race;
    }
}
