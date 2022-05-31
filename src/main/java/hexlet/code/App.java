package hexlet.code;

import hexlet.code.games.Even;


import java.util.Map;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        Cli.greetings();
        Map<Integer, Class<? extends Game>> map = Map.of(
                1, Even.class
        );
    }
}
