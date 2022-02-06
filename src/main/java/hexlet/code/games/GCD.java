package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;

public class GCD {
    public static String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static HashMap<String, String> getQuestions(int rounds) {
        final int range = 1000;
        HashMap<String, String> questions = new HashMap<>();
        for (int i = 0; i < rounds; i++) {
            int firstNumber = Engine.getRandomPositiveNumber(range);
            int secondNumber = Engine.getRandomPositiveNumber(range);

            int answer = Engine.getGCD(firstNumber, secondNumber);
            questions.put(firstNumber + " " + secondNumber, String.valueOf(answer));
        }
        return questions;
    }

}
