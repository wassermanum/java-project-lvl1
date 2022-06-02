package hexlet.code.games;

import hexlet.code.Game;

public final class Exit implements Game {
    public void play() {
        System.exit(0);
    }
}
