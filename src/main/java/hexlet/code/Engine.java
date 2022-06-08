package hexlet.code;

import hexlet.code.games.QuestionAnswerPair;

import java.util.List;
import java.util.Scanner;

public final class Engine {
    public static void runGame(List<QuestionAnswerPair> gameData, String rules) {
        Scanner in = new Scanner(System.in);
        String name = Cli.greetings();
        System.out.println(rules);
        for (int i = 0; i < gameData.size(); i++) {
            System.out.printf("Question: %s\n", gameData.get(i).getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = in.nextLine();
            if (!gameData.get(i).getAnswer().equalsIgnoreCase(userAnswer)) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                        userAnswer,
                        gameData.get(i).getAnswer()
                );
                System.out.printf("Let's try again, %s!\n", name);
                break;
            } else {
                System.out.println("Correct!");
            }
            if (i == gameData.size() - 1) {
                System.out.printf("Congratulations, %s!\n", name);
            }
        }
    }
}
