package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.GameUtils;

import java.util.ArrayList;
import java.util.List;

public final class GreatestCommonDivider implements Game {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;
    private static final int ROUND_COUNT = 3;
    public void play() {
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        int answer;
        String name = Cli.greetings();
        System.out.println("Find the greatest common divisor of given numbers.");
        for  (int i = 0; i < ROUND_COUNT; i++) {
            int firstValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            int secondValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            answer = GameUtils.greatCommonDivider(firstValue, secondValue);
            questions.add(firstValue + " " + secondValue);
            answers.add(Integer.toString(answer));
        }
        Engine.runGame(questions, answers, name);
    }
}
