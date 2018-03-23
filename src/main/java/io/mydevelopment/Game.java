package io.mydevelopment;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final int COUNT_WARLOCK = 1;
    final int COUNT_ARCHER = 3;
    final int COUNT_FIGHTER = 4;
    List<Race> races;
    List<Squad> squads;

    public Game() {
        squads = new ArrayList<Squad>();
        races = new ArrayList<Race>();
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
        Squad currentSquad = selectRandomSquad();
        do {
            currentSquad.fightWarrior(squads);
            currentSquad = selectOtherSquad(currentSquad);
        } while (!currentSquad.getWarriors().isEmpty());


    }

    private Squad selectOtherSquad(Squad currentSquad) {
        Squad squad;
        do {
            squad = selectRandomSquad();
        } while (squad.getRace() == currentSquad.getRace());
        return squad;
    }

    private Squad selectRandomSquad() {
        int choiseSquad = (int) Math.round(Math.random());
        return squads.get(choiseSquad);
    }

    private void generateSquadsOfRaces() {
        for (Race race : races) {
            Squad squad = new Squad(race, COUNT_WARLOCK, COUNT_ARCHER, COUNT_FIGHTER);
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
                countSquad++;
                System.out.println(number + " - " + race);
            }
        }
    }

    private boolean checkContainsRace(int number) {
        Race race = Race.values()[number];
        if (races.contains(race)) {
            return true;
        }
        switch (race) {
            case HUMAN: {
                return races.contains(Race.ELF);
            }
            case ELF: {
                return races.contains(Race.HUMAN);
            }
            case ORC: {
                return races.contains(Race.UNDEAD);
            }
            case UNDEAD: {
                return races.contains(Race.ORC);
            }
        }
        return false;
    }
}
