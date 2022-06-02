package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.Greeting;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        Map<Integer, Supplier<? extends Game>> map = Map.of(
                0, () -> new Greeting(),
                1, () -> new Even(),
                2, () -> new Calculator()
        );
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("0. Greeting.");
        System.out.println("1. Even.");
        System.out.println("2. Calculator.");
        System.out.println("Your choose: ");
        Scanner in = new Scanner(System.in);
        Supplier<? extends Game> ctor = map.get(in.nextInt());
        if (ctor == null) {
            System.out.println("No such game");
        } else {
            ctor.get().play();
        }
    }
}
