package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class GCD {
    private static final String RULE = "Find the greatest common divisor of given numbers.";
    private static final int RANGE = 500;

    public static void startGame() {
        HashMap<String, String> gameData = new HashMap<>();

        while (gameData.size() < Engine.ROUNDS) {
            generateRoundData(gameData);
        }

        Engine.initGame(RULE, gameData);
    }

    private static void generateRoundData(HashMap<String, String> data) {
        int firstNumber = Utils.getRandomPositiveNumber(RANGE);
        int secondNumber = Utils.getRandomPositiveNumber(RANGE);

        int answer = getGCD(firstNumber, secondNumber);

        data.put(firstNumber + " " + secondNumber, String.valueOf(answer));
    }

    private static int getGCD(int firstNumber, int secondNumber) {
        int result = 1;
        for (int i = 1; i <= Math.min(firstNumber, secondNumber); i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                result = i;
            }
        }
        return result;
    }


}
