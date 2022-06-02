package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Game;
import java.util.Scanner;


public final class Even implements Game {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;
    private static final int ROUND_COUNT = 3;

    public void play() {
        int question;
        String answer;
        String name = Cli.greetings();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < ROUND_COUNT; i++) {
            question = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            System.out.printf("Question: %d \n", question);
            System.out.print("Your answer: ");
            answer = in.nextLine();
            if (
                    (question % 2 == 0 && answer.toLowerCase().equals("yes"))
                    || (question % 2 == 1 && answer.toLowerCase().equals("no"))
            ) {
                System.out.println("Correct!");
            } else {
                System.out.printf("Let's try again, %s! \n", name);
                break;
            }
            if (i == ROUND_COUNT - 1) {
                System.out.printf("Congratulations, %s! \n", name);
            }
        }
    }
}
