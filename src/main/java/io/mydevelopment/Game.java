package io.mydevelopment;

import java.util.HashSet;
import java.util.Set;

public class Game {
    Set<Squad> squads;
    Set<Rase> rases;

    public Game() {
        squads = new HashSet<Squad>();
        rases = new HashSet<Rase>();
    }

    public Set<Squad> getSquads() {
        return squads;
    }

    public void setSquads(Set<Squad> squads) {
        this.squads = squads;
    }

    public void start() {

    }
}
