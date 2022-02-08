package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Progression {
    private static final String RULE = "What number is missing in the progression?";
    private static final int RANGE = 100;
    private static final int INCREMENT_RANGE = RANGE / 4;
    private static final int ARRAY_RANGE = 10;

    public static void startGame() {
        HashMap<String, String> questions = new HashMap<>();

        while (questions.size() < Engine.ROUNDS) {
            generateRoundData(questions);
        }

        Engine.initGame(RULE, questions);
    }

    private static void generateRoundData(HashMap<String, String> data) {
        int[] progression = getArithmeticProgression();
        int randomIndex = Utils.getRandomPositiveNumber(progression.length - 1);
        int answer = progression[randomIndex];

        StringBuilder question = new StringBuilder();

        for (int j = 0; j < progression.length; j++) {
            question.append(j == randomIndex ? ".." : String.valueOf(progression[j])).append(" ");
        }

        data.put(question.toString(), String.valueOf(answer));
    }


    private static int[] getArithmeticProgression() {
        int increment = Utils.getRandomPositiveNumber(INCREMENT_RANGE) + Utils.getRandomPositiveNumber(INCREMENT_RANGE);
        int[] progression = new int[ARRAY_RANGE];
        int firstNumber = Utils.getRandomPositiveNumber(RANGE);

        for (int i = 0; i < progression.length; i++) {
            progression[i] = firstNumber + i * increment;
        }

        return progression;
    }
}
