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
}
