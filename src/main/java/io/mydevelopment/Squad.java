package io.mydevelopment;

import io.mydevelopment.elf.ArcherElf;
import io.mydevelopment.elf.FighterElf;
import io.mydevelopment.elf.WarlockElf;
import io.mydevelopment.human.ArcherHuman;
import io.mydevelopment.human.FighterHuman;
import io.mydevelopment.human.WarlockHuman;
import io.mydevelopment.orc.ArcherOrc;
import io.mydevelopment.orc.FighterOrc;
import io.mydevelopment.orc.WarlockOrc;
import io.mydevelopment.undead.ArcherUndead;
import io.mydevelopment.undead.FighterUndead;
import io.mydevelopment.undead.WarlockUndead;

import java.util.HashSet;
import java.util.Set;

public class Squad {
    Set<AbstractWarrior> warriors;
    Set<AbstractWarrior> privilegedWarriors;
    Race race;
    boolean sideOfWar;
    int countWarlock;
    int countArcher;
    int countFighter;

    public Squad(Race race, int countWarlock, int countArcher, int countFighter) {
        this.race = race;
        this.countWarlock = countWarlock;
        this.countArcher = countArcher;
        this.countFighter = countFighter;
    }

    public void createSquad() {
        warriors = new HashSet<AbstractWarrior>();
        privilegedWarriors = new HashSet<AbstractWarrior>();
        switch (race) {
            case ELF: {
                sideOfWar = true;
                for (int i = 0; i < countWarlock; i++) {
                    AbstractWarrior warrior = new WarlockElf(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countArcher; i++) {
                    AbstractWarrior warrior = new ArcherElf(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countFighter; i++) {
                    AbstractWarrior warrior = new FighterElf(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                break;
            }
            case HUMAN: {
                sideOfWar = true;
                for (int i = 0; i < countWarlock; i++) {
                    AbstractWarrior warrior = new WarlockHuman(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countArcher; i++) {
                    AbstractWarrior warrior = new ArcherHuman(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countFighter; i++) {
                    AbstractWarrior warrior = new FighterHuman(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                break;
            }
            case ORC: {
                sideOfWar = false;
                for (int i = 0; i < countWarlock; i++) {
                    AbstractWarrior warrior = new WarlockOrc(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countArcher; i++) {
                    AbstractWarrior warrior = new ArcherOrc(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countFighter; i++) {
                    AbstractWarrior warrior = new FighterOrc(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                break;
            }
            case UNDEAD: {
                sideOfWar = false;

                //fillSquad(WarlockUndead.class);

                for (int i = 0; i < countWarlock; i++) {
                    AbstractWarrior warrior = new WarlockUndead(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countArcher; i++) {
                    AbstractWarrior warrior = new ArcherUndead(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countFighter; i++) {
                    AbstractWarrior warrior = new FighterUndead(race, sideOfWar);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                break;
            }
        }
    }

    private void fillSquad(Class<WarlockUndead> warlockUndeadClass) {

        try {
            AbstractWarrior warrior = warlockUndeadClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
