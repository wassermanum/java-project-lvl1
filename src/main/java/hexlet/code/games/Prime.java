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


    private static boolean checkIsPrime(int value) {
        boolean isPrime = true;
        int temp;

        for (int i = 2; i < value / 2; i++) {
            temp = value % i;
            if (temp == 0) {
                break;
            }
        }
        return isPrime;
    }

    public void play() {
        List<QuestionAnswerPair> gameData = new ArrayList<>();
        int question;
        String answer;

        for (int i = 0; i < GameUtils.ROUNDS; i++) {
            question = GameUtils.getRandomNumber(MIN_RANGE, MAX_RANGE);
            answer = checkIsPrime(question) ? "yes" : "no";
            gameData.add(new QuestionAnswerPair(Integer.toString(question), answer));
        }

        Engine.runGame(gameData, RULES);
    }
}
