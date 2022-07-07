package hexlet.code;

import hexlet.code.domain.QuestionAnswerPair;

import java.util.List;
import java.util.Scanner;

public final class Engine {
    public static void runGame(List<QuestionAnswerPair> gameData, String rules) {
        Scanner in = new Scanner(System.in);

        System.out.print("May I have your name? ");
        String name = in.nextLine();
        System.out.printf("Hello, %s! \n", name);
        System.out.println(rules);

        for (QuestionAnswerPair pair : gameData) {
            System.out.printf("Question: %s\n", pair.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = in.nextLine();

            if (!pair.getAnswer().equalsIgnoreCase(userAnswer)) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                        userAnswer,
                        pair.getAnswer()
                );
                System.out.printf("Let's try again, %s!\n", name);
                return;
            } else {
                System.out.println("Correct!");
            }
        }

        System.out.printf("Congratulations, %s!\n", name);
    }
}
