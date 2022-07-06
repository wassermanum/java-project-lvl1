package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.GameUtils;
import hexlet.code.domain.QuestionAnswerPair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public final class Calculator implements Game {


    private static final char[] OPERATORS = new char[]{'+', '-', '*'};

    private static final Map<Character, BiFunction<Integer, Integer, Integer>> OPERATIONS = Map.of(
            OPERATORS[0], Integer::sum,
            OPERATORS[1], (Integer a, Integer b) -> a - b,
            OPERATORS[2], (Integer a, Integer b) -> a * b);

    private static final int MIN_RANGE = 0;

    private static final int MAX_RANGE = 100;

    private static final String RULES = "What is the result of the expression?";


    public void play() {
        List<QuestionAnswerPair> gameData = new ArrayList<>();
        int answer;

        for (int i = 0; i < GameUtils.ROUNDS; i++) {
            int firstValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            int secondValue = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            char operator = OPERATORS[(int) (Math.random() * OPERATORS.length)];
            String question = firstValue + " " + operator + " " + secondValue;
            answer = OPERATIONS.get(operator).apply(firstValue, secondValue);
            gameData.add(new QuestionAnswerPair(question, Integer.toString(answer)));
        }

        Engine.runGame(gameData, RULES);
    }
}
