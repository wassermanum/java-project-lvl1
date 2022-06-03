package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public final class Even implements Game {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;
    private static final int ROUND_COUNT = 3;

    public void play() {
        Integer question;
        String name = Cli.greetings();
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < ROUND_COUNT; i++) {
            question = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            questions.add(question.toString());
            if (question % 2 == 0) {
                answers.add("yes");
            } else {
                answers.add("no");
            }
        }
        Engine.runGame(questions, answers, name);
    }
}
