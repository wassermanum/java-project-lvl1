package hexlet.code.games;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import hexlet.code.Cli;
import hexlet.code.Game;
import java.util.Scanner;
public final class Calculator implements Game {

    private static final char[] OPERATORS = new char[]{'+', '-', '*', '/'};
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;
    private static final int ROUND_COUNT = 3;
    private int firstValue;
    private int secondValue;
    public void play() {
        char[] operators = {'+', '-', '*'};
        DoubleEvaluator eval = new DoubleEvaluator();
        Scanner in = new Scanner(System.in);
        int answer;
        String question;
        String name = Cli.greetings();
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < ROUND_COUNT; i++) {
            firstValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            secondValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            question = String.valueOf(
                    firstValue
                            + " "
                            + operators[(int) (Math.random() * operators.length)]
                            + " "
                            + secondValue
            );
            System.out.println("Question: " + question);
            System.out.printf("Your answer: ");
            answer = in.nextInt();
            if (answer == eval.evaluate(question).intValue()) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%d' is wrong answer ;(. Correct answer was '%d'\n.",
                        answer,
                        eval.evaluate(question).intValue()
                );
                System.out.printf("Let's try again, %s!", name);
                break;
            }
            if (i == ROUND_COUNT - 1) {
                System.out.printf("Congratulations, %s! \n", name);
            }
        }
    }
}
