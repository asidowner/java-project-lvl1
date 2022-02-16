package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Progression {
    private static final String RULE = "What number is missing in the progression?";
    private static final int RANGE = 100;
    private static final int INCREMENT_RANGE = RANGE / 4;
    private static final int ARRAY_RANGE = 10;
    private static final int MIN_ARRAY_RANGE = 5;

    public static void startGame() {
        HashMap<String, String> gameData = new HashMap<>();

        while (gameData.size() < Engine.ROUNDS) {
            generateRoundData(gameData);
        }

        Engine.initGame(RULE, gameData);
    }

    private static void generateRoundData(HashMap<String, String> data) {

        int increment = Utils.getRandomPositiveNumber(INCREMENT_RANGE) + Utils.getRandomPositiveNumber(INCREMENT_RANGE);
        int firstNumber = Utils.getRandomPositiveNumber(RANGE);
        int range  = MIN_ARRAY_RANGE + Utils.getRandomPositiveNumber(ARRAY_RANGE);

        int[] progression = getArithmeticProgression(increment, firstNumber, range);

        int randomIndex = Utils.getRandomPositiveNumber(progression.length - 1);
        int answer = progression[randomIndex];

        StringBuilder question = new StringBuilder();

        for (int j = 0; j < progression.length; j++) {
            question.append(j == randomIndex ? ".." : String.valueOf(progression[j])).append(" ");
        }

        data.put(question.toString(), String.valueOf(answer));
    }


    private static int[] getArithmeticProgression(int firstNumber, int increment, int range) {
        int[] progression = new int[range];

        for (int i = 0; i < progression.length; i++) {
            progression[i] = firstNumber + i * increment;
        }

        return progression;
    }
}
