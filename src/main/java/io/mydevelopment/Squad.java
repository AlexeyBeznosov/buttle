package io.mydevelopment;

import io.mydevelopment.base.Warlock;
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

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private List<AbstractWarrior> warriors;
    private List<AbstractWarrior> privilegedWarriors;
    private Race race;
    private boolean sideOfWar;
    private int countWarlock;
    private int countArcher;
    private int countFighter;

    public Squad(Race race, int countWarlock, int countArcher, int countFighter) {
        this.race = race;
        this.countWarlock = countWarlock;
        this.countArcher = countArcher;
        this.countFighter = countFighter;
    }

    public List<AbstractWarrior> getWarriors() {
        return warriors;
    }

    public List<AbstractWarrior> getPrivilegedWarriors() {
        return privilegedWarriors;
    }

    public Race getRace() {
        return race;
    }

    public boolean getSideOfWar() {
        return sideOfWar;
    }

    public void createSquad() {
        warriors = new ArrayList<AbstractWarrior>();
        privilegedWarriors = new ArrayList<AbstractWarrior>();
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
            warrior.getHealth();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void fightWarrior(List<Squad> squads) {
        AbstractWarrior abstractWarrior = selectWarrior();
        Action action = abstractWarrior.selectRandomAction();

        List<Squad> enemySquads = abstractWarrior.getEnemySquad(this, action, squads);
        Squad enemySquad = getRandomSquad(enemySquads);
        AbstractWarrior abstractWarriorEnemy = getRandomWarrior(enemySquad.getWarriors());
        abstractWarrior.doHit(action, abstractWarriorEnemy, enemySquad);


        if (abstractWarrior.isPrivileged()) {
            abstractWarrior.setPrivileged(false);
        }
        if (abstractWarrior.getKoefHit() < 1 ) {
            abstractWarrior.setKoefHit(1);
        }
    }

    private Squad getRandomSquad(List<Squad> enemySquads) {
        int choise = (int) Math.round((enemySquads.size() - 1) * Math.random());
        return enemySquads.get(choise);
    }

    private AbstractWarrior selectWarrior() {
        AbstractWarrior abstractWarrior;
        if (!privilegedWarriors.isEmpty()) {
            abstractWarrior = getRandomWarrior(privilegedWarriors);
        } else {
            abstractWarrior = getRandomWarrior(warriors);
        }
        return abstractWarrior;
    }

    private AbstractWarrior getRandomWarrior(List<AbstractWarrior> warriors) {
        int choise = (int) Math.round((warriors.size() - 1) * Math.random());
        return warriors.get(choise);
    }
}
