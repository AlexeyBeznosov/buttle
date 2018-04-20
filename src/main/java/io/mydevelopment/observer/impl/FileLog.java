package io.mydevelopment.observer.impl;

import io.mydevelopment.Subject;
import io.mydevelopment.base.AbstractWarrior;
import io.mydevelopment.enums.Race;
import io.mydevelopment.observer.AbstractObserver;

import java.io.*;

public class FileLog extends AbstractObserver {
    private String filename = "c:\\temp\\1.txt";

    public FileLog() {
    }

    public FileLog(Subject subject) {
        super(subject);
    }

    public void update(AbstractWarrior abstractWarrior, AbstractWarrior abstractWarriorEnemy, int hit, boolean isAlive) {
        try (FileWriter file = new FileWriter(filename, true)) {
                file.append(abstractWarrior.toString() + " ");
                file.append(abstractWarriorEnemy.toString() + " ");
                file.append("hit - " + hit + " ");
                file.append("isAlive - " + isAlive + " ");
                file.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Race winRace) {
        try (FileWriter file = new FileWriter(filename, true)) {
            file.append("win - " + winRace);
            file.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
