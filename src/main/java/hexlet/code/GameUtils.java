package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameUtils {
    public static final int ROUNDS = 3;
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
    public static int greatCommonDivider(int value1, int value2) {
        if (value2 == 0) {
            return value1;
        }
        return greatCommonDivider(value2, value1 % value2);
    }
    public static String checkIsPrime(int value) {
        String isPrime = "yes";
        int temp;
        for (int i = 2; i < value / 2; i++) {
            temp = value % i;
            if (temp == 0) {
                isPrime = "no";
                break;
            }
        }
        return isPrime;
    }
    public static List<String> generateProgression(int elementsQuantity, int initialElement, int progressionStep) {
        List<String> progression = new ArrayList<>();
        for (int i = 0; i < elementsQuantity; i++) {
            progression.add(Integer.toString(initialElement));
            initialElement += progressionStep;
        }
        return progression;
    }
}
