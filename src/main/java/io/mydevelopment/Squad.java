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

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private List<AbstractWarrior> warriors;
    private List<AbstractWarrior> privilegedWarriors;
    private Race race;
    private int sideOfWar;
    private int countWarlock;
    private int countArcher;
    private int countFighter;
    private boolean isAlive;

    public Squad(Race race, int sideOfWar, int countWarlock, int countArcher, int countFighter) {
        this.race = race;
        this.sideOfWar = sideOfWar;
        this.countWarlock = countWarlock;
        this.countArcher = countArcher;
        this.countFighter = countFighter;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
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

    public int getSideOfWar() {
        return sideOfWar;
    }

    public void createSquad() {
        warriors = new ArrayList<AbstractWarrior>();
        privilegedWarriors = new ArrayList<AbstractWarrior>();
        isAlive = true;
        switch (race) {
            case ELF: {
                for (int i = 0; i < countWarlock; i++) {
                    AbstractWarrior warrior = new WarlockElf(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countArcher; i++) {
                    AbstractWarrior warrior = new ArcherElf(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countFighter; i++) {
                    AbstractWarrior warrior = new FighterElf(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                break;
            }
            case HUMAN: {
                for (int i = 0; i < countWarlock; i++) {
                    AbstractWarrior warrior = new WarlockHuman(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countArcher; i++) {
                    AbstractWarrior warrior = new ArcherHuman(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countFighter; i++) {
                    AbstractWarrior warrior = new FighterHuman(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                break;
            }
            case ORC: {
                for (int i = 0; i < countWarlock; i++) {
                    AbstractWarrior warrior = new WarlockOrc(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countArcher; i++) {
                    AbstractWarrior warrior = new ArcherOrc(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countFighter; i++) {
                    AbstractWarrior warrior = new FighterOrc(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                break;
            }
            case UNDEAD: {

                //fillSquad(WarlockUndead.class);

                for (int i = 0; i < countWarlock; i++) {
                    AbstractWarrior warrior = new WarlockUndead(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countArcher; i++) {
                    AbstractWarrior warrior = new ArcherUndead(race, sideOfWar, this);
                    warrior.fillActions();
                    warriors.add(warrior);
                }
                for (int i = 0; i < countFighter; i++) {
                    AbstractWarrior warrior = new FighterUndead(race, sideOfWar, this);
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
            privilegedWarriors.remove(abstractWarrior);
        }
        if (abstractWarrior.getKoefHit() < 1 ) {
            abstractWarrior.setKoefHit(1);
        }
        if (enemySquad.getWarriors().isEmpty()) {
            enemySquad.isAlive = false;
            squads.remove(enemySquad);
        }
    }

    public Squad getRandomSquad(List<Squad> enemySquads) {
        int choise = (int) Math.round((enemySquads.size() - 1) * Math.random());
        return enemySquads.get(choise);
    }

    public AbstractWarrior selectWarrior() {
        AbstractWarrior abstractWarrior;
        if (!privilegedWarriors.isEmpty()) {
            abstractWarrior = getRandomWarrior(privilegedWarriors);
        } else {
            abstractWarrior = getRandomWarrior(warriors);
        }
        return abstractWarrior;
    }

    public AbstractWarrior getRandomWarrior(List<AbstractWarrior> warriors) {
        int choise = (int) Math.round((warriors.size() - 1) * Math.random());
        return warriors.get(choise);
    }
}
