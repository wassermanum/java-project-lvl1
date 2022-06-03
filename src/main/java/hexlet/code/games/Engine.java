package hexlet.code.games;

import java.util.List;
import java.util.Scanner;

public class Engine {
    public static void runGame(List<String> questions, List<String> answers, String name) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < questions.size(); i++) {
            System.out.printf("Question: %s\n", questions.get(i));
            System.out.print("Your answer: ");
            String userAnswer = in.nextLine();
            if (!answers.get(i).equalsIgnoreCase(userAnswer)) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, answers.get(i));
                System.out.printf("Let's try again, %s!\n", name);
                break;
            } else {
                System.out.println("Correct!");
            }
            if (i == questions.size() - 1) {
                System.out.printf("Congratulations, %s\n!", name);
            }
        }
    }
}
