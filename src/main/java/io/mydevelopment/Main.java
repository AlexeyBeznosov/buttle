package io.mydevelopment;

import io.mydevelopment.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Controller controller = new Controller(game);
        game.setController(controller);
        game.start();
    }
}
