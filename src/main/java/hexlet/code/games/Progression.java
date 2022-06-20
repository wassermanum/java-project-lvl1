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
    public void play() {
        List<QuestionAnswerPair> gameData = new ArrayList<>();
        String answer;
        for (int i = 0; i < GameUtils.ROUNDS; i++) {
            int progressionElement = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            int elementsAmount = GameUtils.getRandomNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int progressionStep = GameUtils.getRandomNumber(1, MAX_PROGRESSION_STEP);
            int questionNumber = GameUtils.getRandomNumber(0, elementsAmount);
            List<String> question = new ArrayList<>();
            /*for (int j = 0; j < elementsAmount; j++) {
                question.add(Integer.toString(progressionElement));
                progressionElement += progressionStep;
            }*/
            question = GameUtils.generateProgression(elementsAmount, progressionElement, progressionStep);
            answer = question.get(questionNumber);
            question.set(questionNumber, "..");
            gameData.add(new QuestionAnswerPair(String.join(" ", question), answer));
        }
        Engine.runGame(gameData, RULES);
    }
}
