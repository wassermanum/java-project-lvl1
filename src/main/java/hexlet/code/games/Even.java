package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.GameUtils;
import hexlet.code.domain.QuestionAnswerPair;

import java.util.ArrayList;
import java.util.List;


public final class Even implements Game {


    private static final int MIN_RANGE = 0;

    private static final int MAX_RANGE = 100;

    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";


    public void play() {
        List<QuestionAnswerPair> gameData = new ArrayList<>();

        for (int i = 0; i < GameUtils.ROUNDS; i++) {
            int question = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            String answer = question % 2 == 0 ? "yes" : "no";
            gameData.add(new QuestionAnswerPair(Integer.toString(question), answer));
        }

        Engine.runGame(gameData, RULES);
    }
}
