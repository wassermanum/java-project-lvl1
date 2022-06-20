package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.GameUtils;
import hexlet.code.domain.QuestionAnswerPair;

import java.util.ArrayList;
import java.util.List;

public final class Prime implements Game {
    private static final int MIN_RANGE = 2;
    private static final int MAX_RANGE = 100;
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public void play() {
        List<QuestionAnswerPair> gameData = new ArrayList<>();
        int question;
        String answer;
        for (int i = 0; i < GameUtils.ROUNDS; i++) {
            question = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            if (GameUtils.checkIsPrime(question)) {
                answer = "yes";
            } else {
                answer = "no";
            }
            gameData.add(new QuestionAnswerPair(Integer.toString(question), answer));
        }
        Engine.runGame(gameData, RULES);
    }
}
