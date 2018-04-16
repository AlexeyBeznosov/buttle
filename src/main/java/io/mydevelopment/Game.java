package io.mydevelopment;

import io.mydevelopment.controller.Controller;

import java.util.*;

public class Game extends Observable {
    private final int COUNT_WARLOCK = 1;
    private final int COUNT_ARCHER = 3;
    private final int COUNT_FIGHTER = 4;
    private Race[][] arrayOfRaces = {{Race.ELF, Race.HUMAN},{Race.ORC, Race.UNDEAD}};
    private List<Race> races;
    private List<Squad> squads;
    private Controller controller;

    int countWhite;
    int countBlack;

    public Game() {
        squads = new ArrayList<Squad>();
        races = new ArrayList<Race>();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    public void start() {
        int numberOfSquads = 2;
        generateRaces(numberOfSquads);
        generateSquadsOfRaces();
        doFight();
    }

    private void doFight() {
        Squad currentSquad = selectRandomSquad(squads);
        while (true) {

            //currentSquad.fightWarrior(squads);

            AbstractWarrior abstractWarrior = currentSquad.selectWarrior();
            Action action = abstractWarrior.selectRandomAction();
            List<Squad> enemySquads = abstractWarrior.getEnemySquad(currentSquad, action, squads);
            Squad enemySquad = selectRandomSquad(enemySquads);
            AbstractWarrior abstractWarriorEnemy = enemySquad.getRandomWarrior(enemySquad.getWarriors());

            System.out.println(abstractWarrior);
            System.out.println(action);
            System.out.println(abstractWarriorEnemy);
            System.out.println(abstractWarriorEnemy.getHealth());

            abstractWarrior.doHit(action, abstractWarriorEnemy, enemySquad);

            System.out.println(abstractWarriorEnemy.getHealth());
            System.out.println();

            if (abstractWarrior.isPrivileged()) {
                abstractWarrior.setPrivileged(false);
                currentSquad.getPrivilegedWarriors().remove(abstractWarrior);
            }
            if (!(abstractWarrior.getKoefHit() == 1)) {
                abstractWarrior.setKoefHit(1);
            }
            if (enemySquad.getWarriors().isEmpty()) {
                enemySquad.setAlive(false);
                squads.remove(enemySquad);
            }

            checkSquads();
            if (countWhite > 0 && countBlack > 0) {
                currentSquad = selectOtherSquad(currentSquad);
            } else {
                System.out.println("win - " + currentSquad.getRace());
                break;
            }
        }
    }

    private void checkSquads() {
        countWhite = 0;
        countBlack = 0;
        for (Squad squad : squads) {
            if  (squad.getSideOfWar() == 0 && squad.isAlive()) {
                countWhite++;
            } else if (squad.getSideOfWar() == 1 && squad.isAlive()) {
                countBlack++;
            }
        }
    }

    private Squad selectOtherSquad(Squad currentSquad) {
        Squad squad;
        do {
            squad = selectRandomSquad(squads);
        } while (squad.getRace() == currentSquad.getRace());
        return squad;
    }

    private Squad selectRandomSquad(List<Squad> squads) {
        int choiseSquad = (int) Math.round((squads.size() - 1) * Math.random());
        return squads.get(choiseSquad);
    }

    private void generateSquadsOfRaces() {
        for (Race race : races) {
            int sideOfWar = getIndexSideOfWar(race);
            Squad squad = new Squad(race, sideOfWar, COUNT_WARLOCK, COUNT_ARCHER, COUNT_FIGHTER);
            squad.createSquad();
            squads.add(squad);
        }
    }

    private void generateRaces(int numberOfSquads) {
        int countSquad = 0;
        int countOfRases = Race.values().length;
        while (countSquad < numberOfSquads) {
            int number = (int) Math.round((countOfRases - 1) * Math.random());
            if (!checkContainsRace(number)) {
                Race race = Race.values()[number];
                races.add(race);
                addCountSideWar(race);
                countSquad++;
                System.out.println(number + " - " + race);
            }
        }
    }

    private void addCountSideWar(Race race) {
        int index = getIndexSideOfWar(race);
        if (index == 0) {
            countWhite++;
        } else if (index == 1) {
            countBlack++;
        }
    }

    private boolean checkContainsRace(int number) {
        Race race = Race.values()[number];
        if (races.contains(race)) {
            return true;
        }
        return checkSideOfWar(race);
    }

    private boolean checkSideOfWar(Race race) {
        if (getIndexSideOfWar(race) == 0) {
            return countWhite > 0 ? true : false;
        } else if (getIndexSideOfWar(race) == 1) {
            return countBlack > 0 ? true : false;
        }
        return true;
    }

    private int getIndexSideOfWar(Race race) {
        List<Race> listOfRaces;
        for (int i = 0; i < arrayOfRaces.length; i++) {
            listOfRaces = new ArrayList<Race>();
            Collections.addAll(listOfRaces, arrayOfRaces[i]);
            if (listOfRaces.contains(race)) {
                return i;
            }
        }
        return 0;
    }
}
