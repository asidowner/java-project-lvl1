package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static int getRandomPositiveNumber(int range) {
        Random random = new Random();
        return Math.abs(random.nextInt(range));
    }

    public static String getNextInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
