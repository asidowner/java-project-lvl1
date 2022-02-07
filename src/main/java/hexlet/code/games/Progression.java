package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Progression {
    public static void startGame() {
        HashMap<String, String> questions = new HashMap<>();

        final int rounds = 3;
        for (int i = 0; i < rounds; i++) {
            generateRoundData(questions);
        }

        final String rule = "What number is missing in the progression?";
        Engine.initGame(rule, questions);
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
        final int range = 100;
        final int incrementRange = range / 4;
        final int arrayRange = 10;

        int increment = Utils.getRandomPositiveNumber(incrementRange) + Utils.getRandomPositiveNumber(incrementRange);
        int[] progression = new int[arrayRange];
        int firstNumber = Utils.getRandomPositiveNumber(range);

        for (int i = 0; i < progression.length; i++) {
            progression[i] = firstNumber + i * increment;
        }

        return progression;
    }
}
