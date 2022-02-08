package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static int getRandomPositiveNumber(int range) {
        Random random = new Random();
        int result = 0;
        while (result == 0) {
            result = Math.abs(random.nextInt(range));
        }
        return result;
    }

    public static String getNextInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
