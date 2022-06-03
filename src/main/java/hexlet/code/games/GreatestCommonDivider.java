package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Game;

import java.util.Scanner;

public final class GreatestCommonDivider implements Game {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;
    private static final int ROUND_COUNT = 3;
    public void play() {
        Scanner in = new Scanner(System.in);
        String name = Cli.greetings();
        System.out.println("Find the greatest common divisor of given numbers.");
        for  (int i = 0; i < ROUND_COUNT; i++) {
            int firstValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            int secondValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            System.out.printf("Question: %d %d?\n", firstValue, secondValue);
            System.out.print("Your answer: ");
            int answer = in.nextInt();
            int question = GameUtils.greatCommonDivider(firstValue, secondValue);
            if (answer != question) {
                System.out.printf("'%d' is wrong answer ;(. Correct answer was '%d'.\n", answer, question);
                System.out.printf("Let's try again, %s!\n", name);
                break;
            }
            System.out.println("Correct!");
            if (i == ROUND_COUNT - 1) {
                System.out.printf("Congratulations, %s!\n", name);
            }
        }
    }
}
