package hexlet.code.games;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.GameUtils;
import hexlet.code.domain.QuestionAnswerPair;

import java.util.ArrayList;
import java.util.List;
public final class Calculator implements Game {

    private static final char[] OPERATORS = new char[]{'+', '-', '*'};
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;
    private static final String RULES = "What is the result of the expression?";

    public void play() {
        DoubleEvaluator eval = new DoubleEvaluator();
        List<QuestionAnswerPair> gameData = new ArrayList<>();
        int answer;
        for (int i = 0; i < GameUtils.ROUNDS; i++) {
            int firstValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            int secondValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            String question = firstValue
                    + " "
                    + OPERATORS[(int) (Math.random() * OPERATORS.length)]
                    + " "
                    + secondValue;
            answer = eval.evaluate(question).intValue();
            gameData.add(new QuestionAnswerPair(question, Integer.toString(answer)));
        }
        Engine.runGame(gameData, RULES);
    }
}
