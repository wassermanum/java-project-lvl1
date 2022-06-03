package hexlet.code.games;

import java.util.Random;

public class GameUtils {
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
}
