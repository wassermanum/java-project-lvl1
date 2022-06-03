package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Game;

import java.util.ArrayList;
import java.util.List;

public final class Prime implements Game {
    private static final int MIN_RANGE = 2;
    private static final int MAX_RANGE = 100;
    private static final int ROUND_COUNT = 3;
    public void play() {
        String name = Cli.greetings();
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        int question;
        for (int i = 0; i < ROUND_COUNT; i++) {
            question = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            questions.add(Integer.toString(question));
            if (GameUtils.checkIsPrime(question)) {
                answers.add("yes");
            } else {
                answers.add("no");
            }
        }
        Engine.runGame(questions, answers, name);
    }
}
