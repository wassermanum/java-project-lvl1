package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Game;
import hexlet.code.GameUtils;

import java.util.ArrayList;
import java.util.List;

public final class Progression implements Game {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;
    private static final int ROUND_COUNT = 3;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_PROGRESSION_STEP = 10;
    public void play() {
        String name = Cli.greetings();
        System.out.println("What number is missing in the progression?");
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < ROUND_COUNT; i++) {
            int progressionElement = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            int elementsAmount = GameUtils.getRandomNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int questionPosition = GameUtils.getRandomNumber(0, elementsAmount);
            int progressionStep = GameUtils.getRandomNumber(1, MAX_PROGRESSION_STEP);
            StringBuilder question = new StringBuilder("");
            for (int j = 0; j < elementsAmount; j++) {
                if (j != questionPosition) {
                    question.append(progressionElement).append(" ");
                } else {
                    question.append(".. ");
                    answers.add(Integer.toString(progressionElement));
                }
                progressionElement += progressionStep;
            }
            questions.add(question.toString());
        }
        Engine.runGame(questions, answers, name);
    }
}
