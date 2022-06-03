package hexlet.code.games;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.GameUtils;

import java.util.ArrayList;
import java.util.List;
public final class Calculator implements Game {

    private static final char[] OPERATORS = new char[]{'+', '-', '*'};
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;
    private static final int ROUND_COUNT = 3;

    public void play() {
        DoubleEvaluator eval = new DoubleEvaluator();
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        int userAnswer;
        String name = Cli.greetings();
        System.out.println("What is the result of the expression?");
        for (int i = 0; i < ROUND_COUNT; i++) {
            int firstValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            int secondValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            String question = firstValue
                    + " "
                    + OPERATORS[(int) (Math.random() * OPERATORS.length)]
                    + " "
                    + secondValue;
            userAnswer = eval.evaluate(question).intValue();
            questions.add(question);
            answers.add(Integer.toString(userAnswer));
        }
        Engine.runGame(questions, answers, name);
    }
}
