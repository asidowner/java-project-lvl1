package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomPositiveNumber(int range) {
        Random random = new Random();
        return Math.abs(random.nextInt(range));
    }
}
