package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Prime {
    private static final String RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int RANGE = 100;

    public static void startGame() {
        HashMap<String, String> gameData = new HashMap<>();

        while (gameData.size() < Engine.ROUNDS) {
            generateRoundData(gameData);
        }

        Engine.initGame(RULE, gameData);
    }

    private static void generateRoundData(HashMap<String, String> data) {

        int question = Utils.getRandomPositiveNumber(RANGE);
        String answer = isPrime(question) ? "yes" : "no";

        data.put(String.valueOf(question), answer);
    }

    private static boolean isPrime(int number) {
        boolean result = number != 1;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
