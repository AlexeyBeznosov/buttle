package io.mydevelopment.observer.impl;

import io.mydevelopment.Subject;
import io.mydevelopment.base.AbstractWarrior;
import io.mydevelopment.enums.Race;
import io.mydevelopment.observer.AbstractObserver;

public class ConsoleLog extends AbstractObserver {

    public ConsoleLog() {
    }

    public ConsoleLog(Subject subject) {
        super(subject);
    }

    public void update(AbstractWarrior abstractWarrior, AbstractWarrior abstractWarriorEnemy, int hit, boolean isAlive) {
        System.out.println("warrior - " + abstractWarrior);
        System.out.println("enemy - " + abstractWarriorEnemy);
        System.out.println("hit - " + hit);
        System.out.println("isAlive - " + isAlive);
        System.out.println();
    }

    public void update(Race winRace) {
        System.out.println("win - " + winRace);
    }
}
