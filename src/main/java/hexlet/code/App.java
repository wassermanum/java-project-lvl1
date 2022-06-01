package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Greeting;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        String name = Cli.greetings();
        Map<Integer, Supplier<? extends Game>> map = Map.of(
                0, () -> new Greeting(),
                1, () -> new Even()
        );
        System.out.println("0. Greeting.");
        System.out.println("1. Even.");
        System.out.println("Your choose: ");
        Scanner in = new Scanner(System.in);
        Supplier<? extends Game> ctor = map.get(in.nextInt());
        ctor.get().play(name);
    }
}
