package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class GCD {
    private static final String RULE = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        HashMap<String, String> questions = new HashMap<>();

        while (questions.size() < Engine.ROUNDS) {
            generateRoundData(questions);
        }

        Engine.initGame(RULE, questions);
    }

    private static void generateRoundData(HashMap<String, String> data) {
        final int range = 500;

        int firstNumber = Utils.getRandomPositiveNumber(range);
        int secondNumber = Utils.getRandomPositiveNumber(range);

        int answer = 1;

        for (int i = 1; i <= Math.min(firstNumber, secondNumber); i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                answer = i;
            }
        }

        data.put(firstNumber + " " + secondNumber, String.valueOf(answer));
    }


}
