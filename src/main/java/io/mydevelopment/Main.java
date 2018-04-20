package io.mydevelopment;

import io.mydevelopment.observer.impl.ConsoleLog;
import io.mydevelopment.observer.MyObserver;
import io.mydevelopment.observer.impl.FileLog;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        MyObserver abstractObserver = new ConsoleLog(game);
        game.add(abstractObserver);
        abstractObserver = new FileLog(game);
        game.add(abstractObserver);
        game.start();
    }
}
