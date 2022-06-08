package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.GameUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public final class Even implements Game {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public void play() {
        int question;
        String answer;
        List<QuestionAnswerPair> gameData = new ArrayList<>();
        List<String> questions = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < GameUtils.ROUNDS; i++) {
            question = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            questions.add(Integer.toString(question));
            if (question % 2 == 0) {
                answer = "yes";
            } else {
                answer = "no";
            }
            gameData.add(new QuestionAnswerPair(Integer.toString(question), answer));
        }
        Engine.runGame(gameData, RULES);
    }
}
