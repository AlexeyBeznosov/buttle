package io.mydevelopment.observer;

import io.mydevelopment.base.AbstractWarrior;
import io.mydevelopment.enums.Race;

public interface MyObserver {
    void update(AbstractWarrior abstractWarrior, AbstractWarrior abstractWarriorEnemy, int hit, boolean isAlive);
    void update(Race winRace);
}
