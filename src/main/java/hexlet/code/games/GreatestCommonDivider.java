package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.GameUtils;
import hexlet.code.domain.QuestionAnswerPair;

import java.util.ArrayList;
import java.util.List;

public final class GreatestCommonDivider implements Game {


    private static final int MIN_RANGE = 0;

    private static final int MAX_RANGE = 100;

    private static final String RULES = "Find the greatest common divisor of given numbers.";


    private static int greatCommonDivider(int value1, int value2) {
        if (value2 == 0) {
            return value1;
        }
        return greatCommonDivider(value2, value1 % value2);
    }

    public void play() {
        List<QuestionAnswerPair> gameData = new ArrayList<>();
        int answer;

        for  (int i = 0; i < GameUtils.ROUNDS; i++) {
            int firstValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            int secondValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            answer = greatCommonDivider(firstValue, secondValue);
            gameData.add(new QuestionAnswerPair(firstValue + " " + secondValue, Integer.toString(answer)));
        }

        Engine.runGame(gameData, RULES);
    }
}
