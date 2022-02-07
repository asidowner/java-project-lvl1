package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Prime {
    public static void startGame() {
        HashMap<String, String> questions = new HashMap<>();

        for (int i = 0; i < Engine.getRoundsCount(); i++) {
            generateRoundData(questions);
        }

        final String rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        Engine.initGame(rule, questions);
    }

    private static void generateRoundData(HashMap<String, String> data) {
        final int range = 100;

        int question = Utils.getRandomPositiveNumber(range);
        String answer = isPrime(question) ? "yes" : "no";

        data.put(String.valueOf(question), answer);
    }

    private static boolean isPrime(int number) {
        boolean result = true;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
