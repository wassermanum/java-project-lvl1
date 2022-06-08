package hexlet.code;


import hexlet.code.games.*;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        App.start();
    }
    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        List<Supplier<? extends Game>> list = List.of(
                Exit::new,
                Greeting::new,
                Even::new,
                Calculator::new,
                GreatestCommonDivider::new,
                Progression::new,
                Prime::new
        );
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1. Greeting.");
        System.out.println("2. Even.");
        System.out.println("3. Calculator.");
        System.out.println("4. GCD.");
        System.out.println("5. Progression.");
        System.out.println("6. Prime.");
        System.out.println("0. Exit.");
        System.out.print("Your choose: ");
        Scanner in = new Scanner(System.in);
        int gameChoice = in.nextInt();
        if (gameChoice < 0 || gameChoice >= list.size()) {
            System.out.println("Wrong choice!");
            System.exit(0);
        }
        Supplier<? extends Game> ctor = list.get(gameChoice);
        ctor.get().play();
    }
}
