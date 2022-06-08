package hexlet.code;


import hexlet.code.games.*;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class App {
    public static final String[] MENU = {
        "Welcome to the Brain Games!\n",
        "Please enter the game number and press Enter.\n",
        "1. Greeting.\n",
        "2. Even.\n",
        "3. Calculator.\n",
        "4. GCD.\n",
        "5. Progression.\n",
        "6. Prime.\n",
        "0. Exit.\n",
        "Your choose: "
    };
    public static void main(String[] args) {
        App.start();
    }
    public static void start() {
        for (String line : MENU) {
            System.out.print(line);
        }
        List<Supplier<? extends Game>> list = List.of(
                Exit::new,
                Greeting::new,
                Even::new,
                Calculator::new,
                GreatestCommonDivider::new,
                Progression::new,
                Prime::new
        );
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
