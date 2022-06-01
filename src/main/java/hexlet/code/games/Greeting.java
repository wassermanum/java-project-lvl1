package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Game;

public final class Greeting implements Game {
    public void play(String name) {
        Cli.greetings();
    }
}
