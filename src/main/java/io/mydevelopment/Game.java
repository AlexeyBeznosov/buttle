package io.mydevelopment;

import java.util.HashSet;
import java.util.Set;

public class Game {
    final int COUNT_WARLOCK = 1;
    final int COUNT_ARCHER = 3;
    final int COUNT_FIGHTER = 4;
    Set<Race> races;
    Set<Squad> squads;

    public Game() {
        squads = new HashSet<Squad>();
        races = new HashSet<Race>();
    }

    public Set<Squad> getSquads() {
        return squads;
    }

    public void setSquads(Set<Squad> squads) {
        this.squads = squads;
    }

    public void start() {
        int countSquad = 0;
        int countOfRases = Race.values().length;
        while (countSquad < 2) {
            int number = (int) Math.round((countOfRases - 1) * Math.random());
            if (!checkContainsRace(number)) {
                Race race = Race.values()[number];
                races.add(race);
                countSquad++;
                System.out.println(number + race.toString());
            }
//            if (number == 0) {
//            }
            //Squad squadElf = new Squad();
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
