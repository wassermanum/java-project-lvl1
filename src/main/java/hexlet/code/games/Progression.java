package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.GameUtils;
import hexlet.code.domain.QuestionAnswerPair;

import java.util.ArrayList;
import java.util.List;

public final class Progression implements Game {


    private static final int MIN_RANGE = 0;

    private static final int MAX_RANGE = 100;

    private static final int MIN_PROGRESSION_LENGTH = 5;

    private static final int MAX_PROGRESSION_LENGTH = 10;

    private static final int MAX_PROGRESSION_STEP = 10;

    private static final String RULES = "What number is missing in the progression?";


    private static List<String> generateProgression(int elementsQuantity, int initialElement, int progressionStep) {
        List<String> progression = new ArrayList<>();

        for (int i = 0; i < elementsQuantity; i++) {
            progression.add(Integer.toString(initialElement));
            initialElement += progressionStep;
        }
        return progression;
    }

    public void play() {
        List<QuestionAnswerPair> gameData = new ArrayList<>();
        String answer;

        for (int i = 0; i < GameUtils.ROUNDS; i++) {
            int progressionElement = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            int elementsAmount = GameUtils.getRandomNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int progressionStep = GameUtils.getRandomNumber(1, MAX_PROGRESSION_STEP);
            int questionNumber = GameUtils.getRandomNumber(0, elementsAmount);
            List<String> question;
            question = generateProgression(elementsAmount, progressionElement, progressionStep);
            answer = question.get(questionNumber);
            question.set(questionNumber, "..");
            gameData.add(new QuestionAnswerPair(String.join(" ", question), answer));
        }

        Engine.runGame(gameData, RULES);
    }
}
